package syncedExample;

public class MainSyncedWholeMethodAndSyncedBlock {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread t1 = new MyThread(sharedResource);
        Thread t2 = new MyThread(sharedResource);
        Thread t3 = new MyThread(sharedResource);

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");

        t2.start();
        t1.start();
        t3.start();
    }

}
