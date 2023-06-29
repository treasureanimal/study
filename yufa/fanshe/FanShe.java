package com.study.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 反射就是把类中的方法，属性等各个成分映射成对象
 * @author admin
 *
 */
public class FanShe {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		Class rc = Class.forName("javaTest.Robot");
		System.out.println("Class Name Is"+rc.getName());
		Robot r = (Robot) rc.newInstance();
		Method gethello = rc.getDeclaredMethod("hello", String.class);//获取到该类下边的所有方法，包括私有方法，但是不获取继承或者实现的方法
		gethello.setAccessible(true);//如果方法是私有的，不加这个会报错默认是false
		Object str = gethello.invoke(r, "Tom");//Tom是方法中的参数
		System.out.println("gethello result is " + str);
		
		Method hello = rc.getMethod("sayhi", String.class);//获取该类下边的共有方法
		hello.invoke(r, "Timo");
		Field f = rc.getDeclaredField("name");
		f.setAccessible(true);
		f.set(r,"Bob");
		hello.invoke(r, "welcome");
		
		Method chifan = rc.getMethod("chifan");
		chifan.invoke(r);
		
		
		
		
		//方式一    需要先实例化类   再反射
		Date date = new Date();
		//此处的泛型   只能是  "?"
		Class<?> dts = date.getClass();
		//System.out.println(dts);
		System.out.println(dts.getName());
		
		//方式二  不需要实例化   但需要引入包----import java.util.Date;
		Class<?> dts2 = Date.class;
		System.out.println(dts2.getName());
		
		//方式三   不需要实例化操作   也无需引入包
		try {
			//根据类名称(全路径名)   反射到类
			Class<?> dts3 = Class.forName("java.util.Date");
			System.out.println(dts3.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//总结：
			//除了方式一会产生实例化对象之外    其他两种都不会产生实例化对象
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		t.start();
	}
	
	
}

class Robot{
	private String name;
	
	public void sayhi(String hello) {
		System.out.println("hello"+ name);
		System.out.println("canshu" + hello);
	}
	
	private String hello(String tags) {
		System.out.println(tags+"tags");
		return tags;
	}
	public void chifan() {
		System.out.println("chifan");
	}
}
