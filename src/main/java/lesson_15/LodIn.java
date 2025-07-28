package lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LodIn {
        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://qa-course-01.andersenlab.com/login");
            Thread.sleep(1000);

            driver.findElement(By.name("email")).sendKeys("svetatest@gmail.com");
            driver.findElement(By.name("password")).sendKeys("Qwerty123");
            WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
            signInButton.click();

            Thread.sleep(1000);

            driver.quit();
        }

}
