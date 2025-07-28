package lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompareElements {

    public static void compareElements(WebElement e1, WebElement e2) {
        int x1 = e1.getLocation().getX();
        int y1 = e1.getLocation().getY();
        int x2 = e2.getLocation().getX();
        int y2 = e2.getLocation().getY();

        int area1 = e1.getSize().getHeight() * e1.getSize().getWidth();
        int area2 = e2.getSize().getHeight() * e2.getSize().getWidth();

        System.out.println((y1 < y2 ? "Element 1 is higher" : "Element 2 is higher"));
        System.out.println((x1 < x2 ? "Element 1 is to the left" : "Element 2 is to the left"));
        System.out.println((area1 > area2 ? "Element 1 is bigger" : "Element 2 is bigger"));
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("password"));
        compareElements(emailField, passwordField);

        driver.quit();
    }
}
