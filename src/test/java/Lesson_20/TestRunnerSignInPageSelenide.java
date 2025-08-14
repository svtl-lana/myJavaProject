package Lesson_20;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json"},
        features = {"src/test/resources/feature_selenide"},
        glue = {"Lesson_20/sign_In_Page_Definition_Selenide"}
)
public class TestRunnerSignInPageSelenide extends AbstractTestNGCucumberTests {
}
