package lesson_10;

import java.util.Arrays;

public class BoxMain {
    public static void main(String[] args) {

            Box<Apple> appleBox1 = new Box<>();
            Box<Apple> appleBox2 = new Box<>();
            Box<Orange> orangeBox = new Box<>();

            appleBox1.addFruit(new Apple());
            appleBox1.addFruit(new Apple());

            orangeBox.addFruit(new Orange());
            orangeBox.addFruit(new Orange());

            System.out.println("apple Box: " + appleBox1.getWeight()); // 2
            System.out.println("orange Box: " + orangeBox.getWeight()); // 3

            System.out.println("Is the weight equal? " + appleBox1.compare(orangeBox));

            appleBox1.transferFruitsTo(appleBox2);

            System.out.println("After the move");
            System.out.println("appleBox1: " + appleBox1.getCount()); // 0
            System.out.println("appleBox2: " + appleBox2.getCount()); // 2

    }

}
