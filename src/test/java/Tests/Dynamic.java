package Tests;

import org.testng.annotations.Test;

public class Dynamic extends BaseTest{
    @Test
    public void checkDynamic(){
        dynamic.openPageDinamic();
        dynamic.pressRemove();
        dynamic.CheckInput();
    }
}