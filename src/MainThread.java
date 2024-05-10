public class MainThread {

    public static void main(String[] args) {
        System.out.println("I am main thread");

        System.out.println(Thread.currentThread().getName());

        Integer x = 0;

//        anonymousClassExample();

        SharedResource sharedResource = new SharedResource();

        Thread t1 = new Thread(new IncrementThread(sharedResource));
        Thread t2 = new Thread(new IncrementThread(sharedResource));
        Thread t3 = new Thread(new IncrementThread(sharedResource));
//        Thread t4 = new Thread(new IncrementThread(sharedResource));

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");

        t1.setPriority(10); // max priority = 10
        t2.setPriority(1); // min priority = 1
        t3.setPriority(5); // min priority = 1

        t1.start();
        t2.start();
        t3.start();
//        t4.start();

    }

    // sto sam dodao static ovde?
    // -> da mogu direktno da pozovem metodu u main metodi bez instanciranja objekta MainThread
    public static void anonymousClassExample() {
        // I want to create two threads which will increment x 20 000 times
        // I am expecting in the end -> x = 40 000

        // anonymous class - giving implementation of interface or abstract class here
        // cannot be used after or anywhere else in code
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am thread: " + Thread.currentThread().getName());
                System.out.println("Thread id: " + Thread.currentThread().getId());
                System.out.println("Thread priority: " + Thread.currentThread().getPriority());

                for (int i = 0; i < 20; i++) {
                    System.out.println("var i = " + i);
                }
            }
        });
        t1.start();
    }

}
