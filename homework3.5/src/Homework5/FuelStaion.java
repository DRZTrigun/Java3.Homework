package Homework5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class FuelStaion implements Runnable {

    private final BlockingQueue<FuelConsumer> queue;
    // Semaphore semaphore;
   // String name;
    double fuelVolume = 10000;
    int uniqueNumber;

    public FuelStaion(BlockingQueue<FuelConsumer> queue, int uniqueNumber) {
        this.queue = queue;
        this.uniqueNumber = uniqueNumber;
    }
    // int NUBMERQUEUE;

//    public FuelStaion(Semaphore semaphore, double fuelVolume, int uniqueNumber, String name, int NUBMERQUEUE) {
//        this.semaphore = semaphore;
//        this.fuelVolume = fuelVolume;
//        this.uniqueNumber = uniqueNumber;
//        this.name = name;
//        this.NUBMERQUEUE = NUBMERQUEUE;
//        new Thread(this).start();
//    }

    @Override
    public void run() {
        FuelConsumer consumer = null;
        try {
            consumer = queue.poll(8, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Траноспорт " + consumer.getName() + " заехал на заправку, его номер на заправке " + uniqueNumber);
        consumer.consume();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try{
//            if(uniqueNumber == 100){
//                    semaphore.acquire();
//                    System.out.println("Началась заправка транспорта " + name);
//                    fuelVolume = 20;
//                    Thread.sleep(5000);
//                System.out.println("Транспорт " + name + " заправку завершил");
//                    semaphore.release();
//            } else if(uniqueNumber == 400){
//                    semaphore.acquire();
//                    System.out.println("Началась заправка транспорта " + name);
//                    fuelVolume = 60;
//                Thread.sleep(5000);
//                System.out.println("Транспорт " + name + " заправку завершил");
//                semaphore.release();
//            } else if(uniqueNumber == 700){
//                semaphore.acquire();
//                System.out.println("Началась заправка транспорта " + name);
//                fuelVolume = 40;
//                Thread.sleep(5000);
//                System.out.println("Транспорт " + name + " заправку завершил");
//                semaphore.release();
//            } else {
//
//            }
//        }catch (InterruptedException exc){
//            System.out.println("SWW" + exc);
//        }
    }
}
