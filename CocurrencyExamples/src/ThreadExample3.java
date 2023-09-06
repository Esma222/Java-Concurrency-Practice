import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample3 {

    public static void main(String[] args) throws  InterruptedException, Exception{
        int NumberOfCores= Runtime.getRuntime().availableProcessors();
        ExecutorService executorService= Executors.newFixedThreadPool(NumberOfCores);
        for (int i=0;i<100;i++)
        {   executorService.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

}
