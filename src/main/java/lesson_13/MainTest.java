package lesson_13;

public class MainTest {
    public static void main(String[] args) {

        PhoneDirectory PhoneDirectory = new PhoneDirectory();
        PhoneDirectory.add("Gary Carter", "123123123");
        PhoneDirectory.add("Robert Young", "456456456");
        PhoneDirectory.add("Richard Flores", "789789789");
        PhoneDirectory.add("Frank Mullins", "123456789");

        System.out.println("Gary Carter: " + PhoneDirectory.get("Gary Carter"));
        System.out.println("Robert Young: " + PhoneDirectory.get("Robert Young"));
        System.out.println("Richard Flores: " + PhoneDirectory.get("Richard Flores"));
        System.out.println("James Abbott (nonexistent): " + PhoneDirectory.get("James Abbott"));
    }
}
