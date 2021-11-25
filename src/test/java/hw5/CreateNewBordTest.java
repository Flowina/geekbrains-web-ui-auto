package hw5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.xpath;

public class CreateNewBordTest extends AbstractBaseTest {
    @Test
    public void createNewBoardTest() throws InterruptedException {
        String boardName = "board";
        loginTest();
        WebElement createButton = webDriver.findElement(By.cssSelector("button[data-test-id=header-create-menu-button]"));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
        webDriverWait.until(ExpectedConditions.visibilityOf(createButton));
        assertThat(createButton.getText()).isEqualTo("Create");
        createButton.click();
        webDriver.findElement(By.cssSelector("button[data-test-id=header-create-board-button]")).click();
        webDriver.findElement(By.cssSelector("input[data-test-id=create-board-title-input]")).sendKeys(boardName);
        webDriver.findElement(By.cssSelector("button[data-test-id=create-board-submit-button]")).click();

        WebElement boardNameElement = webDriver.findElement(By.cssSelector(".mod-board-name .board-header-btn-text"));
        webDriverWait.until(ExpectedConditions.visibilityOf(boardNameElement));
        assertThat(boardNameElement.getText()).isEqualTo(boardName);

    }

}
