package hw6.tests;

import hw6.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrelloLoginTest extends AbstratBaseTest {
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void trelloLoginTest() throws InterruptedException {
        loginPage.open();
        loginPage.logIn("metr2307@mail.ru", "trello2307");
    }
}
