package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginLogoutTests extends BaseTests {

    @Test(priority = 1)

    public void loginTestHappyFlow() {
        getLoginPage().navigateToLoginPage();
        getLoginPage().inputFields("MVarga021", "aAaA0!!!");
        Assert.assertEquals(getLoginPage().loginCheck(), true);
    }

    @Test(priority = 2)

    public void logoutTest() {
        getLoginPage().logout();
        Assert.assertEquals(getLoginPage().logoutCheck(), "Login");

    }


}
