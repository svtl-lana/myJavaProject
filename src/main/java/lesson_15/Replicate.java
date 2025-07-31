package lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Replicate {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(1000);

        driver.findElement(By.name("email")).sendKeys("svetatest@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Qwerty123");
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signInButton.click();

        Thread.sleep(1000);

        WebElement uploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@type='file']")));
        uploadInput.click();

        File avatar = new File("C:\\Users\\MY LOVELY ASS\\Downloads\\cat.png");
        uploadInput.sendKeys(avatar.getAbsolutePath());

        Thread.sleep(1000);
        driver.quit();
    }
}
