package pages.elementsCard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

@Getter
@NoArgsConstructor
public class Buttons extends Elements {

    private By buttonsTab = By.xpath("//div[@class = 'left-pannel']//ul/li/span[text() = 'Buttons']/..");
    private By doubleClickBtn = By.xpath("//div/button[text() = 'Double Click Me']");
    private By rightClickBtn = By.xpath("//div/button[text() = 'Right Click Me']");
    private By clickMeBtn = By.xpath("//div/button[text() = 'Click Me']");
    private By doubleClickMsg = By.xpath("//p[@id = 'doubleClickMessage']");
    private By rightClickMsg = By.xpath("//p[@id = 'rightClickMessage']");
    private By clickMsg = By.xpath("//p[@id = 'dynamicClickMessage']");

    public Buttons(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void navigateToBtns() {
        scrollToBottom();
        getDriver().findElement(buttonsTab).click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void doubleClickDblBtn() {
        doubleClickElement(getDriver().findElement(doubleClickBtn));
    }

    public void rightClickRghtBtn() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        getAction().contextClick(getDriver().findElement(rightClickBtn)).build().perform();
    }

    public void clickMeBtn() {
        getDriver().findElement(clickMeBtn).click();
    }

    public String getDblClickMsg() {
        WebElement pMsg = waitDblClickMsg();
        return pMsg.getText();
    }

    public String getRightClickMsg() {
        WebElement pMsg = waitRigthClickMsg();
        return pMsg.getText();
    }

    public String getClickMeMsg() {
        WebElement pMsg = waitClickClickMsg();
        return pMsg.getText();
    }

    public WebElement waitDblClickMsg() {
        return getDriverWait().withMessage("There is no msg for double click button ").until(ExpectedConditions.visibilityOfElementLocated(doubleClickMsg));
    }

    public WebElement waitRigthClickMsg() {
        return getDriverWait().withMessage("There is no msg for right click button").until(ExpectedConditions.visibilityOfElementLocated(rightClickMsg));
    }

    public WebElement waitClickClickMsg() {
        return getDriverWait().withMessage("There is no msg for click me button ").until(ExpectedConditions.visibilityOfElementLocated(clickMsg));
    }
}
