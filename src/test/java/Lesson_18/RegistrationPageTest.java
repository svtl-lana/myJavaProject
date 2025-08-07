package Lesson_18;

import Lesson_17.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationPageTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private SignInPage signInPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.getDriver();
        registrationPage = new RegistrationPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testPasswordMismatchError() {
        registrationPage.open();
        registrationPage.fillRegistrationForm("Test", "User", "10.10.2002",
                "123qwerty@gmail.com", "Qwerty123", "Qwerty321");

        Assert.assertTrue(registrationPage.isPasswordMismatchErrorDisplayed(), "Password mismatch error message should be displayed");

        //баг при регистрации
    }@Test
    public void testEmailError() {
        registrationPage.open();
        registrationPage.fillRegistrationForm("Test", "User", "10.10.2002",
                "svetatest@gmail.com", "Qwerty123", "Qwerty123");

        Assert.assertTrue(registrationPage.isEmailErrorDisplayed(), "Email error message should be displayed");
    }

    @Test

    public void testNavigateToRegistrationPage() {
        registrationPage.open();
        registrationPage.clickSignIn();

        String registrationText = registrationPage.getRegistrationText();
        System.out.println("Sign in button text: " + registrationText);
        Assert.assertEquals(registrationText, "Registration", "Registration button text should be 'Registration'");
    }
    //баг при регистрации
    @Test
    public void testSuccessfulRegistration() {
        registrationPage.open();
        registrationPage.fillRegistrationForm("TestS", "UserS", "10.07.2002",
                "123qwe456@gmail.com", "Qwerty1234", "Qwerty1234");
        registrationPage.submitClick();
        Assert.assertTrue(registrationPage.isSignOutVisible(),"Sign Out button should be visible after successful registration");
    }
    //баг при регистрации
    @Test
    public void testRegistrationWithIncorrectDate() {
        registrationPage.open();
        registrationPage.fillRegistrationForm("TestS", "UserS", "10.32.2200",
                "123qwe56y@gmail.com", "Qwerty1234", "Qwerty1234");
        registrationPage.submitClick();
        Assert.assertTrue(registrationPage.isDateErrorDisplayed(), "Error message should be displayed");
    }
}
