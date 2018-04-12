package com.design.pattern;

/**
 * 设计一个类，智能生成该类的一个实例
 * @author dream
 *
 */
public class Singleton {
	
	//线程安全
	public static class Singleton0 {
		private final static Singleton INSTANCE = new Singleton();
		private Singleton0() {
		}
		public static Singleton getInstance() {
			return INSTANCE;
		}
	}
	
	//线程不安全
	public static class Singleton1 {
		private static Singleton1 instance = null;
		private Singleton1() {
		}
		public static Singleton1 getInstance() {
			if (instance == null) {
				instance = new Singleton1();
			}
			return instance;
		}
	}
	
	//线程安全，多线程环境下效率不高
	public static class Singleton2 {
		private static Singleton2 instance = null;
		private Singleton2() {
		}
		public static synchronized Singleton2 getInstance(){
			if (instance == null) {
				instance = new Singleton2();
			}
			return instance;
		}
	}
	
	//线程安全
	public static class Singleton3 {
		private static Singleton3 instance = null;
		static {
			instance = new Singleton3();
		}
		private Singleton3() {
		}
		public static Singleton3 getInstance() {
			return instance;
		}
	}
	
	//使用静态内部类，线程安全
	public static class Singleton4 {
		private static class SingletonHolder {
			private static final Singleton4 INSTANCE = new Singleton4();
		}
		private Singleton4() {
		}
		public static Singleton4 getInstance() {
			return SingletonHolder.INSTANCE;
		}
	}
	
	//使用静态内部类，使用枚举方式，线程安全
	public enum Singleton5 {
		INSTANCE;
		public void whateverMethod() {
		}
	}
	
	//静态内部类，使用双重校验锁，线程安全
	public static class Singleton6 {
		private volatile static Singleton6 instance = null;
		private Singleton6() {
		}
		public static Singleton6 getInstance() {
			if (instance == null) {
				synchronized (Singleton6.class) {
					if (instance == null) {
						instance = new Singleton6();
					}
				}
			}
			return instance;
		}
	}

	public static void main(String[] args) {
		System.out.println(Singleton0.getInstance() == Singleton0.getInstance());  
        System.out.println(Singleton1.getInstance() == Singleton1.getInstance());  
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());  
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());  
        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());  
        System.out.println(Singleton5.INSTANCE == Singleton5.INSTANCE);  
        System.out.println(Singleton6.getInstance() == Singleton6.getInstance());  
	}
}
