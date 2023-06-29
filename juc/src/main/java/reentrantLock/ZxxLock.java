package reentrantLock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class ZxxLock {

    private static final Unsafe unsafe = getUnsafe();

    private volatile int state;

    private static long stateOffset;

    static {
        try {
            assert unsafe != null;
            stateOffset = unsafe.objectFieldOffset(ZxxLock.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void lock() {
        //判断当前线程要不要加锁
        /**
         * compareAndSwapInt方法中第一个参数为修改的哪个对象中的属性
         * 第二个属性为要修改值的偏移量
         * 第三个参数为预期值
         * 第四个参数为当修改后的值
         */
        while (true){
            assert unsafe != null;
            if (unsafe.compareAndSwapInt(this, stateOffset, 0, 1)) break;
            System.out.println(Thread.currentThread().getName()+"正在加锁");
        }
        System.out.println(Thread.currentThread().getName()+"加到锁了");
    }

    public void unlock() {
        state = 0;
    }
}
