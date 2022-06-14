package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreTests extends BaseTests{

    @Test
    public void bookStoreIsPresentTest (){
        getLoginPage().navigateToLoginPage();
        getLoginPage().inputFields("MVarga021", "aAaA0!!!");
        getLoginPage().clickLoginBtn();
        getBookStorePage().navigateToBookStore();
        Assert.assertEquals(getBookStorePage().navigationCheck(), true);
    }
}
