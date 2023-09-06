import java.util.concurrent.*;

public class ThreadExample4 {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        System.out.println("Starting....");
        final int coreSize=2;

        ExecutorService executorService = Executors.newFixedThreadPool(coreSize);
        Future<String> future = executorService.submit(new Task());
        System.out.println(future.get(11,TimeUnit.SECONDS));
        System.out.println("hello world");


    }

    static class Task implements  Callable<String>{

        @Override
        public String call() throws InterruptedException {
            Thread.sleep(10000);
            return Thread.currentThread().getName();
        }
    }

}
