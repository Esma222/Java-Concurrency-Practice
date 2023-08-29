import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 2; i++) {
            int taskId = i;
            Future<String> future = executorService.submit(() ->
            {
                System.out.println("deneniyor" + Thread.currentThread().getName());
                Thread.sleep(10000);
                System.out.println("deneniyor2" + Thread.currentThread().getName());
                return "Completed";
            });

            try {
                while (!future.isDone()) {
                    System.out.println("Task still on progress ... wait!" + Thread.currentThread().getName());
                    Thread.sleep(500);
                }
                System.out.println("Task completed." + Thread.currentThread().getName());
                String result = future.get(3000, TimeUnit.MILLISECONDS);
                System.out.println(result + " " + Thread.currentThread().getName());


            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                future.cancel(true);
                future.isDone();
                future.isCancelled();
            }
        }
        executorService.shutdown();
    }

}
