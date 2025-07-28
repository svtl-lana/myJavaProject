package lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Links;
import java.util.Arrays;
import java.util.List;
public class OpenPages {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        List<Links> links = Arrays.asList(
                Links.AUTOMATION_PRACTICE,
                Links.ZOO,
                Links.W3SCHOOLS,
                Links.CLICK_SPEED_TEST,
                Links.ANDERSEN
        );

        driver.get(links.get(0).getLink());
        for (int i = 1; i < links.size(); i++) {
            driver.switchTo().newWindow(WindowType.WINDOW);
            driver.get(links.get(i).getLink());
        }

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            String title = driver.getTitle();
            String url = driver.getCurrentUrl();
            System.out.println("Title:" + title);
            System.out.println("URL:" + url);

            if (title.toLowerCase().contains("zoo")) {
                System.out.println("Closing Zoo page");
                driver.close();
            }
        }
        driver.quit();
    }
}