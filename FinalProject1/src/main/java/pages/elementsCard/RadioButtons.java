package pages.elementsCard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

@Getter
@NoArgsConstructor
public class RadioButtons extends Elements {
    private By radioButtonCard = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[3]");
    private By yesRadioBtn = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label");
    private By impressive = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label");
    private By noRadioBtn = By.xpath("//*[@id=\"noRadio\"]");

    public RadioButtons(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public void navigateToRadioButtons() {
        navigateToElementsCard();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        getDriver().findElement(this.radioButtonCard).click();

    }

    public void clickYes() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.yesRadioBtn));
        getDriver().findElement(this.yesRadioBtn).click();
    }

    public boolean isSelectedYesRadioButton() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return getDriver().findElement(By.xpath("//*[@id=\"yesRadio\"]")).isSelected();
    }

    public void clickImpressive() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.impressive));
        getDriver().findElement(this.impressive).click();
    }

    public boolean isSelectedImpressiveRadioButton() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return getDriver().findElement(By.xpath("//*[@id=\"impressiveRadio\"]")).isSelected();
    }

    public boolean noRadioButton() {
        return getDriver().findElement(this.noRadioBtn).isEnabled();
    }
}
