package lesson_8;

public class MainEmployee {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Bennett Yusif", " QA Engineer", "Yusif@mail.com", "332322222", 3000.5, 25);
        employees[1] = new Employee("Sanchez Elizabeth", "Developer", "Sanchez@mail.com", "331111113", 5000.9, 36);
        employees[2] = new Employee("Cook Iver", "Developer", "Cook@mail.com", "330012345", 6500.0, 41);
        employees[3] = new Employee("Allen Damaris", "Designer", "Allen@mail.com", "330055566", 4500.6, 32);
        employees[4] = new Employee("Campbell Ishaan", "DevOps Engineer", "Campbell@mail.com", "3312345678", 7000.7, 42);

        System.out.println("Employees older than 40: " );
        for (Employee person : employees) {
            if (person.getAge() > 40) person.getInfoAbout();
        }
    }
}




