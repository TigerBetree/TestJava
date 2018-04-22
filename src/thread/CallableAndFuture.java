package thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFuture {

	public static void main(String[] args) {
		test2();
	}

	private static void test2() {
		Callable<Boolean> callable = new Callable<Boolean>() {

			@Override
			public Boolean call() throws Exception {
				System.out.println("start do somethings in sub thread.");
				int times = 1;
				while (times < 4) {
					System.out.println("start do somethings in sub thread. " + times);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					times++;
				}
				System.out.println("start do somethings in sub thread finish.");
				return true;
			}
		};
		FutureTask<Boolean> future = new FutureTask<Boolean>(callable);
		new Thread(future).start();

		System.out.println("start do otherthings in main thread.");

		try {
			if (future.get()) {
				System.out.println("future is finish.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("method end.");
	}

	private static void test1() {
		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() throws Exception {
				return new Random().nextInt(100);
			}
		};
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		new Thread(future).start();
		try {
			Thread.sleep(3000);// 可能做一些事情
			System.out.println(future.get());

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
