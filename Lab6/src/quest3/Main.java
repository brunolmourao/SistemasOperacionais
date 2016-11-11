package quest3;

public class Main {

	public static void main(String[] args) {
		DiningPhilosophersSemaphore monitor = new DiningPhilosophersSemaphore(5);
		new Thread(new Philosopher(0, "João", monitor)).start();
		new Thread(new Philosopher(1, "Arnaldo", monitor)).start();
		new Thread(new Philosopher(2, "Galvão", monitor)).start();
		new Thread(new Philosopher(3, "Thiago", monitor)).start();
		new Thread(new Philosopher(4, "Newton", monitor)).start();
	}

}
