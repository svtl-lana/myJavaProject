package Lesson_17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetUp {
    public static WebDriver getDriver() {
        return new ChromeDriver();
    }
}
