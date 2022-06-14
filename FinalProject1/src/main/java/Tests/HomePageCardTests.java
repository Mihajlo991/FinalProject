package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageCardTests extends BaseTests {
    @BeforeMethod
    public void navigate() {
        getHomePage().navigateToHomePage();
    }

    @Test
    public void clickElementsCardTest() {

        getHomePage().getElementsCard();
        getHomePage().clickElementsCard();
        Assert.assertEquals(getHomePage().clickCheck(), true);
    }

    @Test
    public void clickFormsCardTest() {

        getHomePage().getFormsCard();
        getHomePage().clickFormsCard();
        Assert.assertEquals(getHomePage().clickCheck(), true);
    }

    @Test
    public void clickAlertsCardTest() {

        getHomePage().getAlertsCard();
        getHomePage().clickAlertsCard();
        Assert.assertEquals(getHomePage().clickCheck(), true);
    }

    @Test
    public void clickWidgetsCardTest() {

        getHomePage().getWidgetsCard();
        getHomePage().clickWidgetsCard();
        Assert.assertEquals(getHomePage().clickCheck(), true);
    }

    @Test
    public void clickInteractionsCardTest() {

        getHomePage().getInteractionsCard();
        getHomePage().clickInteractionsCard();
        Assert.assertEquals(getHomePage().clickCheck(), true);
    }

    @Test
    public void clickBookStoreCardTest() {

        getHomePage().getBookStoreCard();
        getHomePage().clickBookStoreCard();
        Assert.assertEquals(getHomePage().clickCheck(), true);
    }

}
