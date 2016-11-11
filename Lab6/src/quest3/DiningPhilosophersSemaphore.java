
package quest3;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

	public class DiningPhilosophersSemaphore  {
		Lock lock = new ReentrantLock();
	    enum State {THINKING, HUNGRY, EATING};
	    int numberOfPhilosophers;
	    State[] states;
	   // Condition[] self;
	    private Semaphore sem = new Semaphore(0);
	    
	    public DiningPhilosophersSemaphore(int numberOfPhilosophers){
	        this.numberOfPhilosophers = numberOfPhilosophers;
	        this.states = new State[this.numberOfPhilosophers];
	       // this.self = new Condition[this.numberOfPhilosophers];
	        for(int i = 0; i < this.numberOfPhilosophers; i++){
	            states[i] = State.THINKING;
	           // self[i] = lock.newCondition();
	        }
	    }
	    
	    public void takeForks(int i){
	        states[i] = State.HUNGRY;
	        test(i);
	        if(states[i] != State.EATING){
	            try {
	            	sem.acquire();
	            	test(i);
	            } catch (InterruptedException e) {}
	        }
	    }
	    
	    public void returnForks(int i){
	        states[i] = State.THINKING;
	        test((i + 4)%5);
	        test((i + 1)%5);
	    }
	    
	    private void test(int i) {
	        if((states[(i+4)%5] != State.EATING) && 
	        (states[(i+1)%5] != State.EATING) && 
	        (states[i] == State.HUNGRY)){
	            states[i] = State.EATING;
	            sem.release();
	        }
	    }
	}