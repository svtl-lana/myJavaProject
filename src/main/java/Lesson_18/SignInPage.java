package Lesson_18;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    protected Logger logger = LogManager.getLogger(this.getClass());

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By signInButton = By.xpath("//button[@type='submit']");
    private final By registrationLink = By.xpath("//span[text()='Registration']");
    private final By signOutButton = By.xpath("//div[text()='Sign Out']");
    private final By errorPasswordOrEmail = By.xpath("//*[contains(text(),'Email or password is not valid')]");

    public void open() {
        logger.info("Opening SignInPage");
        driver.get("https://qa-course-01.andersenlab.com/login");
        driver.manage().window().maximize();
    }

    public void clickSignIn() {
        logger.info("Clicking Sign In button");
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public boolean isEmailInputDisplayed() {
        logger.info("Filling sign in form with email");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).isDisplayed();
    }

    public boolean isPasswordInputDisplayed() {
        logger.info("Password input displayed");
        return driver.findElement(passwordInput).isDisplayed();
    }
    public void clickRegistration() {
        logger.info("Clicking Registration link");
        wait.until(ExpectedConditions.elementToBeClickable(registrationLink)).click();
    }

    public String getRegistrationText() {
        return driver.findElement(registrationLink).getText();
    }
    public void fillSignInForm(String email, String password) {
       driver.findElement(emailInput).sendKeys(email);
       driver.findElement(passwordInput).sendKeys(password);

    }
    public boolean isSignOutVisible() {
        logger.info("Sign Out button visible");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton)).isDisplayed();
    }

    public boolean isErrorDisplayed() {
        logger.info("Error message visible");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorPasswordOrEmail)).isDisplayed();

    }

}
