package hw6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewBoardPage extends BasePage {

    private static final String URL = "https://trello.com/vil_bill/boards";

    @FindBy(css = "button[data-test-id=header-create-menu-button]")
    private WebElement createButton;

    @FindBy(css = "button[data-test-id=header-create-board-button]")
    private WebElement createBoardButton;

    @FindBy(css = "input[data-test-id=create-board-title-input]")
    private WebElement boardTitle;

    @FindBy(css = "button[data-test-id=create-board-submit-button]")
    private WebElement createSubmitButton;

    @FindBy(css = ".mod-board-name .board-header-btn-text")
    private WebElement createdNewBoard;

    public CreateNewBoardPage(WebDriver driver) {
        super(driver);
    }

    public void createBoard(String boardName) throws InterruptedException {
        //WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        //webDriverWait.until(ExpectedConditions.visibilityOf(createButton));
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(createButton));
        createButton.click();
        createBoardButton.click();
        boardTitle.sendKeys(boardName);

        Thread.sleep(2000);
        // scroll to the button
        Actions actions = new Actions(driver);
        actions.moveToElement(createSubmitButton);
        actions.perform();

        createSubmitButton.click();
        //webDriverWait.until(ExpectedConditions.visibilityOf(createdNewBoard));

    }

    public String getBoardName() {
        return createdNewBoard.getText();
    }
}
