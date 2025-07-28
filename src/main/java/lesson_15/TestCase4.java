package lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4 {
    public static void main(String[] args) throws InterruptedException {

        try {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://qa-course-01.andersenlab.com/login");
            driver.manage().window().maximize();
            Thread.sleep(1000);


            WebElement emailError = driver.findElement(By.xpath("//input[@name='email']"));
            WebElement passwordError = driver.findElement(By.xpath("//input[@name='password']"));
            WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
            signInButton.click();

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}