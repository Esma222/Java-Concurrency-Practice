import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class CompleTableFuture {

    public static void main(String[] args) {
        String[] names = {"Daniel", "Mary", "Alex", "Andrew"};

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello from " + Thread.currentThread().getName());
            System.out.println("I'll give you the name in 5 sec");
            for (int i = 5; i > 0; i--){
                System.out.println(i+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Exception while sleeping in " + Thread.currentThread().getName());
                    e.printStackTrace();
                }
            }
            return randomElement(names);
        });

        completableFuture.thenAcceptAsync(name -> {
            System.out.println("Hello from " + Thread.currentThread().getName());
            System.out.println("Now I'm going to print you the name");
            System.out.println("Result: " + name);
        });

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            System.out.println("Exception while sleeping in " + Thread.currentThread().getName());
            e.printStackTrace();
        }
    }

    private static String randomElement(String[] array) {
        return array[new Random().nextInt(array.length)];
    }

}
