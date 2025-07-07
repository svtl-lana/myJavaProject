package lesson_9.CatAndDog;

public class Dog extends Animal {
    public static int dogCount = 0;

    public Dog(String name) {
        super(name);
        this.runLimit = 500;
        this.swimLimit = 10;
        dogCount++;
    }

    @Override
    public void run(int distance) {
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        super.swim(distance);
    }

}
