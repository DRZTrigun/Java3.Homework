package Homework5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GasStation {

    // создаем класс заправку для того что страктурировать чередь на колнку с помощью BlockingQueue
    private int fuelStationCount;
    // задаем количество мест в очереди
    private BlockingQueue<FuelConsumer> queue = new LinkedBlockingQueue<>(1024);

    public GasStation(int fuelStationCount) {
        this.fuelStationCount = fuelStationCount;
        for (int i = 0; i < fuelStationCount; i++) {
            new Thread(new FuelStaion(queue, i)).start();
        }
    }

    // метод добавления в очередь на заправку
    public void addToQueue(FuelConsumer fc){
        System.out.println("приехал на заправку " + fc.getName());
        try {
            queue.put(fc);
        } catch (InterruptedException e) {
            System.out.println("SWW" + e);
        }
    }
}
