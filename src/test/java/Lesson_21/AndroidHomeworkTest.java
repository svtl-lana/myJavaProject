package Lesson_21;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AndroidHomeworkTest {

    AppiumDriver driver;
    AndroidPage androidPage;

    @BeforeMethod
    public void setUp() {
        driver = new AppiumDriverInit().getDriver();
        androidPage = new AndroidPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCheckViewsButtonsCount() {
        androidPage.clickOnViews();
        androidPage.checkViewsButtonsCount();
    }

    @Test
    public void testSetDateAndTime() {
        androidPage.clickOnViews();
        androidPage.setDateAndTime();
    }

    @Test
    public void testTextSwitcher() {
        androidPage.clickOnViews();
        androidPage.checkTextSwitcherNextButton(5);
    }
}