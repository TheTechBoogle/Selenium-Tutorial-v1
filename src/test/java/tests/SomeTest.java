package tests;

import base.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.MainPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SomeTest {
    private DriverFactory driverFactory = new DriverFactory();
    private WebDriver driver = driverFactory.getDriver();
    private HomePage homePage = new HomePage(driver);
    private MainPage mainPage = new MainPage(driver);

    @Before
    public void TestSetUp(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homePage.goToHomePage();
    }

    @Test
    public void ClickOnSubMenuItem(){
        mainPage.openNavigationMenu("Groceries");
        mainPage.chooseNavSubMenuItem("Shop groceries");
        mainPage.searchForItem("timothy taylor");
        MainPage.Product product = mainPage.getFirstProduct();
        Assert.assertTrue(product.isInDeal());
        Assert.assertEquals("Any 4 for 6 Clubcard Price - Selected Beers 250ml - 500ml", product.getOfferText());
    }

    @After
    public void TestTearDown(){
        driver.quit();
    }


}
