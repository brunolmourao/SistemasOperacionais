package quest1;
public class Dropbox {
	private int number;
	private boolean evenNumber = false;
	private boolean available = false;
	public synchronized int take(final boolean even) {
		while (available == false) {
	        try {
	            //wait for Producer to put value
	            wait();
	        } catch (InterruptedException e) { }
	    }
		if(isEvenNumber()){
			System.out.println("PAR CONSUMIDOR " + number);
		}
		else{
			System.out.println("IMPAR CONSUMIDOR " + number);
		}
		available = false;
		notify();
			
		return number;
		
	}
	public synchronized void put(int number) {
		//this.number = number;
		//evenNumber = number % 2 == 0;
		//System.out.println(evenNumber);
		while (available == true) {
	        try {
	            //wait for Consumer to get value
	            wait();
	        } catch (InterruptedException e) { }
	    }
		this.number = number;
		setEvenNumber(number % 2 == 0);
		System.out.println("PRODUTOR gera " + number);
		available = true;
		notify();
	}
	public synchronized boolean isEvenNumber() {
		return evenNumber;
	}
	public synchronized void setEvenNumber(boolean evenNumber) {
		this.evenNumber = evenNumber;
	}
	
}