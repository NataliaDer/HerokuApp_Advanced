package Tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu extends BaseTest{

    @Test
    public void CheckPage(){
    contextMenu.openPage();
    contextMenu.isPageOpened();
    contextMenu.findHotSpot();
    contextMenu.findAlertAndCheck();
    contextMenu.closeAlert();
    }
}