package Lesson_18;

import Lesson_17.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInPageTest {
    private WebDriver driver;
    private SignInPage signInPage;
    private RegistrationPage registrationPage;


    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.getDriver();
        signInPage = new SignInPage(driver);
        registrationPage = new RegistrationPage(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testEmptyLoginForm() {
        signInPage.open();
        signInPage.clickSignIn();

        Assert.assertTrue(signInPage.isEmailInputDisplayed(), "Email input should be visible");
        Assert.assertTrue(signInPage.isPasswordInputDisplayed(), "Password input should be visible");
    }

    @Test

    public void testNavigateToRegistrationPage() {
        signInPage.open();
        signInPage.clickRegistration();

        String signInText = registrationPage.getSignInText();
        System.out.println("Sign in button text: " + signInText);
        Assert.assertEquals(signInText, "Sing in", "Sign in button text should be 'Sing in'");
    }

    @Test
    public void testSuccessfulLogin() {
        signInPage.open();
        signInPage.fillSignInForm("svetatest@gmail.com", "Qwerty123");
        signInPage.clickSignIn();
        Assert.assertTrue(signInPage.isSignOutVisible(),"User should see 'Sign Out' after successful login");
    }

    @Test
    public void testLoginIncorrectPassword() {
        signInPage.open();
        signInPage.fillSignInForm("svetatest@gmail.com", "Qwerty333");
        signInPage.clickSignIn();
        Assert.assertTrue(signInPage.isErrorDisplayed(),"User should see 'Email or password is not valid' after");
    }

    @Test
    public void testLoginIncorrectEmail() {
        signInPage.open();
        signInPage.fillSignInForm("sv32534765682323224@gmail.com", "Qwerty333");
        signInPage.clickSignIn();
        Assert.assertTrue(signInPage.isErrorDisplayed(),"User should see 'Email or password is not valid' after");
    }

}
