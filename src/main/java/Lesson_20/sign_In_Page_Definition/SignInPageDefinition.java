package Lesson_20.sign_In_Page_Definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignInPageDefinition {
    private static WebDriver driver;
    private static WebDriverWait wait;
    protected Logger logger = LogManager.getLogger(this.getClass());

    // Locators
    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By signInButton = By.xpath("//button[@type='submit']");
    private final By registrationLink = By.xpath("//span[text()='Registration']");
    private final By signOutButton = By.xpath("//div[text()='Sign Out']");
    private final By errorPasswordOrEmail = By.xpath("//*[contains(text(),'Email or password is not valid')]");
    private final By signInLink = By.xpath("//span[text()='Sing in']");

    @Given("Set up driver")
    public void set_up_driver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @When("I open the Sign In page")
    public void i_open_the_sign_in_page() {
        logger.info("Opening SignInPage");
        driver.get("https://qa-course-01.andersenlab.com/login");
    }

    @And("I click the Sign In button")
    public void i_click_the_sign_in_button() {
        logger.info("Clicking Sign In button");
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    @Then("the email input should be visible")
    public void the_email_input_should_be_visible() {
        logger.info("Checking email input visibility");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).isDisplayed(),
                "Email input should be visible");
    }

    @Then("the password input should be visible")
    public void the_password_input_should_be_visible() {
        logger.info("Checking password input visibility");
        Assert.assertTrue(driver.findElement(passwordInput).isDisplayed(),
                "Password input should be visible");
    }

    @And("I click the Registration link")
    public void i_click_the_registration_link() {
        logger.info("Clicking Registration link");
        wait.until(ExpectedConditions.elementToBeClickable(registrationLink)).click();
    }

    @Then("I should see the Sing in text on the registration page")
    public void i_should_see_the_text_on_the_registration_page() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(signInLink)).isDisplayed(),
                "Text on the registration page is incorrect");
    }

    @And("I fill the login form with email {string} and password {string}")
    public void i_fill_the_login_form_with_email_and_password(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Then("the Sign Out button should be visible")
    public void the_sign_out_button_should_be_visible() {
        logger.info("Checking Sign Out button visibility");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton)).isDisplayed(),
                "Sign Out button should be visible");
    }

    @Then("quit driver")
    public void quit_driver() {
        logger.info("Closing driver");
        driver.quit();
    }

}
