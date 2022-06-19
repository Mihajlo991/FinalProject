package pages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@NoArgsConstructor
@Getter

public class LoginPage extends BasePage {

    private By userName = By.xpath("//*[@id=\"userName\"]");
    private By password = By.xpath("//*[@id=\"password\"]");
    private By loginBtn = By.xpath("//*[@id=\"login\"]");
    private By logoutBtn = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/button");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void navigateToLoginPage() {
        getDriver().navigate().to("https://demoqa.com/login");
        getDriver().manage().window().maximize();
    }

    public void inputFields(String username, String password) {
        getDriver().findElement(this.userName).sendKeys(username);
        getDriver().findElement(this.password).sendKeys(password);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        getDriver().findElement(this.password).sendKeys(Keys.ENTER);
    }

    public void clickLoginBtn() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.loginBtn));
        getDriver().findElement(this.loginBtn).click();
    }

    public boolean loginCheck() {
        return getDriver().findElement(By.xpath("//*[@id=\"submit\"]")).isDisplayed();
    }

    public void logout() {
        getDriver().findElement(this.logoutBtn).click();
    }

    public String logoutCheck() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]")).getText();
    }

}
