package quest2;

public class Condition {
	private int number;

    public Condition() {
        number = 0;
    }

    public synchronized boolean is_non_empty() {
        if (number == 0)
            return false;
        else
            return true;
    }

    public synchronized void release_all() {
        number = 0;
        notifyAll();
    }

    public synchronized void release_one() {
        number -= 1;
        notify();
    }

    public synchronized void wait_() throws InterruptedException {
        number++;
        wait(1000);
    }

}