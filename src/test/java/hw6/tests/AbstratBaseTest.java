package hw6.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

public class AbstratBaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("–lang= en");
        driver = new ChromeDriver(chromeoptions);
        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void clear() {
        driver.quit();
    }
}
