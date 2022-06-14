package Pages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


@NoArgsConstructor
@Getter

public class LoginPage extends BasePage {

    private By userName = By.xpath("//*[@id=\"userName\"]");
    private By password = By.xpath("//*[@id=\"password\"]");
    private By loginBtn = By.xpath("//*[@id=\"login\"]");

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
    }

    public void clickLoginBtn() {
        getDriver().findElement(this.loginBtn).click();
    }

    public boolean loginCheck() {
        return getDriver().findElement(By.xpath("//*[@id=\"submit\"]")).isDisplayed();
    }

}
