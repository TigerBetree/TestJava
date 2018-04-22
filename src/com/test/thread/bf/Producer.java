package com.test.thread.bf;

import java.util.Queue;

//生产者线程
class Producer extends Thread {
	private Queue<Integer> queue;
	private int maxSize, times;
	private int k = 0;

	public Producer(Queue<Integer> queue, int maxSize, String name) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
		this.times = 2;
	}

	@Override
	public void run() {
		while (times > 0) {
			synchronized (queue) {
				while (queue.size() == maxSize) { // 当缓存区满的时候
					try {
						// 进入wait
						queue.wait();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

				// 缓存区不为空的时候就可以继续生产，生产后唤醒消费者线程的wait
				for (int i = 0; i < maxSize; i++) {
					System.out.println("Produce " + i);
					queue.add(i);
				}
				queue.notifyAll();
			}

			times--;
		}
	}
}