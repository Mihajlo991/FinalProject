package Pages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@NoArgsConstructor
@Getter
public class HomePage extends BasePage {


    private By elementsCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    private By formsCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]");
    private By alertsCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]");
    private By widgetsCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[4]");
    private By interactionsCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[5]");
    private By bookStoreCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]");

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void navigateToHomePage() {
        getDriver().navigate().to("https://demoqa.com/");
        getDriver().manage().window().maximize();
    }

    public WebElement getElementsCard() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(elementsCard);
    }

    public void clickElementsCard() {
        getElementsCard().click();
    }

    public WebElement getFormsCard() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(formsCard);
    }

    public void clickFormsCard() {
        getFormsCard().click();
    }

    public WebElement getAlertsCard() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(alertsCard);
    }

    public void clickAlertsCard() {
        getAlertsCard().click();
    }

    public WebElement getWidgetsCard() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(widgetsCard);
    }

    public void clickWidgetsCard() {
        getWidgetsCard().click();
    }

    public WebElement getInteractionsCard() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(interactionsCard);
    }

    public void clickInteractionsCard() {
        getInteractionsCard().click();
    }

    public WebElement getBookStoreCard() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        return getDriver().findElement(interactionsCard);
    }

    public void clickBookStoreCard() {
        getBookStoreCard().click();
    }


    public boolean clickCheck() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]")).isDisplayed();
    }
}
