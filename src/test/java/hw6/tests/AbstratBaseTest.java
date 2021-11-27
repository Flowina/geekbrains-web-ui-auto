package hw6.tests;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstratBaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("–lang= en");
        driver = new ChromeDriver(chromeoptions);
        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void clear() {
        addBrowserLogs();

        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    private void addBrowserLogs() {
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        StringBuilder sb = new StringBuilder();
        if (allLogRows.size() > 0 ) {
            for (LogEntry item:
                allLogRows) {
                sb.append(String.format("%s: %s %n", item.getLevel().getName(), item.getMessage()));
            }
        } else {
            sb.append("There is no a browser log");
        }
        Allure.addAttachment("Browser log", sb.toString());
    }
}
