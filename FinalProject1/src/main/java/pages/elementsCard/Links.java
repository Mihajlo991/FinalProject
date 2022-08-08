package pages.elementsCard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

@NoArgsConstructor
@Getter
public class Links extends Elements{
    private By linkCard = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[6]");
    private By newTab1 = By.xpath("//*[@id=\"simpleLink\"]");

    private By newTab2 = By.xpath("//*[@id=\"dynamicLink\"]");

    private  By created = By.id("created");

    public Links(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);}

    public void navigateToLinksCard (){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        getDriver().findElement(this.linkCard).click();
    }

    public void clickNewTabButton1 (){
        getDriver().findElement(this.newTab1).click();
    }

    public boolean newTabOpen (){
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/header/a/img")));
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/header/a/img")).isDisplayed();
    }

    public void clickNewTabButton2 (){
        getDriver().findElement(this.newTab2).click();
    }

    public void clickCreated (){
        getDriver().findElement(this.created).click();
    }

    public String assertCreated(){
        return getDriver().findElement(By.xpath("//*[@id=\"linkResponse\"]")).getText();
    }
}
