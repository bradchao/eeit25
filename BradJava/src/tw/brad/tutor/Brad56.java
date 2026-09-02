package tw.brad.tutor;

public class Brad56 {

	public static void main(String[] args) {
		MyThread mt1 = new MyThread("A");
		MyThread mt2 = new MyThread("B");
		MyRunnable mr1 = new MyRunnable("C");
		Thread mt3 = new Thread(mr1);
		mt1.start();
		mt2.start();
		mt3.start();
		System.out.println("Main Finish");
	}

}

class MyThread extends Thread {
	private String name;
	public MyThread(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			System.out.printf("%s:%d\n",name, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
class MyRunnable implements Runnable {
	private String name;
	public MyRunnable(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			System.out.printf("%s:%d\n",name, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}	
}
