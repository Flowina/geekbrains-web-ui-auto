package hw6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private static final String URL = "https://trello.com/login";

    @FindBy(id = "user")
    private WebElement email;

    @FindBy(css = "#login-form #login")
    private WebElement logInWithAtlassianButton;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-submit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Log in page")
    public void open() {
        driver.navigate().to(URL);
        driver.manage().addCookie(new Cookie("lang", "en"));

    }

    @Step("Log in as '{0}' with password '{1}'")
    public void logIn(String email, String password) throws InterruptedException {
        this.email.sendKeys(email);
        logInWithAtlassianButton.click();
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
//        webDriverWait.until(ExpectedConditions.visibilityOf(this.password));
        Thread.sleep(5000);
        this.password.sendKeys(password);
        submitButton.click();

    }
}
