package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
/*
- нажать на кнопку Remove около чекбокса
- дождаться надписи “It’s gone”
- проверить, что чекбокса нет
- найти инпут
- проверить, что он disabled
- нажать на кнопку
- дождаться надписи “It's enabled!”
- проверить, что инпут enabled
 */

public class Dynamic extends BasePage {
    private final By BUTTON_REMOVE = By.xpath("//button[text()='Remove']");
    private final By SIGHNISGONE = By.id("message");
    private final By CHECK_BOX = By.xpath("//input[@type='checkbox']");
    private final By INPUT = By.xpath("//input[@type='text']");
    private final By BUTTONDISABLED = By.xpath("//button[text()='Enable']");
    //private final By SIGHITSENABLED = By.xpath("//p[text()='It's enabled!'");
    private final By BUTTONENABLED = By.xpath("//button[text()='Disable']");
    private final By TITLE = By.xpath("//h4[text()='Dynamic Controls']");
    public Dynamic(WebDriver driver) {
        super(driver);
    }

    public void openPageDinamic() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
    }

    public void pressRemove() {
        driver.findElement(BUTTON_REMOVE).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(SIGHNISGONE));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(CHECK_BOX));
    }

    public void CheckInput() {
        driver.findElement(INPUT);
        By button = BUTTONDISABLED;
        String expected = "Enable";
        String actual = driver.findElement(BUTTONDISABLED).getText();
        Assert.assertTrue(actual.contains("Enable"));
        driver.findElement(BUTTONDISABLED).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(SIGHITSENABLED));
        wait.until(ExpectedConditions.elementToBeClickable(INPUT));

    }
}

