package com.test.thread.bf;

import java.util.Queue;

//消费者线程  
class Consumer extends Thread {
	private Queue<Integer> queue;
	private int maxSize;

	public Consumer(Queue<Integer> queue, int maxSize, String name) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) { // 当缓存区为空的时候
					try {
						queue.wait(); // 进入wait
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

				for (int i = 0; i < maxSize; i++) {
					int v = queue.remove();
					System.out.println("Consume " + v);
				}
				queue.notifyAll();
			}
		}
	}
}