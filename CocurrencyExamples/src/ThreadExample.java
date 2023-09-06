import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadExample {

    int counters=0;
    private  static Lock lock = new ReentrantLock();

    private static /*synchronized*/ void increments(ThreadExample threadExample){
       // lock.lock();
        for(int i =0;i<1000000;i++)
          threadExample.counters++;
        System.out.println(Thread.currentThread().getName()+" counters : "+threadExample.counters);
       // lock.unlock();
    }

    public static void main(String[] args)throws  InterruptedException {
        ThreadExample threadExample = new ThreadExample();

        Thread thread1= new Thread(()-> {
            increments(threadExample);
        });
        Thread thread2= new Thread(()-> {
            increments(threadExample);
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}
