package syncedExample;

public class SharedResource {

    private int x = 0;

    public synchronized void incrementX() {
        x++;
    }

    public int readX() {
        return x;
    }


    public synchronized void doStuffSync() {
        for (int i = 0; i < 10000; i++) {
            x++;
            System.out.println(Thread.currentThread().getName() + ": " + readX());
        }
    }

    public void doStuffSyncBlock() {
        for (int i = 0; i < 10000; i++) {
            synchronized (this) { x++; }
            System.out.println(Thread.currentThread().getName() + ": " + readX());
        }
    }


}
