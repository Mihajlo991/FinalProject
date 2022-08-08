package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementsCardTests extends BaseTests {

    @Test
    /** text box test, in 4th assert permananet is typo in code in web page*/

    public void textBoxTests() {
        getTextBox().navigateToElementsCard();
        getTextBox().navigateToTextBox();
        getTextBox().fillInputFields("Mihajlo Varga", "mvarga@test.org",
                "random address", "random address 2");
        getTextBox().submit();
        Assert.assertEquals(getTextBox().nameInTextBox(), "Name:Mihajlo Varga");
        Assert.assertEquals(getTextBox().emailInTextBox(), "Email:mvarga@test.org");
        Assert.assertEquals(getTextBox().currentAddressInTextBox(), "Current Address :random address");
        Assert.assertEquals(getTextBox().permanentAddressInTextBox(), "Permananet Address :random address 2");
    }

    /**
     * Test if all check boxes are selected when we check Home
     */
    @Test

    public void checkBoxTest() {
        getCheckBox().homeCheckBoxCard();
        Assert.assertEquals(getCheckBox().results().size() - 1, 17);
    }

    @Test

    public void checkBoxTestUncheck() {
        getCheckBox().homeCheckBoxUncheck();
        Assert.assertEquals(getCheckBox().results().size(), 0);

    }

    @Test
    public void subNodesCount() {
        getCheckBox().navigateToElementsCard();
        getCheckBox().navigateToCheckbox();
        getCheckBox().clickExtendHomeCheckbox();
        getCheckBox().verifyNumberOfChildren(3);
    }

    /**
     * Tests for radio buttons
     */
    @Test

    public void yesRadioButtonTest() {
        getRadioButtons().navigateToElementsCard();
        getRadioButtons().navigateToRadioButtons();
        getRadioButtons().clickYes();
        Assert.assertEquals(getRadioButtons().isSelectedYesRadioButton(), true);
        Assert.assertEquals(getRadioButtons().isSelectedImpressiveRadioButton(), false);
    }

    @Test

    public void impressiveTest() {
        getRadioButtons().navigateToElementsCard();
        getRadioButtons().navigateToRadioButtons();
        getRadioButtons().clickImpressive();
        Assert.assertEquals(getRadioButtons().isSelectedImpressiveRadioButton(), true);
        Assert.assertEquals(getRadioButtons().isSelectedYesRadioButton(), false);
    }

    @Test

    public void noBtnIsNotClickableTest() {
        getRadioButtons().navigateToElementsCard();
        getRadioButtons().navigateToRadioButtons();
        Assert.assertFalse(getRadioButtons().noRadioButton());
    }

    /**
     * BUTTONS
     */
    @Test
    public void dblClickMsgTest() {
        getButtons().navigateToElementsCard();
        getButtons().navigateToBtns();
        getButtons().doubleClickDblBtn();
        String msg = getButtons().getDblClickMsg();
        Assert.assertEquals(msg, "You have done a double click");
    }

    @Test
    public void rightClickMsgTest() {
        getButtons().navigateToElementsCard();
        getButtons().navigateToBtns();
        getButtons().rightClickRghtBtn();
        String msg = getButtons().getRightClickMsg();
        Assert.assertEquals(msg, "You have done a right click");
    }

    @Test
    public void clickMeMsgTest() {
        getButtons().navigateToElementsCard();
        getButtons().navigateToBtns();
        getButtons().clickMeBtn();
        String msg = getButtons().getClickMeMsg();
        Assert.assertEquals(msg, "You have done a dynamic click");
    }

    @Test
    public void newTabTest1(){
        getLinks().navigateToElementsCard();
        getLinks().navigateToLinksCard();
        getLinks().clickNewTabButton1();
        Assert.assertTrue(getLinks().newTabOpen());
    }

    @Test
    public void newTabTest2(){
        getLinks().navigateToElementsCard();
        getLinks().navigateToLinksCard();
        getLinks().clickNewTabButton2();
        Assert.assertTrue(getLinks().newTabOpen());
    }

    @Test
    public void createdLink (){
        getLinks().navigateToElementsCard();
        getLinks().navigateToLinksCard();
        getLinks().clickCreated();
        Assert.assertEquals(getLinks().assertCreated(), "Link has responded with staus 201 and status text Created");
    }
}
