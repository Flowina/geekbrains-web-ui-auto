package hw6.tests;

import hw6.pages.CreateNewBoardPage;
import hw6.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateNewBoardTest {
    private CreateNewBoardPage createBoardPage;
    private LoginPage loginPage;
    private WebDriver driver;

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

    @BeforeMethod(alwaysRun = true)
    public void initPage() {
        createBoardPage = new CreateNewBoardPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void createNewBoardTest() throws InterruptedException {
        String boardName = "board";
        loginPage.open();
        loginPage.logIn("metr2307@mail.ru", "trello2307");
        Thread.sleep(5000);
        createBoardPage.createBoard(boardName);
        Thread.sleep(2000);
        assertThat(createBoardPage.getBoardName()).isEqualTo(boardName);
    }

}
