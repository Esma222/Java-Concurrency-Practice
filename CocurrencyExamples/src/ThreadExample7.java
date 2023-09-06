import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadExample7 {

    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<String>> futures = new ArrayList<>();
        for (int i=0;i<4;i++){

            TaskCall callable = new TaskCall();
            Future<String> future = executorService.submit(callable);
            /*TaskRun runnable = new TaskRun();
            Future future = executorService.submit(runnable);*/

            futures.add(future);
        }
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
