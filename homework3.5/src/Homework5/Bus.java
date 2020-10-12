package Homework5;

public class Bus implements Runnable, FuelConsumer {

    private final GasStation gasStation;
    private double fuelVolume;
    private double fuelConsumption;
    private int uniqueNumber;
    private String name;
    private double maxFuel;
    private boolean empty = false;  // переменная указывающая что бак заправлен

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
        this.maxFuel = fuelVolume;
        this.fuelConsumption = fuelConsumption;
        this.uniqueNumber = uniqueNumber;
        this.name = name;
        this.gasStation = gasStation;
    }

    @Override
    public void run() {
        while (true) { //оборачиваем в цикл для того чтобы трансопрт начинал движение после заправки
            if (!empty) {
                System.out.println("Транспорт " + this.name + " поехал");
                fuelCalculation();
                if (fuelCalculation() == false) {
                    empty = true;
                    gasStation.addToQueue(this);
                }
            } else {
                // слипаем поток на секунду после заправки чтобы транспорт уехал с заправки и начал движение заново
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("SWW" + e);
                }
            }
        }
    }
    // метод расчета топлива
    public boolean fuelCalculation() {
        while (fuelVolume >= fuelConsumption){
            fuelVolume = fuelVolume - fuelConsumption;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Проблема с расчетом топлива" + e);
            }
        }
        return false;
    }

    // заравка до полного бака
    @Override
    public void consume() {
        fuelVolume = maxFuel;
        empty = false;
    }
}
