package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.ContextMenu;
import pages.Dynamic;
import pages.IFrame;
import pages.PageUpLoad;

import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    WebDriver driver;
    SoftAssert softAssert;
    pages.ContextMenu contextMenu;
    Dynamic dynamic;
    IFrame iframe;
    PageUpLoad pageUpLoad;

    @BeforeMethod
    public void setup() {
        // инициализируем асёрт в бифор методе ассёрт
        softAssert = new SoftAssert();

        //убираем окна в браузере
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");

        //инициализируем драйвер и прокинуть сюда опции в скобки
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        contextMenu = new ContextMenu(driver);
        dynamic = new Dynamic(driver);
        iframe = new IFrame(driver);
        pageUpLoad = new PageUpLoad(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}