package com.gyw.test;
/**
 * ��������forѭ��
 * @description java �༭���н����ָ���������ϣ�����ʾ�������ص�java�ĵ���Ϣ��
 *
 * @author ��һΰ
 * @since 1.5
 */
public class ForTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("ѭ����ֹ����");
		for (int j = 0; j < 5; j++) {
			System.out.println("j=" + j);
			for (int i = 0; i < 5; i++) {
				System.out.println("ѭ����ֹ����i=" + i);
				if (i == 3) {
				}
			}
		}
		System.out.println("**********-------------*************");
		for (int j = 0; j < 5; j++) {
			System.out.println("j=" + j);
			for (int i = 0; i < 5; i++) {
				System.out.println("ѭ����ֹ����i=" + i);
				if (i == 3) {
					continue;
				}
			}
		}
		System.out.println("**********-------------*************");
		flag: for (int j = 0; j < 5; j++) {
			System.out.println("j=" + j);
			for (int i = 0; i < 5; i++) {
				System.out.println("ѭ����ֹ����i=" + i);
				if (i == 3) {
					continue flag;
				}
			}
		}

		// TODO ���ѭ��,outer��Ϊ��ʶ��
		outer: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("i��ֵΪ:" + i + " j��ֵΪ:" + j);
				if (j == 1) {
					// ����outer��ǩ����ʶ��ѭ��
					break outer;
				}
			}
		}
		System.out.println("---------------------------------------------");
		outer1: for (int i = 0; i < 5; i++) {
			outer2: for (int j = 0; j < 3; j++) {
				System.out.println("i��ֵΪ:" + i + " j��ֵΪ:" + j);
				if (j == 1) {
					// ����outer��ǩ����ʶ��ѭ�� �����´�ѭ��
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
				System.out.println("i��ֵΪ:" + i + " j��ֵΪ:" + j);
				if (j == 1) {
					// ����outer��ǩ����ʶ��ѭ�� �����´�ѭ��
					continue outer2;
				}
			}
		}
	}
	
	public void method() {
		test();
	}
}
