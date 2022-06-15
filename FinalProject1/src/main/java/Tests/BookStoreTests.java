package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreTests extends BaseTests{

  // @Test (priority = 3) /** first test just to see what's happening but useless after another test are written */
  /*  public void bookStoreIsPresentTest (){
        getLoginPage().navigateToLoginPage();
        getLoginPage().inputFields("MVarga021", "aAaA0!!!");
      //  getLoginPage().clickLoginBtn();
        getBookStorePage().navigateToBookStore();
        Assert.assertEquals(getBookStorePage().navigationCheck(), true);
    }*/

    @Test (priority = 1) /** test for adding book to collection, works as single test but something goes wrong when class is run*/
    public void addBookTest (){
        getLoginPage().navigateToLoginPage();
        getLoginPage().inputFields("MVarga021", "aAaA0!!!");
       // getLoginPage().clickLoginBtn();
        getBookStorePage().addBookToCollection();
        getBookStorePage().goToProfile();
        Assert.assertEquals(getBookStorePage().collectionCheck(), true);

    }

    @Test (priority = 2)
    public void deleteFromCollectionTest (){
        getBookStorePage().deleteBook();
        Assert.assertFalse(getBookStorePage().collectionCheck());

    }
}
