
package Tests;

import Pages.BookStorePage;
import Pages.ElementsCard;
import Pages.HomePage;
import Pages.LoginPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

@Getter
public class BaseTests {
    private WebDriver driver;

    private WebDriverWait driverWait;

    private LoginPage loginPage;

    private HomePage homePage;

    private BookStorePage bookStorePage;

    private ElementsCard elementsCard;


    @BeforeClass


    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tijana\\Desktop\\Kurs\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().getPageLoadTimeout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage = new LoginPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        bookStorePage = new BookStorePage(driver, driverWait);
        elementsCard = new ElementsCard(driver, driverWait);
    }

    @AfterClass

    public void driverClose() {
        driver.close();
    }
}