package com.spring;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XiaoXiongApplicationContext {

    private Class configClass;

    //我们注入的类有作用域，（单例，多例）该Map存放的是单例对象
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>(); //单例池
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(); //存放刚开始扫描到所有BeanDefinition的定义
    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public XiaoXiongApplicationContext(Class configClass) {
        this.configClass = configClass;

        //通过注解ComponentScan中路径扫描BeanDefinition
        scan(configClass);

        //判断如果beanDefinition中的bean为单例，则将该bean放入单例池中
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if (beanDefinition.getScope().equals("singleton")) {
                Object bean = creatBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }

    }

    //根据Bean的定义创建一个Bean的对象
    public Object creatBean(String beanName, BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getClazz();
        try {

            //实例化得到一个对象
            Object instance = clazz.getDeclaredConstructor().newInstance();

            //依赖注入(对属性进行赋值),根据BeanName获取属性暂时只支持单例模式
            for (Field declaredField : clazz.getDeclaredFields()) {

                //对加了Autowired注解的属性进行赋值，
                if (declaredField.isAnnotationPresent(Autowired.class)) {

                    Object bean = getBean(declaredField.getName());
                    declaredField.setAccessible(true);
                    //将bean对象值设置
                    declaredField.set(instance, bean);
                }
            }

            //Aware回调
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }

            //初始化之前调用这个方法，用户在对象初始化前的对象进行加工
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
            }
            //初始化
            if (instance instanceof InitializingBean) {
                try {
                    ((InitializingBean) instance).afterPropertiesSet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //初始化之前调用这个方法，用户在对象初始化前的对象进行加工
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
            }
            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void scan(Class configClass) {
        //获取ComponentScan这个注解，从配置类中获取将要注入的springBean路径
        ComponentScan componentScanAnnotations = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScanAnnotations.value();
        path = path.replace(".", "/");
        System.out.println("path = " + path);

        /**
         * 扫描配置ComponentSan注解路径下的所有类
         */
        //获取我们写的class编译后的路径
        ClassLoader classLoader = XiaoXiongApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                System.out.println("f = " + f);
                String fileName = f.getAbsolutePath();
                if (fileName.endsWith(".class")) {

                    String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                    className = className.replace("\\", ".");

                    try {
                        //将.class文件加载成class对象
                        Class<?> clazz = classLoader.loadClass(className);
                        //判断是否是有Component注解的类
                        if (clazz.isAnnotationPresent(Component.class)) {

                            //判断当前类是否实现了BeanPostProcessor,instanceOf判断的是类型，clazz是类所以不可以使用
                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {

                                BeanPostProcessor instance = (BeanPostProcessor) clazz.getDeclaredConstructor().newInstance();
                                beanPostProcessorList.add(instance);

                            }
                            //表示当前这个类是一个Bean
                            //解析类，判断当前bean是单例Bean还是prororype的bean
                            Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                            String beanName = componentAnnotation.value();//当前这个类所对应的名字
                            //如果component的value没有设置值时，默认beanname为将对象名的第一个字母变为小写
                            if("".equals(beanName)){
                                beanName = Introspector.decapitalize(clazz.getSimpleName());
                            }
                            //扫描到的bean的定义
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(clazz);
                            //如果没有这个Scope，说明当前类是单例的（默认为单例）,如果有Scope注解则根据配置注解来定义作用域
                            if (clazz.isAnnotationPresent(Scope.class)) {
                                Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());
                            } else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinitionMap.put(beanName, beanDefinition);
                        }
                    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    //通过bean的名字获取bean对象
    public Object getBean(String beanName) {
        //判断传过来的beanName在beanDefinitionMap是否有这个bean如果有则说明是通过Component定义的springBean
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            //从beanDefinitionMap中获取该bean的作用域是否为单例，如果是单例则从单例池中取，否则创建一个bean
            if (beanDefinition.getScope().equals("singleton")) {
                Object o = singletonObjects.get(beanName);
                //单例池放的注入的属性，如果单例池中没有则创建一个bean
//                if(o == null){
//                    //在创建该属性bean的时候。发现该属性bean又依赖之前需要创建的bean，造成了循环依赖
//                    o = creatBean(beanName, beanDefinition);
//                    singletonObjects.put(beanName, o);
//                }
                return o;
            } else {
                //创建bean对象
                Object bean = creatBean(beanName, beanDefinition);
                return bean;
            }
        } else {
            //不存在对应的Bean
            throw new NullPointerException();
        }
    }
}
