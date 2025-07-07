package lesson_9.CatAndDog;

public class AnimalsMain {
    public static void main(String[] args) {
        Dog dog = new Dog("Sharik");
        Cat cat = new Cat("Bob");

        dog.run(150);
        dog.run(502);
        dog.swim(9);
        dog.swim(30);

        System.out.println("----------------------------");

        cat.run(190);
        cat.run(210);
        cat.swim(1);

        System.out.println("----------------------------");

        System.out.println("Total animals: " + Animal.count);
        System.out.println("Dogs : " + Dog.dogCount);
        System.out.println("Cats : " + Cat.catCount);
    }
}
