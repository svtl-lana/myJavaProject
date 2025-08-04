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

public class Task1 {
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    private static class Locators {
        private static By loginButton = By.xpath("//button[@type='submit']");
        private static By aqaPractice = By.xpath("//div[text()='AQA Practice']");
        private static By selectLink = By.xpath("//div[text()='Select']");

        private static By countrySelect = By.cssSelector("select[title='Select country']");
        private static  By countryOptionUSA = By.xpath("//select[@title='Select country']/option[text()='USA']");
        private static  By languageSelect = By.id("SelectLanguage");
        private static  By languageOption = By.xpath("//select[@id='SelectLanguage']/option[text()='English']");
        private static  By typeSelect = By.cssSelector("select[title='Select type']");
        private static  By typeOption = By.xpath("//select[@title='Select type']/option[text()='Testing']");

        private static  By startDate = By.cssSelector("input[title='Start date']");
        private static  By endDate = By.cssSelector("input[title='End date']");
        private static  By resultText = By.xpath("//h2[text()='Unfortunately, we did not find any courses matching your chosen criteria.']");    }


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
        actions.moveToElement(driver.findElement(Locators.selectLink)).perform();
        driver.findElement(Locators.selectLink).click();

        driver.findElement(Locators.countrySelect).click();
        driver.findElement(Locators.countryOptionUSA).click();
        driver.findElement(Locators.languageSelect).click();
        driver.findElement(Locators.languageOption).click();
        driver.findElement(Locators.typeSelect).click();
        driver.findElement(Locators.typeOption).click();

        driver.findElement(Locators.startDate).clear();
        driver.findElement(Locators.startDate).sendKeys("11/08/2025");

        driver.findElement(Locators.endDate).clear();
        driver.findElement(Locators.endDate).sendKeys("25/08/2025");


        WebElement courseSelect = driver.findElement(By.id("MultipleSelect"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", courseSelect);

        WebElement optionJava = driver.findElement(By.xpath("//option[text()='AQA Java']"));
        WebElement optionPython = driver.findElement(By.xpath("//option[text()='AQA Python']"));

        actions.keyDown(Keys.CONTROL)
                .click(optionJava)
                .click(optionPython)
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
        searchButton.click();

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.resultText));
        Assert.assertEquals(result.getText(), "Unfortunately, we did not find any courses matching your chosen criteria.");
    }
}