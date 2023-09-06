import java.util.Random;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start of main thread..." + Thread.currentThread().getName());
        Thread ping = new Thread(new Ping(),"My thread");/*new Ping();*/

        Thread pong = new Thread(new Pong());/*new Pong();*/
        /*ping.run();
        pong.run();*/
        ping.start();
        pong.start();
        ping.join();
        pong.join();
        //join kullanımım sayesinde en son bu çıktıı print edilecek.
        System.out.println("End of main thread");


    }

    public static class Ping implements /*extends Thread*/ Runnable {



        public  void  run(){
            for (int i=0;i<3;i++){
                try {
                   Thread.sleep(new Random().nextInt(4000));
                }catch (InterruptedException e){}
                    System.out.println("ping "+Thread.currentThread().getName());

            }
        }
    }

    public  static class Pong /*extends Thread*/ implements  Runnable {

        public  void  run(){
            for (int i=0;i<3;i++){
                try {
                    Thread.sleep(new Random().nextInt(4000));
                }catch (InterruptedException e){}
                    System.out.println("pong "+ Thread.currentThread().getName());


            }
        }

    }
}