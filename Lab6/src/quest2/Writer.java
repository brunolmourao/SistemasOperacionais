package quest2;

public class Writer extends Thread{
	private Monitor M;

    public Writer(String name, Monitor monitor) {
        super(name);
        this.M = monitor;
    }

    public void run() {
        for (int j = 0; j < 5; j++) {
            M.Start_Write(j);
            System.out.println("Writer está escrevendo " + j);
            M.End_Write(j);
        }

    }
}

