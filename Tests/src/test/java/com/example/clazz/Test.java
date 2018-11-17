package com.example.clazz;

public class Test {
	static {
		i = 0;
//		System.out.println(i);		非法向前引用
	}

	static int i = 1;
	
	static class Parent{
		public static int A = 1;
		static {
			A = 2;
		}
	}
	static class Sub extends Parent{
		private static int B = A;
	}
	public static void main(String[] args) {
		System.out.println(Sub.B);
	}
}

