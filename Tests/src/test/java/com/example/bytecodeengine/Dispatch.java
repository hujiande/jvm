package com.example.bytecodeengine;

/**
 * 单分派 多分派演示
 * 
 * @author hujiande
 *
 */
public class Dispatch {

	static class QQ {
	}

	static class _360 extends QQ {
	}

	public static class Father {
		public void choice(QQ arg) {
			System.out.println("father choice qq");
		}

		public void choice(_360 arg) {
			System.out.println("father choice 360");
		}
	}

	public static class Son extends Father {
		public void choice(QQ arg) {
			System.out.println("son choice qq");
		}

		public void choice(_360 arg) {
			System.out.println("son choice 360");
		}
	}

	public static void main(String[] args) {
		Father father = new Father();
		Father son = new Son();
		father.choice(new _360());
		son.choice(new QQ());
	}
}
