package lesson_9.CatAndBowl;

public class Cat extends Animal {
    public Cat(String name, int howMuchEat) {
        super(name, howMuchEat);
    }

    @Override
    public void eat(Bowl bowl) {
        boolean canEat = !fullness && bowl.getFood() >= howMuchEat;
        if (canEat) {
            bowl.decreaseFood(howMuchEat);
            fullness = true;
            System.out.println(name + " ate " + howMuchEat);
        } else if (fullness) {
            System.out.println(name + " is already full");
        } else {
            System.out.println(name + ": not enough food");
        }
    }
}
