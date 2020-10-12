package Homework5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import static Homework5.Main.TRANSPORT_COUNT_ON_FUELSTATION;

public class FuelStaion implements Runnable {

    private final BlockingQueue<FuelConsumer> queue;
    double fuelVolume = 10000;
    int numberOnGasStation;

    public FuelStaion(BlockingQueue<FuelConsumer> queue, int numberOnGasStation) {
        this.queue = queue;
        this.numberOnGasStation = numberOnGasStation;
    }

    @Override
    public void run() {
        while (true){
        FuelConsumer consumer = null;
        try {
            // время ожидания заезда транспорта на заправку в чередь
            consumer = queue.poll(8, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int number = TRANSPORT_COUNT_ON_FUELSTATION - numberOnGasStation;
        System.out.println("Траноспорт " + consumer.getName() + " заехал на заправку, его номер на заправке " +  number);
        try {
            Thread.sleep(5000);
            consumer.consume();
            System.out.println("Траноспорт " + consumer.getName() + " закончил заправку");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
}
