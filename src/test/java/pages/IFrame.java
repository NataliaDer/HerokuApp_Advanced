package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/*
- Открыть iFrame
- Проверить, что текст внутри параграфа равен “Your content
goes here.”
 */
public class IFrame extends BasePage {

    private final By POPUP = By.xpath("//*[@class='tox-notification tox-notification--in tox-notification--warning']");
    private final By CLOSE_NOTIFICATION = By.xpath("//div[@aria-label='Close']");
    //private final By FRAME = By.id("mce_0_ifr");
    private final By TEXT = By.id("tinymce");
    public IFrame(WebDriver driver) {
        super(driver);
    }

    public void openIframePage() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.findElement(CLOSE_NOTIFICATION).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(POPUP));
    }

    public void checkText() {
        driver.switchTo().frame("mce_0_ifr");
        WebElement text = driver.findElement(TEXT);
        String iframetext = text.getText();
        Assert.assertTrue(iframetext.contains("Your content goes here."));
        driver.switchTo().defaultContent();
    }
}