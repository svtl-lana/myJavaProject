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
import org.testng.annotations.Listeners;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Listeners({MyTestListener.class})
public class AllureSignInPageTest {
    private WebDriver driver;
    private SignInPage signInPage;
    private RegistrationPage registrationPage;

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
        signInPage = new SignInPage(driver);
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

    @Description("Test to verify visibility of email and password inputs on empty login form")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Sign In Page")
    @Story("US 2.1")
    @Test
    public void testEmptyLoginForm() {
        signInPage.open();
        signInPage.clickSignIn();

        Assert.assertTrue(signInPage.isEmailInputDisplayed(), "Email input should be visible");
        Assert.assertTrue(signInPage.isPasswordInputDisplayed(), "Password input should be visible");
    }

    @Description("Test navigation by clicking Registration link on Sign In page")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Sign In Page")
    @Story("US 2.2")
    @Test
    public void testNavigateToRegistrationPage() {
        signInPage.open();
        signInPage.clickRegistration();

        String signInText = registrationPage.getSignInText();
        System.out.println("Sign in button text: " + signInText);
        Assert.assertEquals(signInText, "Sing in", "Sign in button text should be 'Sing in'");
    }

    @Description("Test successful login with correct email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Sign In Page")
    @Story("US 2.3")
    @Test
    public void testSuccessfulLogin() {
        signInPage.open();
        signInPage.fillSignInForm("svetatest@gmail.com", "Qwerty123");
        signInPage.clickSignIn();
        Assert.assertTrue(signInPage.isSignOutVisible(),"User should see 'Sign Out' after successful login");
    }

    @Description("Test error message shown when login password is incorrect")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Sign In Page")
    @Story("US 2.4")
    @Test
    public void testLoginIncorrectPassword() {
        signInPage.open();
        signInPage.fillSignInForm("svetatest@gmail.com", "Qwerty333");
        signInPage.clickSignIn();
        Assert.assertTrue(signInPage.isErrorDisplayed(),"User should see 'Email or password is not valid' after");
    }

    @Description("Test error message shown when login email is incorrect")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Sign In Page")
    @Story("US 2.5")
    @Test
    public void testLoginIncorrectEmail() {
        signInPage.open();
        signInPage.fillSignInForm("sv32534765682323224@gmail.com", "Qwerty333");
        signInPage.clickSignIn();
        Assert.assertTrue(signInPage.isErrorDisplayed(),"User should see 'Email or password is not valid' after");
    }

}
