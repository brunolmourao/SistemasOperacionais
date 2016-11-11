package quest3;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophersMonitor {
	Lock lock = new ReentrantLock();
    enum State {THINKING, HUNGRY, EATING};
    int numberOfPhilosophers;
    State[] states;
    Condition[] self;
    
    public DiningPhilosophersMonitor(int numberOfPhilosophers){
        this.numberOfPhilosophers = numberOfPhilosophers;
        this.states = new State[this.numberOfPhilosophers];
        this.self = new Condition[this.numberOfPhilosophers];
        for(int i = 0; i < this.numberOfPhilosophers; i++){
            states[i] = State.THINKING;
            self[i] = lock.newCondition();
        }
    }
    
    public void takeForks(int i){
        states[i] = State.HUNGRY;
        test(i);
        if(states[i] != State.EATING){
            try {
            	synchronized(this.self[i]){
                self[i].wait();
            	}
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
            synchronized(this.self[i]){
            	this.self[i].notifyAll();
            }	
        }
    }
}