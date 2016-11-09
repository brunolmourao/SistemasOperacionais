
public class ProducerConsumerExample {
	private static boolean Even = true;
	private static boolean Odd = false;
	public static void main(String[] args) {
		Dropbox dropbox = new Dropbox();
		(new Thread(new Consumer(Even, dropbox))).start();
		(new Thread(new Consumer(Odd, dropbox))).start();
		(new Thread(new Producer(dropbox))).start();
	}
}
