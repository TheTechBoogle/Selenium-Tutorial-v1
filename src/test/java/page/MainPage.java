package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }


    private final By SUB_MENU_OPTIONS = By.cssSelector(".nav-dropdown .dropdown-menu.true a.nav-link");
    private final By COMPLETE_SEARCH_BUTTON = By.cssSelector(".search-bar button[type=submit]");
    private final By SEARCH_TEXT_INPUT_BOX = By.cssSelector("input[placeholder=Search]");


    public void openNavigationMenu(String navArea) {
        driver.findElement(By.cssSelector("nav .nav-dropdown [title=" + navArea + "]")).click();
    }

    public void chooseNavSubMenuItem(String subMenuItem) {
        FindAndClickMenuItemByText(SUB_MENU_OPTIONS, subMenuItem);
    }

    public void searchForItem(String itemName) {
        WebElement searchBox = driver.findElement(SEARCH_TEXT_INPUT_BOX);
        searchBox.click();
        searchBox.sendKeys(itemName);
        driver.findElement(COMPLETE_SEARCH_BUTTON).click();
    }

    public Product getFirstProduct() {
        return new Product(driver.findElement(By.cssSelector("ul.product-list li.first")));
    }

    public class Product {

        private final WebElement element;

        public Product(WebElement element) {
            this.element = element;
        }

        public boolean isInDeal() {
            try {
                element.findElement(By.cssSelector("div.styles__StyledPromotionsOfferContent-sc-1vdpoop-1"));
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        public String getOfferText() {
            return element.findElement(By.cssSelector(".offer-text")).getText().trim();
        }

    }

}
