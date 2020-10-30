package com.gyw.线程;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// 创建线程池
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

		// 开启一个线程submit execute
		cachedThreadPool.submit(new Runnable() {
			@Override
			public void run() {
				for (int k = 0; k < 100000; k++) {
					System.out.println("执行业务操作……");
				}
			}
		});
		//以下是等线程池的全部线程执行结束后，会自动执行。
		cachedThreadPool.shutdown();
		while (true) {
			if (cachedThreadPool.isTerminated()) {
				long time = System.currentTimeMillis() - start;
				System.out.println("["+new Date()+"]:" + "程序结束了，总耗时：" + time + " ms(毫秒)！\n");
				break;
			}
		}
	}
	
}
