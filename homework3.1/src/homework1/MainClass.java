package homework1;
import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "banana", "tomato"};
        swapElements(words);
        swap(words, 0, 2);
        arrayTransformation(words);

        boxСomparison ();
    }
    // 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public static void  swapElements (String[] words) {
        String var = words[0];
        for (int i = 0; i < words.length - 1 ; i++) {
            words[i] = words[i + 1];
        }
        words[words.length - 1] = var;
        System.out.println(Arrays.toString(words));
    }

    public static void  swap(Object[] words, int i, int j){
        Object sw = words[i];
        words[i] = words[j];
        words[j] = sw;
        System.out.println(Arrays.toString(words));
    }

    // 2. Написать метод, который преобразует массив в ArrayList;
    public static <T> void arrayTransformation (T[] words){
        ArrayList<T> ListOfwords = new ArrayList<>(Arrays.asList(words));
        System.out.println(ListOfwords);
    }

    /*
     3. Большая задача:
     a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
     b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
      поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     c. Для хранения фруктов внутри коробки можете использовать ArrayList;
     d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов
      и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
     e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
      которую подадут в compare в качестве параметра, true - если их веса равны,
      false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
      f. Написать метод, который позволяет пересыпать фрукты из текущей коробки
      в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
      соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
      g. Не забываем про метод добавления фрукта в коробку.
    */
    public static void boxСomparison () {

        Box<Orange> boxOfOranges = new Box<>();
        boxOfOranges.add(new Orange());
        boxOfOranges.add(new Orange());
        boxOfOranges.add(new Orange());
        boxOfOranges.add(new Orange());
        boxOfOranges.add(new Orange());
        boxOfOranges.add(new Orange());

        Box<Apple> boxOfApples = new Box<>();
        boxOfApples.add(new Apple());
        boxOfApples.add(new Apple());
        boxOfApples.add(new Apple());
        boxOfApples.add(new Apple());
        boxOfApples.add(new Apple());

       // System.out.println(boxOfOranges.compareTo(boxOfApples));

        boxOfApples.emptyBox().boxInfo();
        boxOfOranges.emptyBox().boxInfo();
    }
}
