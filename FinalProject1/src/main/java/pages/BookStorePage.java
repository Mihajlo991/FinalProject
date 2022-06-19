package pages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@NoArgsConstructor
@Getter
public class BookStorePage extends BasePage {

    private By bookStore = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[2]");
    private By gitPocketGuide = By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a");
    private By addToCollectionBtn = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button");

    private By profile = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]");

    public BookStorePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void navigateToBookStore() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        getDriver().findElement(this.bookStore).click();
    }

    public boolean navigationCheck() {
        return getDriver().findElement(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a")).isDisplayed();
    }

    public void addBookToCollection() {
        navigateToBookStore();
        getDriver().findElement(this.gitPocketGuide).click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.addToCollectionBtn));
        getDriver().findElement(this.addToCollectionBtn).click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public void goToProfile() {
        Alert alt = getDriver().switchTo().alert();
        alt.accept();
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.profile));
        getDriver().findElement(this.profile).click();

    }

    public boolean collectionCheck() {

        return getDriver().findElement(By.xpath("//*[@id='see-book-Git Pocket Guide']/a")).isDisplayed();
    }

    public void deleteBook() {
        getDriver().findElement(By.xpath("//*[@id=\"delete-record-undefined\"]")).click();
        getDriver().findElement(By.xpath("//*[@id=\"closeSmallModal-ok\"]")).click();
    }

    public String deleteCheck() {
        return getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[1]")).getText();
    }
}
