package Homework5;

import java.util.concurrent.Semaphore;

public class Bus implements Runnable, FuelConsumer {

    private final GasStation gasStation;
    private double fuelVolume;
    private double fuelConsumption;
    private int uniqueNumber;
    private String name;

    public double getFuelVolume() {
        return fuelVolume;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public String getName(){
        return name;
    }
    public int getuniqueNumber() {
        return uniqueNumber;
    }

    public Bus(double fuelVolume, double fuelConsumption, int uniqueNumber, String name, GasStation gasStation){
        this.fuelVolume = fuelVolume;
        this.fuelConsumption = fuelConsumption;
        this.uniqueNumber = uniqueNumber;
        this.name = name;
        this.gasStation = gasStation;
    }

    @Override
    public void run() {
        System.out.println("Транспорт " + this.name + " поехал");
        fuelCalculation();
        if(fuelCalculation() == false){
            gasStation.addToQueue(this);
        }
    }

    public boolean fuelCalculation() {
        while (fuelVolume >= fuelConsumption){
            fuelVolume = fuelVolume - fuelConsumption;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
        //System.out.println("Топливо кончилось у транспорта " + this.name);
    }

    @Override
    public void consume() {
        fuelVolume = 40;
    }
}
