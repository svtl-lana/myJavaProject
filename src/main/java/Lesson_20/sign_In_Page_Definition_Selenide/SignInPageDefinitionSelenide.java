package Lesson_20.sign_In_Page_Definition_Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import utils.Links;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SignInPageDefinitionSelenide {

    private static final SelenideElement emailInput = $(By.name("email"));
    private static final SelenideElement passwordInput = $(By.name("password"));
    private static final SelenideElement signInButton = $(By.xpath("//button[@type='submit']"));
    private static final SelenideElement registrationLink = $(By.xpath("//span[text()='Registration']"));
    private static final SelenideElement signOutButton = $(By.xpath("//div[text()='Sign Out']"));
    private static final SelenideElement signInLink = $(By.xpath("//span[text()='Sing in']"));

    @Given("Set up driver Selenide")
    public void set_up_driver_selenide() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";

    }

    @When("I open the Sign In page Selenide")
    public void i_open_the_sign_in_page_selenide() {
        open(Links.ANDERSEN_SIGN_IN.getLink());
    }

    @And("I click the Sign In button Selenide")
    public void i_click_the_sign_in_button_selenide() {
        signInButton.click();
    }

    @Then("the email input should be visible Selenide")
    public void the_email_input_should_be_visible_selenide() {
        emailInput.shouldBe(visible);
    }

    @Then("the password input should be visible Selenide")
    public void the_password_input_should_be_visible_selenide() {
        passwordInput.shouldBe(visible);
    }

    @And("I click the Registration link Selenide")
    public void i_click_the_registration_link_selenide() {
        registrationLink.click();
    }

    @Then("I should see the Sing in text on the registration page Selenide")
    public void i_should_see_the_text_on_the_registration_page_selenide() {
        signInLink.shouldBe(visible);
    }

    @And("I fill the login form with email {string} and password {string} Selenide")
    public void i_fill_the_login_form_with_email_and_password_selenide(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
    }

    @Then("the Sign Out button should be visible Selenide")
    public void the_sign_out_button_should_be_visible_selenide() {
        signOutButton.shouldBe(visible);
    }

    @Then("quit driver Selenide")
    public void quit_driver_selenide() {
        closeWebDriver();
    }
}
