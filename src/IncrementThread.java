public class IncrementThread implements Runnable {

    SharedResource sharedResource;

    public IncrementThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            sharedResource.incrementX(); // synchronized
            System.out.println(Thread.currentThread().getName() + ": " + sharedResource.readX());
        }
    }

}
