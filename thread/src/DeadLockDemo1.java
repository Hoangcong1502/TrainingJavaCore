public class DeadLockDemo1 extends Thread {
    private Object lock1;
    private Object lock2;

    public DeadLockDemo1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }


    @Override
    public void run() {
        Thread thread = new Thread();
        synchronized (lock1){
            System.out.println(thread.getName()+":Holding"+ lock1 +"...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Thread thread2 = new Thread();
            System.out.println(thread.getName() + " : Waiting for" + lock2 + "...");
            synchronized (lock2){
                try {Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(thread.getName()+"----->"+lock1+":"+lock2+"...");
            }
        }
    }
}
