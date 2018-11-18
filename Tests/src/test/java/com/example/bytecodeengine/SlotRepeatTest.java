package com.example.bytecodeengine;

/**
 * @author hujiande
 *
 */
public class SlotRepeatTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		{
			byte[] placeholder = new byte[1024 * 1024 * 64];
		}
		//GCRoot 任然有关联
		int a = 10;
		System.gc();
		/**
		 * placeholder 能否被回收的根本原因是：局部变量表中的Slot是否还存在关于placeholder数组对象的引用。
		 */
	}

}
