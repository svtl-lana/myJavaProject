package Lesson_18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private final By firstNameInput = By.name("firstName");
    private final By lastNameInput = By.name("lastName");
    private final By birthDateInput = By.name("dateOfBirth");
    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By confirmPasswordInput = By.name("passwordConfirmation");
    private final By errorPasswordMismatch = By.xpath("//*[contains(text(),'Passwords must match')]");
    private final By submitButton = By.xpath("//button[@type='submit' and text()='Submit']");
    private final By signInLink = By.xpath("//span[text()='Sing in']");
    private final By signOutButton = By.xpath("//div[text()='Sign Out']");
    private final By errorEmail = By.xpath("//*[contains(text(),'Invalid email address')]");
    private final By errorDate = By.xpath("//*[contains(text(),'Incorrect date of birth')]");


    public void open() {
        driver.get("https://qa-course-01.andersenlab.com/registration");
    }

    public void fillRegistrationForm(String firstName, String lastName, String birthDate, String email, String password, String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(birthDateInput).sendKeys(birthDate);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
    }

    public boolean isPasswordMismatchErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorPasswordMismatch)).isDisplayed();
    }
    public boolean isEmailErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorEmail)).isDisplayed();

    }public boolean isDateErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorDate)).isDisplayed();
    }

    public String getSignInText() {
        return driver.findElement(signInLink).getText();
    }
    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
    }
    public String getRegistrationText() {
        By registrationLink = By.xpath("//span[text()='Registration']");
        return driver.findElement(registrationLink).getText();
    }
    public void submitClick() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
    public boolean isSignOutVisible() {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton)).isDisplayed();
    }
}
