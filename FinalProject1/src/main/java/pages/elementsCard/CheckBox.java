package pages.elementsCard;

import dev.failsafe.internal.util.Assert;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Getter
@NoArgsConstructor
public class CheckBox extends Elements {
    private By checkBoxCard = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[2]");

    private By homeCheckBox = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label");
    private By homeCheckExtendArrow = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button");
    private By homeChildren = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li");

    public CheckBox(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void navigateToCheckbox() {
        getDriver().findElement(this.checkBoxCard).click();
    }

    public void homeCheckBoxCard() {
        navigateToElementsCard();
        getDriver().findElement(this.checkBoxCard).click();
        getDriver().findElement(this.homeCheckBox).click();
    }

    public void homeCheckBoxUncheck (){
        homeCheckBoxCard();
        getDriver().findElement(this.homeCheckBox).click();
    }
    public void clickFirstCheckbox(){
        getDriver().findElement(this.homeCheckBox).click();
    }
    public void verifyFirstCheckBoxChecked(boolean shouldBe){
        WebElement el = getDriver().findElement(this.homeCheckBox);
        if (shouldBe){
            Assert.isTrue(el.isSelected(),"Checkbox is not selected");
        }
        else{
            Assert.isTrue(!el.isSelected(),"Checkbox is selected") ;
        }
    }
    public void clickExtendHomeCheckbox(){
        WebElement arrow = getDriver().findElement(this.homeCheckExtendArrow);
        arrow.click();
    }
    private List<WebElement> getChildrenCheckboxes(){
        return getDriver().findElements(this.homeChildren);
    }
    public void verifyHasChildren(){
        List<WebElement> children = getChildrenCheckboxes();
        Assert.isTrue(children == null|| children.size() == 0,"There is no subnodes from home checkbox");
    }
    public void verifyNumberOfChildren(int count){
        List<WebElement> children = getChildrenCheckboxes();
        Assert.isTrue(children.size() == count, "Size of subnodes not as expected:" + children.size()+"\nExpected: "+count);
    }

    public List<WebElement> results() {
        return getDriver().findElements(By.xpath("//*[@id=\"result\"]/span"));
    }


}
