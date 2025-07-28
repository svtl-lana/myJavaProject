package lesson_15;
import io.github.bonigarcia.wdm. WebDriverManager;
import org.openqa.selenium.By ;
import org. openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-course-01.andersenlab.com/login");
        WebElement regLink = driver.findElement(By.linkText("Registration"));
        regLink.click();
        Thread.sleep(1000);
        System.out.println("Test 1: Registration page title" + driver.getTitle());

    }

}
