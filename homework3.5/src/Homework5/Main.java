package Homework5;

import java.util.concurrent.Semaphore;

public class Main {
    /*1) Создать классы Car, Truck, Bus. Каждый обладает объемом топлива и расходом
          (Car - 20\2.5, Truck - 60\15, Bus - 40\7.5) и
          уникальных значением для определения среди разных транспортных средств.
      2)  Для каждого транспортного средства оставшиеся в баке количество топлива вычисляется раз в 3 сек.
      3)  Создать до 10 экземпляров разных транспортных средств и запустить их в работу.
      4)  Создать класс FuelStaion. Одновременно может заправлять 3 автомобиля,
          остальные должны ждать пока не освободится место.
          Заправка занимает 5 сек, затем транспортное средство освобождает место.
     *5)  Транспортные средства должны выстраиваться в очередь,
          если нет свобожных мест для заправки и начинать заправку в строгом порядке своей очереди.
      *6) Транспортные средства после заправки возвращаются на дорогу и продолжают свое движение.
    */

    public static final int TRANSPORT_COUNT_ON_FUELSTATION = 3;
    public static int NUBMERQUEUE = 0;
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(TRANSPORT_COUNT_ON_FUELSTATION);
        GasStation gasStation = new GasStation(TRANSPORT_COUNT_ON_FUELSTATION);
        System.out.println("Транспорт начал движение");
        int number = 1;
        for (int i = 0; i < 10 ; i++) {
            int j = (int) (Math.random() * 10);
            if(j == 1 | j == 2 | j == 3 | j == 0 ){
                Car[] cars = new Car[10];
                cars[i] = new Car(20,2.5, 100, "Car " + number, gasStation);
                number++;
                new Thread(cars[i]).start();
            } else if(j == 4 | j == 5 | j == 6){
                Truck[] trucks = new Truck[10];
                trucks[i] = new Truck(60, 15, 400, "Truck " + number, gasStation);
                number++;
                new Thread(trucks[i]).start();
            } else if (j == 7 | j == 8 | j == 9 | j == 10){
                Bus[] bus = new Bus[10];
                bus[i] = new Bus(40,7.5, 700, "Bus " + number, gasStation);
                number++;
                new Thread(bus[i]).start();
            } else{
                System.out.println("Неверное значение");
            }
        }
    }
}
