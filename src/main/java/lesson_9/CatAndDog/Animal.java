package lesson_9.CatAndDog;

public class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;
    public static int count = 0;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " ran " + distance + " meters.");
        } else {
            System.out.println(name + " couldn't run " + distance + " meters.");
        }
    }

    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " can't swim.");
        } else if (distance <= swimLimit) {
            System.out.println(name + " swam " + distance + " meters.");
        } else {
            System.out.println(name + " couldn't swim " + distance + " meters.");
        }
    }
}
