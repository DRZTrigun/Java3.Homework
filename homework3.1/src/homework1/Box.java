package homework1;


import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit>  implements Comparable<Box<? extends Fruit>>{
    private List<T> fruits;
    private double boxWeight;

    public Box(){
        this(new ArrayList<T>());
    }

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public List<T> getFruits() {
        return fruits;
    }

    public double getWeight(){
        double weight = 0.0;
        for (T fruit : fruits){
            weight += fruit.getWeight();
        }
        return weight;
    }
    @Override
    public int compareTo(Box<? extends Fruit> otherBox) {
        if( this.getWeight() < otherBox.getWeight()){
            return -1;
        } else if (getWeight() > otherBox.getWeight()){
            return 1;
        }
        return 0;
    }

    public Box<T> emptyBox(){
        Box<T> newBox = new Box<>();
        System.out.println("Пересыпаем фрукты");
        for (T t: this.fruits ) {
            newBox.add(t);
        }
        return newBox;
    }

    public void boxInfo(){
        if (fruits.isEmpty())
            System.out.println("коробка пуста");
        else {
            System.out.println("Содержимое коробки");
            for (T t: fruits) {
                System.out.println(t.getClass().getName());
            }
        }
    }
}
