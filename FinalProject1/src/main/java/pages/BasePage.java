package pages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@Getter
@NoArgsConstructor
public class BasePage {
    private WebDriver driver;
    private WebDriverWait driverWait;
    Actions action;

    public BasePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
        this.action = new Actions(driver);
    }

    public void scrollToBottom() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public void scrollToTop() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_UP).build().perform();
    }

}
