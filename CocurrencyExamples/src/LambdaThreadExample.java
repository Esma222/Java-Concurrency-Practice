public class LambdaThreadExample {
    public static void main(String[] args) {
        System.out.println("Count: " + 0+ Thread.currentThread().getName());
        // Lambda ifadesi ile bir işlevi temsil ediyoruz
        Runnable myRunnable = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Count: " + i+ Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // 1 saniye bekletme
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // Lambda ile bir iş parçacığı oluşturma ve başlatma
        Thread myThread = new Thread(myRunnable);
        myThread.start();
    }
}