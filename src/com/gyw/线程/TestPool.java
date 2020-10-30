package com.gyw.�߳�;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// �����̳߳�
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

		// ����һ���߳�submit execute
		cachedThreadPool.submit(new Runnable() {
			@Override
			public void run() {
				for (int k = 0; k < 100000; k++) {
					System.out.println("ִ��ҵ���������");
				}
			}
		});
		//�����ǵ��̳߳ص�ȫ���߳�ִ�н����󣬻��Զ�ִ�С�
		cachedThreadPool.shutdown();
		while (true) {
			if (cachedThreadPool.isTerminated()) {
				long time = System.currentTimeMillis() - start;
				System.out.println("["+new Date()+"]:" + "��������ˣ��ܺ�ʱ��" + time + " ms(����)��\n");
				break;
			}
		}
	}
	
}
