package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public WebDriver Driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        Driver = new ChromeDriver();
        Driver.get("http://automationpractice.com/index.php");
        Driver.manage().window().maximize();
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

}