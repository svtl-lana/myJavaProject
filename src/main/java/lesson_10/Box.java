package lesson_10;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit>{

    private final ArrayList<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double weight = 0.0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }
    public boolean compare(Box<?> appleBox2) {
        return Double.compare(this.getWeight(), appleBox2.getWeight()) == 0;
    }

    public void transferFruitsTo(Box<T> appleBox2) {
        if (appleBox2 == this) return;
        appleBox2.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public int getCount() {
        return fruits.size();
    }

}
