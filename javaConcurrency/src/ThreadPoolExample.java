import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String[] args) {
        // Thread havuzu oluştur
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        System.out.println("mainin içinde hangi thread çalışıyor "+Thread.currentThread().getName());
        // Görevleri gönder
        for (int i = 0; i < 8; i++) {
            int taskId = i;
            executorService.submit(() -> {

                System.out.println("Task " + taskId + " is running in thread " + Thread.currentThread().getName());
            });
            executorService2.submit(() -> {

                System.out.println("Task2 " + taskId + " is running in thread " + Thread.currentThread().getName());
            });
        }

        // Thread havuzunu kapat
        executorService.shutdown();
    }
}