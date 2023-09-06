import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ThreadExample8 {

    public static void main(String[] args) throws  InterruptedException{

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Callable<String>> callables =  Arrays.asList(new TaskCall(),new TaskCall(),new TaskCall());
        //for döngüsü kullanmadan hepsini aynı anda çalıştırabildim.
        List<Future<String>> futures = executorService.invokeAll(callables);

        futures.forEach(f->{
            try {
                System.out.println(f.get());
            } catch (Exception e) {}
        });
        executorService.shutdown();


    }

    static class TaskCall implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "I'am "+Thread.currentThread().getName();
        }
    }

    static class TaskRun implements Runnable{

        public void run(){
            System.out.println("I'am"+Thread.currentThread().getName());
        }


    }

}
