package lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-course-01.andersenlab.com/registration");
        Thread.sleep(1000);

        driver.findElement(By.name("firstName")).sendKeys("TestS");
        driver.findElement(By.name("lastName")).sendKeys("QwertyS");
        driver.findElement(By.name("dateOfBirth")).sendKeys("10.10.2002");
        driver.findElement(By.name("email")).sendKeys("123qwerty@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Qwerty123");
        driver.findElement(By.name("passwordConfirmation")).sendKeys("Qwerty321");

        Thread.sleep(1000);

        WebElement error = driver.findElement(By.xpath("//*[contains(text(),'Passwords must match')]"));

        driver.quit();
    }
}
