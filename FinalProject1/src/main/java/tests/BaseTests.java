
package tests;

import pages.BookStorePage;
import pages.HomePage;
import pages.LoginPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.elementsCard.Buttons;
import pages.elementsCard.CheckBox;
import pages.elementsCard.RadioButtons;
import pages.elementsCard.TextBox;

import java.time.Duration;

@Getter
public class BaseTests {
    private WebDriver driver;

    private WebDriverWait driverWait;

    private LoginPage loginPage;

    private HomePage homePage;

    private BookStorePage bookStorePage;

    private CheckBox checkBox;

    private TextBox textBox;

    private RadioButtons radioButtons;

    private Buttons buttons;

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
        checkBox = new CheckBox(driver, driverWait);
        textBox = new TextBox(driver, driverWait);
        radioButtons = new RadioButtons(driver, driverWait);
        buttons = new Buttons(driver, driverWait);

    }

    @AfterClass

    public void driverClose() {
        driver.close();
    }
}