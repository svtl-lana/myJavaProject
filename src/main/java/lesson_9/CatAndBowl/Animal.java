package lesson_9.CatAndBowl;

public abstract class Animal {
    protected String name;
    protected int howMuchEat;
    protected boolean fullness;

    public Animal(String name, int howMuchEat) {
        this.name = name;
        this.howMuchEat = howMuchEat;
        this.fullness = false;
    }

    public abstract void eat(Bowl bowl);

    public void info() {
        if (fullness) {
            System.out.println(name + " fullness: full");
        } else {
            System.out.println(name + " fullness: hungry");
        }
    }

    public boolean isFull() {
        return fullness;
    }
}
