
package Tests;

import Pages.LoginPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
@Getter
public class BaseTests {
    private WebDriver driver;

    private WebDriverWait driverWait;

    private LoginPage loginPage;


    @BeforeClass


    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tijana\\Desktop\\Kurs\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().getPageLoadTimeout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage = new LoginPage(driver, driverWait);
    }

    @AfterClass

    public void driverClose (){
        driver.close();
    }
}