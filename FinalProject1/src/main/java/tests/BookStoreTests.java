package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookStoreTests extends BaseTests {


    @Test(priority = 1)
    /** test for adding book to collection, works as single test but something goes wrong when class is run*/
    public void addBookTest() {
        getLoginPage().navigateToLoginPage();
        getLoginPage().inputFields("MVarga021", "aAaA0!!!");
        getBookStorePage().addBookToCollection();
        getBookStorePage().goToProfile();
        Assert.assertEquals(getBookStorePage().collectionCheck(), true);

    }

    @Test(priority = 2)
    public void deleteFromCollectionTest() {
        getBookStorePage().deleteBook();
        Assert.assertEquals(getBookStorePage().deleteCheck(), "");

    }
}
