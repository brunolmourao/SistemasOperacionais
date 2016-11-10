package quest2;

public class Reader extends Thread {
    private Monitor M;

    public Reader(String name, Monitor monitor) {
        super(name);
        this.M = monitor;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            M.Start_Read(i);
            System.out.println("Reader está lendo " + i);
            M.End_Read(i);
        }

    }
}