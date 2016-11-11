package quest2;

public class Monitor {
	private int readers; // specifies number of readers reading
    private boolean writing; // specifies if someone is writing
    private Condition OK_to_Read, OK_to_Write;

    public Monitor() {
        readers = 0;
        writing = false;
        OK_to_Read = new Condition();
        OK_to_Write = new Condition();
    }

    public synchronized void Start_Read(int n) {

        System.out.println("wants to read " + n);
        if (writing || OK_to_Write.is_non_empty()) {
            try {
                System.out.println("reader is waiting " + n);
                OK_to_Read.wait_();
            } catch (InterruptedException e) {
            }
        }
        readers += 1;
        OK_to_Read.release_all();

    }

    public synchronized void End_Read(int n) {

        System.out.println("finished reading " + n);
        readers -= 1;

        if (OK_to_Write.is_non_empty()) {
            OK_to_Write.release_one();
        } else if (OK_to_Read.is_non_empty()) {
            OK_to_Read.release_one();
        } else {
            OK_to_Write.release_all();
        }

    }

    public synchronized void Start_Write(int n) {
        System.out.println("wants to write " + n);
        if (readers != 0 || writing) {
            try {
                System.out.println("Writer is waiting " + n);
                OK_to_Write.wait_();
            } catch (InterruptedException e) {
            }
        }

        writing = true;

    }

    public synchronized void End_Write(int n) {

        System.out.println("finished writing " + n);
        writing = false;
        if (OK_to_Read.is_non_empty()) {
            OK_to_Read.release_one();
        } else if (OK_to_Write.is_non_empty()) {
            OK_to_Write.release_one();
        } else {
            OK_to_Read.release_all();
        }

    }

}

