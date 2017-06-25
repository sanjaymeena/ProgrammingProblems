package codingquestions.others;
/**
 * 
 */

/**
 * @author sanjay
 * 
 *         There are three threads in a process. The first thread prints 1 1 1
 *         �, the second one prints 2 2 2 �, and the third one prints 3 3 3 �
 *         endlessly. How do you schedule these three threads in order to print
 *         1 2 3 1 2 3 �?
 */
public class Scheduler {
	public class SimpleThread extends Thread {
		private int value;

		public SimpleThread(int num) {
			this.value = num;

			start();
		}

		public void run() {
			while (true) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}

					System.out.print(value + " ");
				}
			}
		}
	}

	static final int COUNT = 3;
	static final int SLEEP = 37;

	public static void main(String args[]) {
		Scheduler scheduler = new Scheduler();
		SimpleThread threads[] = new SimpleThread[COUNT];
		for (int i = 0; i < COUNT; ++i)
			threads[i] = scheduler.new SimpleThread(i + 1);

		int index = 0;
		while (true) {
			synchronized (threads[index]) {
				threads[index].notify();
			}

			try {
				Thread.sleep(SLEEP);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			index = (++index) % COUNT;
		}
	}
}
