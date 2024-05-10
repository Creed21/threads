package syncedExample;

public class MyThread extends Thread {
    private SharedResource sharedResource;

    public MyThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
//        sharedResource.doStuffSync(); // whole method is synchron
        sharedResource.doStuffSyncBlock();
    }
}
