package Lesson_17;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Task2 {
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    static class Locators {
        static By loginButton = By.xpath("//button[@type='submit']");
        static By aqaPractice = By.xpath("//div[text()='AQA Practice']");
        private static By dragAndDrop = By.xpath("//div[text()='Drag & Drop']");
        public static By resultText = By.xpath("//div[text()=\"Congratulations! Let's test for the best!\"]");


        private static By manual1 = By.id("manual1");
        private static By manual2 = By.id("manual2");
        private static By auto1 = By.id("auto1");
        private static By auto2 = By.id("auto2");
        private static By targetManual1 = By.id("target-manual1");
        private static By targetManual2 = By.id("target-manual2");
        private static By targetAuto1 = By.id("target-auto1");
        private static By targetAuto2 = By.id("target-auto2");
    }
        @BeforeMethod
        public void setUpDriver() {
            driver = DriverSetUp.getDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            actions = new Actions(driver);
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }

        @Test
        public void selectFormTest() throws InterruptedException {
            driver.get("https://qa-course-01.andersenlab.com/login");

            driver.findElement(By.name("email")).sendKeys("svetatest@gmail.com");
            driver.findElement(By.name("password")).sendKeys("Qwerty123");
            driver.findElement(Locators.loginButton).click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.aqaPractice));
            actions.moveToElement(driver.findElement(Locators.aqaPractice)).perform();
            actions.moveToElement(driver.findElement(Locators.dragAndDrop)).perform();
            driver.findElement(Locators.dragAndDrop).click();

            performDragAndDrop();

            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.resultText));
            Assert.assertEquals(result.getText(), "Congratulations! Let's test for the best!");
        }

        private void performDragAndDrop() {
            WebElement manual1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.manual1));
            WebElement manual2 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.manual2));
            WebElement auto1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.auto1));
            WebElement auto2 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.auto2));

            WebElement targetManual1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.targetManual1));
            WebElement targetManual2 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.targetManual2));
            WebElement targetAuto1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.targetAuto1));
            WebElement targetAuto2 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.targetAuto2));

            actions.dragAndDrop(manual1, targetManual1).perform();
            actions.dragAndDrop(manual2, targetManual2).perform();
            actions.dragAndDrop(auto1, targetAuto1).perform();
            actions.dragAndDrop(auto2, targetAuto2).perform();

        }
}