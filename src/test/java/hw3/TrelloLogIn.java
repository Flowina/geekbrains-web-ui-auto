package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TrelloLogIn {
    WebDriver webDriver;
    private WebElement webElement;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void trelloLoginTest() throws InterruptedException {
        loginTest();

    }

    private void loginTest() throws InterruptedException {
        webDriver.navigate().to("https://trello.com/");
        webElement = webDriver.findElement(By.xpath("//*[text()='Log in']/parent::*"));
        webElement.click();
        Thread.sleep(5000);
        webElement = webDriver.findElement(By.id("user"));
        webElement.sendKeys("metr2307@mail.ru");
        webDriver.findElement(By.cssSelector("#login-form #login")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.id("password")).sendKeys("trello2307");
        webDriver.findElement(By.id("login-submit")).click();

    }

    @Test
    public void createNewBoardTest() throws InterruptedException {
        loginTest();
        WebElement createButton = webDriver.findElement(By.cssSelector("button[data-test-id=header-create-menu-button]"));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
        webDriverWait.until(ExpectedConditions.visibilityOf(createButton));
        createButton.click();
        webDriver.findElement(By.cssSelector("button[data-test-id=header-create-board-button]")).click();
        webDriver.findElement(By.cssSelector("input[data-test-id=create-board-title-input]")).sendKeys("board");
        webDriver.findElement(By.cssSelector("button[data-test-id=create-board-submit-button]")).click();


    }

    @AfterMethod
    public void clear() {
        webDriver.quit();
    }
}

