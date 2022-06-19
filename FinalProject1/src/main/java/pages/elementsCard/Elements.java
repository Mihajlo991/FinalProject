package pages.elementsCard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

@NoArgsConstructor
@Getter
public class Elements extends BasePage {
    public Elements(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void navigateToElementsCard() {
        getDriver().navigate().to("https://demoqa.com/elements");
        getDriver().manage().window().maximize();
    }

    public void doubleClickElement(WebElement el) {
        getAction().doubleClick(el).build().perform();
    }

}
