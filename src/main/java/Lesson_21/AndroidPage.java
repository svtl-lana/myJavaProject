package Lesson_21;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class AndroidPage {
    AppiumDriver driver;
    WebDriverWait wait;

    public AndroidPage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private static final class Locators {
        private static final By views = AppiumBy.accessibilityId("Views");

        private static final By viewsButtons = By.xpath("//android.widget.TextView");

        private static final By dataWidgets = AppiumBy.accessibilityId("Date Widgets");
        private static final By dialog = AppiumBy.accessibilityId("1. Dialog");
        private static final By changeDateButton = By.id("io.appium.android.apis:id/pickDate");
        private static final By changeTimeButton = By.id("io.appium.android.apis:id/pickTime");
        private static final By okButton = By.id("android:id/button1");

        private static final By textSwitcher = AppiumBy.accessibilityId("TextSwitcher");
        private static final By nextButton = AppiumBy.accessibilityId("Next");
        private static final By counterText = By.id("io.appium.android.apis:id/switcher");

    }

    public void clickOnViews() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.views)).click();
    }

    public void checkViewsButtonsCount() {
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.viewsButtons));
        int actualCount = elements.size();
        Assert.assertEquals(actualCount, 42, "The number of elements in Views does not match!");
    }

    public void setDateAndTime() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.dataWidgets)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.dialog)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.changeDateButton)).click();
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + tomorrow.getDayOfMonth() + "\")")).click();
        driver.findElement(Locators.okButton).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.changeTimeButton)).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"11\")")).click(); // часы
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"11\")")).click(); // минуты
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"PM\")")).click(); // выбор PM
        driver.findElement(Locators.okButton).click();
    }

    public void checkTextSwitcherNextButton(int clicks) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.textSwitcher)).click();

        for (int i = 0; i < clicks; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.nextButton)).click();
        }

        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.counterText)).getText();
        Assert.assertEquals(result, String.valueOf(clicks), "The counter value does not match the number of clicks!");
    }
}