package hw6.tests;

import hw6.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Trello")
@Feature("Log in")
public class TrelloLoginTest extends AbstratBaseTest {
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    @Step
    public void trelloLoginTest() throws InterruptedException {
        loginPage.open();
        loginPage.logIn("metr2307@mail.ru", "trello2307");
    }
}
