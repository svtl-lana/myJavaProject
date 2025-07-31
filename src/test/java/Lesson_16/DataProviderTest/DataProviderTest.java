package Lesson_16.DataProviderTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderTest {
    @DataProvider(name = "testData")
    public Object[][] createData() {
        return new Object[][]{
                {"svetatest1@gmail.com", 12345678},
                {"svetatest2@gmail.com", 12345678},
                {"svetatest3@gmail.com", 12345678},
        };
    }

    @Test(dataProvider = "testData")
    public void fillPage(String email, int password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(3000);

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(String.valueOf(password));
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signInButton.click();

        Thread.sleep(1000);

        driver.quit();
    }
}
