package Tests;

import org.testng.annotations.Test;

public class PageUpLoad  extends BaseTest{
    @Test
    public  void checkUpload(){
        pageUpLoad.open();
        pageUpLoad.attachFile();
    }
}