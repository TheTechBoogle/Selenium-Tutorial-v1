package page;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void goToHomePage(){
        driver.navigate().to("https://www.tesco.com");
    }
}
