package pages.elementsCard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
@NoArgsConstructor
public class TextBox extends Elements {
    private By textBox = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]");
    private By fullName = By.xpath("//*[@id=\"userName\"]");
    private By email = By.xpath("//*[@id=\"userEmail\"]");
    private By currentAddress = By.xpath("//*[@id=\"currentAddress\"]");
    private By permanentAddress = By.xpath("//*[@id=\"permanentAddress\"]");
    private By submitButton = By.xpath("//*[@id=\"submit\"]");

    public TextBox(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void navigateToTextBox() {
        getDriver().findElement(this.textBox).click();
    }

    public void fillInputFields(String fullNameM, String emailM, String currentAddressM, String permanentAddressM) {
        getDriver().findElement(this.fullName).sendKeys(fullNameM);
        getDriver().findElement(this.email).sendKeys(emailM);
        getDriver().findElement(this.currentAddress).sendKeys(currentAddressM);
        getDriver().findElement(this.permanentAddress).sendKeys(permanentAddressM);
    }

    public void submit() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        getDriver().findElement(this.submitButton).click();
    }

    public String nameInTextBox() {
        return getDriver().findElement(By.xpath("//*[@id=\"name\"]")).getText();


    }

    public String emailInTextBox() {
        return getDriver().findElement(By.xpath("//*[@id=\"email\"]")).getText();
    }

    public String currentAddressInTextBox() {
        return getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]")).getText();
    }

    public String permanentAddressInTextBox() {
        return getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]")).getText();
    }
}

