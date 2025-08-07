package Lesson_18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

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
        driver.get("https://qa-course-01.andersenlab.com/login");
        driver.manage().window().maximize();
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public boolean isEmailInputDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).isDisplayed();
    }

    public boolean isPasswordInputDisplayed() {
        return driver.findElement(passwordInput).isDisplayed();
    }
    public void clickRegistration() {
        wait.until(ExpectedConditions.elementToBeClickable(registrationLink)).click();
    }
    public String getTitle() {
        return driver.getTitle();
    }
    public String getRegistrationText() {
        return driver.findElement(registrationLink).getText();
    }
    public void fillSignInForm(String email, String password) {
       driver.findElement(emailInput).sendKeys(email);
       driver.findElement(passwordInput).sendKeys(password);

    }
    public boolean isSignOutVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton)).isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorPasswordOrEmail)).isDisplayed();
    }

}
