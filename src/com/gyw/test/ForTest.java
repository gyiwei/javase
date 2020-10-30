package com.gyw.test;
/**
 * 测试跳出for循环
 * @description java 编辑器中将鼠标指针移至类上，将显示与该类相关的java文档信息。
 *
 * @author 郭一伟
 * @since 1.5
 */
public class ForTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("循环终止测试");
		for (int j = 0; j < 5; j++) {
			System.out.println("j=" + j);
			for (int i = 0; i < 5; i++) {
				System.out.println("循环终止测试i=" + i);
				if (i == 3) {
				}
			}
		}
		System.out.println("**********-------------*************");
		for (int j = 0; j < 5; j++) {
			System.out.println("j=" + j);
			for (int i = 0; i < 5; i++) {
				System.out.println("循环终止测试i=" + i);
				if (i == 3) {
					continue;
				}
			}
		}
		System.out.println("**********-------------*************");
		flag: for (int j = 0; j < 5; j++) {
			System.out.println("j=" + j);
			for (int i = 0; i < 5; i++) {
				System.out.println("循环终止测试i=" + i);
				if (i == 3) {
					continue flag;
				}
			}
		}

		// TODO 外层循环,outer作为标识符
		outer: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("i的值为:" + i + " j的值为:" + j);
				if (j == 1) {
					// 跳出outer标签所标识的循环
					break outer;
				}
			}
		}
		System.out.println("---------------------------------------------");
		outer1: for (int i = 0; i < 5; i++) {
			outer2: for (int j = 0; j < 3; j++) {
				System.out.println("i的值为:" + i + " j的值为:" + j);
				if (j == 1) {
					// 跳出outer标签所标识的循环 进行下次循环
					continue outer1;
				}
			}
		}
		
		System.out.println("---------------------------------------------");
		
		test();
		
		
	}

	static void test() {
		for (int i = 0; i < 5; i++) {
			outer2: for (int j = 0; j < 3; j++) {
				System.out.println("i的值为:" + i + " j的值为:" + j);
				if (j == 1) {
					// 跳出outer标签所标识的循环 进行下次循环
					continue outer2;
				}
			}
		}
	}
	
	public void method() {
		test();
	}
}
