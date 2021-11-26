package hw6.tests;

import hw6.pages.CreateNewBoardPage;
import hw6.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateNewBoardTest extends AbstratBaseTest {
    private CreateNewBoardPage createBoardPage;
    private LoginPage loginPage;

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



