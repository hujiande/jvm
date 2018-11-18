package com.example.bytecodeengine;


/**
 * 方法静态解析演示
 * @author hujiande
 *
 */
public class StaticResolution {
	
	public static void sayHello() {
		System.out.println("hello word!");
	}

	public static void main(String[] args) {
		StaticResolution.sayHello();
	}
}
