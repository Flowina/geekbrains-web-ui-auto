package hw5;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class AbstractBaseTest {
    WebDriver webDriver;
    public WebElement webElement;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("–lang= en");
        webDriver = new ChromeDriver(chromeoptions);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void loginTest() throws InterruptedException {
        webDriver.navigate().to("https://trello.com/en");
        webDriver.manage().addCookie(new Cookie("lang", "en"));
        // webDriver.manage().deleteCookieNamed("lang");
        webElement = webDriver.findElement(By.xpath("//a[text()='Log in']"));
        webElement.click();
        Thread.sleep(5000);
        webElement = webDriver.findElement(By.id("user"));
        webElement.sendKeys("metr2307@mail.ru");
        webDriver.findElement(By.cssSelector("#login-form #login")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.id("password")).sendKeys("trello2307");
        webDriver.findElement(By.id("login-submit")).click();
    }

    @AfterMethod
    public void clear() {
        webDriver.quit();
    }
}
