package pages;
/*
- правый клик по элементу
- валидация текста на алерте
- закрытие алерта
 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ContextMenu extends BasePage {

    private final By HOT_SPOT = By.id("hot-spot");
    private final By TITLE = By.xpath("//h3");
    Actions actions = new Actions(driver);

    public ContextMenu(WebDriver driver) {
        super(driver);
    }


    public void openPage() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
    }

    public void findHotSpot() {
        WebElement hotSpot = driver.findElement(HOT_SPOT);
        actions.contextClick(hotSpot).perform();
    }

    public void findAlertAndCheck() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "You selected a context menu");
    }

    public void closeAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}