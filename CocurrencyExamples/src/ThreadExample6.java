public class ThreadExample6 {

    public static void main(String[] args) throws InterruptedException{

        Counter counter = new  Counter();

        Thread c1= new Thread(()->{
            for (int i=0;i<10;i++){
                counter.increment();
                System.out.println(Thread.currentThread().getName());
            }
        });
        Thread c2= new Thread(()->{
            for (int i=0;i<10;i++){
                counter.increment();
                System.out.println(Thread.currentThread().getName());
            }
        });
        c2.setPriority(Thread.MIN_PRIORITY);
        c1.setName("new thread for c1");
        c1.start();
        c2.start();
        c1.join();
        c2.join();
        System.out.println("end of the thread"+counter.count);

    }

    static class Counter{
        int count=0;

        public /*synchronized*/ void  increment(){
            System.out.println(count);
            count++;
        }
    }
}
