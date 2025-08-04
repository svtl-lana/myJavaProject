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

    public class Task3 {
        static WebDriver driver;
        static WebDriverWait wait;
        static Actions actions;

        private static class Locators {
            private static final By loginButton = By.xpath("//button[@type='submit']");
            private static final   By aqaPractice = By.xpath("//div[text()='AQA Practice']");
            private static final  By actionsAlertsIframes = By.xpath("//div[text()='Actions, Alerts & Iframes']");
            private static final  By confirmButton = By.id("AlertButton");
            private static final  By discountButton = By.xpath("//button[text()='Get Discount']");
            private static final  By resultText =  By.xpath("//span[contains(text(), 'Congratulations, you have successfully enrolled in the course!')]");
            private static final  By resultText2 =  By.xpath("//span[contains(text(), 'You received a 10% discount on the second course.')]");
            private static final  By resultText3 =  By.xpath("//span[contains(text(), 'Your course application has been cancelled. Reason: You did not notice any reason.')]");
            private static final  By cancelCourseButton = By.cssSelector("button[data-test-id='PromptButton']");
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
            actions.moveToElement(driver.findElement(Locators.actionsAlertsIframes)).perform();
            driver.findElement(Locators.actionsAlertsIframes).click();


            WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("iframe[title='Finish your registration']")));
            driver.switchTo().frame(iframe);

            actions.moveToElement(driver.findElement(Locators.confirmButton)).perform();
            driver.findElement(Locators.confirmButton).click();

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            Assert.assertEquals(alert.getText(), "You have called alert!", "Alert text не совпадает");
            alert.accept();

            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.resultText));
            Assert.assertEquals(result.getText(), "Congratulations, you have successfully enrolled in the course!");




            WebElement discountButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.discountButton));
            actions.doubleClick(discountButton).perform();

            Alert discountAlert =  driver.switchTo().alert();
            System.out.println(discountAlert.getText());
            Assert.assertEquals(discountAlert.getText(), "Are you sure you want to apply the discount?", "Alert text не совпадает");
            discountAlert.accept();

            WebElement result2 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.resultText2));
            Assert.assertEquals(result2.getText(), "You received a 10% discount on the second course.");



            WebElement cancelCourseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cancelCourseButton));
            wait.until(ExpectedConditions.elementToBeClickable(cancelCourseButton));
            actions.contextClick(cancelCourseButton).perform();

            Alert cancelAlert =  driver.switchTo().alert();
            System.out.println(cancelAlert.getText());
            Assert.assertEquals(cancelAlert.getText(), "Here you may describe a reason why you are cancelling your registration (or leave this field empty).", "Alert text не совпадает");
            cancelAlert.accept();

            WebElement result3 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.resultText3));
            Assert.assertEquals(result3.getText(), "Your course application has been cancelled. Reason: You did not notice any reason.", "Alert text не совпадает");
        }

    }
