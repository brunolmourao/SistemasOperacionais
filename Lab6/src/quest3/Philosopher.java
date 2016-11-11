package quest3;

public class Philosopher implements Runnable {
	private int id;
	private String name;
	DiningPhilosophersSemaphore monitor;
	public Philosopher(int id,String name,DiningPhilosophersSemaphore monitor) {
		this.id = id;
		this.name = name;
		this.monitor = monitor;
	}
	public void eating(){
		SleepUtilities.nap();	
		System.out.println(name +" "+"está comendo");	
		
	}
	public void thinking(){
		SleepUtilities.nap();	
		System.out.println(name +" "+"está pensando");	
	}
	@Override
	public void run() {
		while (true){
			monitor.takeForks(id);
			eating();
			monitor.returnForks(id);
			thinking();
		}
			
		
	}

}
