package Lesson_19;

import Lesson_18.RegistrationPage;
import Lesson_18.SignInPage;
import io.qameta.allure.*;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import utils.MyTestListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Listeners({MyTestListener.class})

public class AllureRegistrationPageTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private SignInPage signInPage;


    public static void takeScreenshot(WebDriver driver, String methodName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        try {
            String screenshotPath = "target/allure-results/screenshot-" + methodName + ".png";
            FileUtils.copyFile(source, new File(screenshotPath));

            Allure.addAttachment("Screenshot for " + methodName, new FileInputStream(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.getDriver();
        registrationPage = new RegistrationPage(driver);
    }
    @AfterMethod
    public void makeScreenshotIfTestFailed(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            takeScreenshot(DriverSetUp.getDriver(), result.getMethod().getMethodName());
        }
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Description("Verify that registration form shows error message if passwords do not match")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Registration Page")
    @Story("US 1.1")
    @Test
    public void testPasswordMismatchError() {
        registrationPage.open();
        registrationPage.fillRegistrationForm("Test", "User", "10.10.2002",
                "123qwerty@gmail.com", "Qwerty123", "Qwerty321");

        Assert.assertTrue(registrationPage.isPasswordMismatchErrorDisplayed(), "Password mismatch error message should be displayed");
    }

    //баг при регистрации
    @Description("Verify that registration form shows error message on invalid email")
    @Severity(SeverityLevel.MINOR)
    @Epic("Registration Page")
    @Story("US 1.2")
    @Test
    public void testEmailError() {
        registrationPage.open();
        registrationPage.fillRegistrationForm("Test", "User", "10.10.2002",
                "svetatest@gmail.com", "Qwerty123", "Qwerty123");

        Assert.assertTrue(registrationPage.isEmailErrorDisplayed(), "Email error message should be displayed");
    }

    @Description("Verify navigation from registration page to sign in page")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Registration Page")
    @Story("US 1.3")
    @Test
    public void testNavigateToRegistrationPage() {
        registrationPage.open();
        registrationPage.clickSignIn();

        String registrationText = registrationPage.getRegistrationText();
        System.out.println("Sign in button text: " + registrationText);
        Assert.assertEquals(registrationText, "Registration", "Registration button text should be 'Registration'");
    }

    //баг при регистрации
    @Description("Verify successful user registration")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Registration Page")
    @Story("US 1.4")
    @Test
    public void testSuccessfulRegistration() {
        registrationPage.open();
        registrationPage.fillRegistrationForm("TestS", "UserS", "10.07.2002",
                "123qwe2345@gmail.com", "Qwerty1234", "Qwerty1234");
        registrationPage.submitClick();
        Assert.assertTrue(registrationPage.isSignOutVisible(),"Sign Out button should be visible after successful registration");
    }

    //баг при регистрации
    @Description("Verify that incorrect date of birth shows error message")
    @Severity(SeverityLevel.MINOR)
    @Epic("Registration Page")
    @Story("US 1.5")
    @Test
    public void testRegistrationWithIncorrectDate() {
        registrationPage.open();
        registrationPage.fillRegistrationForm("TestS", "UserS", "10.32.2200",
                "123qwe56y@gmail.com", "Qwerty1234", "Qwerty1234");
        registrationPage.submitClick();
        Assert.assertTrue(registrationPage.isDateErrorDisplayed(), "Error message should be displayed");
    }
}
