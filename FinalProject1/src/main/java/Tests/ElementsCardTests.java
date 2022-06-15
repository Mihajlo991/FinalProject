package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsCardTests extends BaseTests{

    @Test /** text box test, in 4th assert permananet is typo in code in web page*/

    public void textBoxTests (){
    getElementsCard().navigateToElementsCard();
    getElementsCard().navigateToTextBox();
    getElementsCard().fillInputFields("Mihajlo Varga", "mvarga@test.org",
            "random address", "random address 2");
    getElementsCard().submit();
        Assert.assertEquals(getElementsCard().nameInTextBox(), "Name:Mihajlo Varga");
        Assert.assertEquals(getElementsCard().emailInTextBox(), "Email:mvarga@test.org");
        Assert.assertEquals(getElementsCard().currentAddressInTextBox(), "Current Address :random address");
        Assert.assertEquals(getElementsCard().permanentAddressInTextBox(), "Permananet Address :random address 2");
    }

    @Test

    public void checkBoxTest (){
        getElementsCard().HomeCheckBoxCard();
        Assert.assertEquals(getElementsCard().results().size() - 1, 17);
    }
}
