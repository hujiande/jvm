package com.example.clazz;

import java.io.IOException;
import java.io.InputStream;

/**
 *       不同的类加载器对 instantOf 关键字运算的结果的影响
 * @author Administrator
 *
 */
public class ClassLoaderTest {
	public static void main(String[] args) throws Exception {
		
		ClassLoader myClassLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if(is == null) {
						return super.loadClass(name);
					}
					byte [] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		
		Object obj = myClassLoader.loadClass("com.example.clazz.ClassLoaderTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.example.clazz.ClassLoaderTest);
	}

}
