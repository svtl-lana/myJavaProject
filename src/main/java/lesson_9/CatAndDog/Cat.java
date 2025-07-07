package lesson_9.CatAndDog;

public class Cat extends Animal {
    public static int catCount = 0;

    public Cat(String name) {
        super(name);
        this.runLimit = 200;
        this.swimLimit = 0;
        catCount++;
    }

    @Override
    public void run(int distance) {
        super.run(distance);
    }

}
