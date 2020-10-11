package Homework5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GasStation {

    private int fuelStationCount;
    private BlockingQueue<FuelConsumer> queue = new LinkedBlockingQueue<>();

    public GasStation(int fuelStationCount) {
        this.fuelStationCount = fuelStationCount;
        for (int i = 0; i < fuelStationCount; i++) {
            new Thread(new FuelStaion(queue, i)).start();
        }
    }

    public void addToQueue(FuelConsumer fc){
        try {
            queue.put(fc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
