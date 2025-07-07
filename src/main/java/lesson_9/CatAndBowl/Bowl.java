package lesson_9.CatAndBowl;

public class Bowl {
    public int food;

    public Bowl(int food) {
        this.food = Math.max(food, 0);
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        if (amount <= food) {
            food -= amount;
        } else {
            System.out.println("Attempt to decrease more food than available");
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Added " + amount + " to the bowl");
        } else {
            System.out.println("Cannot add negative or zero food");
        }
    }

    public void getInfo() {
        System.out.println("Bowl has " + food + " of food");
    }
}
