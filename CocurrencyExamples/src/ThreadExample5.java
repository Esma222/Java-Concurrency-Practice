import java.util.concurrent.CompletableFuture;

public class ThreadExample5 {

    public static void main(String[] args) {

        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(()->{
            sleep(5000);
            return 2022;
        }).thenApply(year-> add(1,3)+"hello "+year).thenAccept(s->System.out.println(s));

        completableFuture.join();
    }

    public static int add(int a, int b){

        return a+b;
    }
    private static  void sleep(long millis){
        try {
            Thread.sleep(millis);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
