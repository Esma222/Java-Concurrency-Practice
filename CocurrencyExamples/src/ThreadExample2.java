import java.util.HashMap;
import java.util.Map;

public class ThreadExample2 {
    static Map<Integer, String> shippingFirmIdNameMap = new HashMap<>();
    static Integer SHIPPING_FIRM_ID = 101;



    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            if(!shippingFirmIdNameMap.containsKey(SHIPPING_FIRM_ID)){
                shippingFirmIdNameMap.put(SHIPPING_FIRM_ID, "UPS");
            }
        });

        Thread thread2 = new Thread(() -> {
            if(!shippingFirmIdNameMap.containsKey(SHIPPING_FIRM_ID)) {
                shippingFirmIdNameMap.put(SHIPPING_FIRM_ID, "Ocean Network Express");
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(shippingFirmIdNameMap.get(SHIPPING_FIRM_ID));
    }
}