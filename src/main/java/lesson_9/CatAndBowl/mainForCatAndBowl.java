package lesson_9.CatAndBowl;

public class mainForCatAndBowl {
    public static void main(String[] args) {
        Animal[] cats = {
                new Cat("Barsik", 2),
                new Cat("Murzik", 3),
                new Cat("Bob", 4),
                new Cat("Blue", 7),
                new Cat("Tom", 5)
        };

        Bowl bowl = new Bowl(15);
        bowl.getInfo();

        for (Animal cat : cats) {
            cat.eat(bowl);
        }

        System.out.println();
        bowl.getInfo();

        System.out.println("-----------------------------");
        for (Animal cat : cats) {
            cat.info();
        }

        System.out.println("-----------------------------");
        System.out.println("Refilling bowl");
        bowl.addFood(15);
        bowl.getInfo();

        System.out.println("------------------------------");
        for (Animal cat : cats) {
            cat.eat(bowl);
        }

        System.out.println("-------------------------------");
        for (Animal cat : cats) {
            cat.info();
        }
    }
}
