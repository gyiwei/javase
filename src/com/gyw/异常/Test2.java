package com.gyw.�쳣;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testException01(); //����throws ��try catch
		testException02();
		testRuntimeException01();//�������쳣Ĭ�ϻ���������׳�
		testRuntimeException02();
	}

	private static void testRuntimeException02() {
		throw new MyRuntimeException();
	}
	private static void testRuntimeException01() throws MyRuntimeException{
		throw new MyRuntimeException();
	}

	private static void testException01() throws MyException {
		throw new MyException();
	}
	
	private static void testException02() {
		try {
			throw new MyException();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
	

}
