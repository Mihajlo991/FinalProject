package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests{

    @Test

    public void loginTestHappyFlow (){
        getLoginPage().navigateToLoginPage();
        getLoginPage().inputFields("MVarga021", "aAaA0!!!");
        getLoginPage().clickLoginBtn();
        Assert.assertEquals(getLoginPage().loginCheck(), true);
    }
}
