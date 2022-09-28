package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {

    protected final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public void WaitAndClick(By selector){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }

    public void FindAndClickSubMenuItem(By parentSelector, By childSelector){
        Actions actions = new Actions(driver);
        WebElement mainMenuButton = driver.findElement(parentSelector);
        actions.moveToElement(mainMenuButton);
        WebElement subMenuButton = driver.findElement(childSelector);
        actions.moveToElement(subMenuButton);
        actions.click().build().perform();
    }

    public void FindAndClickMenuItemByText(By MenuSelector, String name){
        List<WebElement> elements = driver.findElements(MenuSelector);
        for (WebElement element : elements) {
            if (element.getText().trim().equals(name)){
                element.click();
                return;
            }
        }
        Assert.fail("Sub menu item not found");
    }

    public void FindAndType(By Selector, String value){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Selector));
        element.sendKeys(value);
    }


}



