package com.gyw.�쳣;

public class MyRuntimeException extends RuntimeException{

	public MyRuntimeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MyRuntimeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyRuntimeException(String message) {
		super(message);
		System.out.println("��׽�����쳣��"+message);
	}

	public MyRuntimeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
