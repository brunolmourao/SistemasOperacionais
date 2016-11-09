import java.util.Random;
public class Consumer implements Runnable {
	private final Dropbox dropbox;
	private final boolean even;
	public Consumer(boolean even, Dropbox dropbox) {
		this.even = even;
		this.dropbox = dropbox;
	}
	public synchronized void run() {
		Random random = new Random();
		while (true) {
			//wait();

			//if(dropbox.isEvenNumber()==even){
				dropbox.take(even);
			
			

			
			try {
				Thread.sleep(random.nextInt(100));
			} catch (InterruptedException e) { }
		}
	}
}	