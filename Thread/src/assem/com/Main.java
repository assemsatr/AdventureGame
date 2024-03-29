package assem.com;

public class Main {
	public static void main(String[] args) {
		System.out.println("hello from main thread");
		
		Thread anotherThread=new AnotherThread();
		anotherThread.start();
		
		//anonoymous thread
		new Thread() {
			public void run() {
				System.out.println("Hello from the anonymos class thread");
			}
		}.start();
		
		Thread myRunnableThread=new Thread(new MyRunnble(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Hello from anonymous of Runnable thread");
				try {
					anotherThread.join(2000);
					System.out.println("AnotherThread is terminated or timed out , so im runnning again");
				}
				catch(InterruptedException e) {
					System.out.println("i couldnt wait agter all. i was interrupted");
				}
			}
			
			
		});
		myRunnableThread.start();
		
		anotherThread.interrupt();
		
		System.out.println("Hello again from the main thread.");
		
		
		
	}

}
