package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;

/*
- загрузить файл
- проверить, что имя файла на странице совпадает с именем
загруженного файла
 */
public class PageUpLoad extends BasePage {
    private final By BUTTON_CHOOSE_FILE = By.id("file-upload");
    private final By BUTTON_UPLOAD = By.id("file-submit");
    private final By TITLE_UPLOAD = By.xpath("//h3[text()='File Uploaded!']");
    public PageUpLoad(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    public void attachFile() {
        File file = new File("src/main/resources/Hwfile.html");
        driver.findElement(BUTTON_CHOOSE_FILE).sendKeys(file.getAbsolutePath());
        driver.findElement(BUTTON_UPLOAD).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_UPLOAD));
        String fileName = "Hwfile.html";
        String actual = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertTrue(actual.contains("Hwfile.html"));
    }
}