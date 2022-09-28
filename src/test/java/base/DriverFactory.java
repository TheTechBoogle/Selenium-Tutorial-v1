package base;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory{
    private WebDriver driver;

    static{
        ChromeDriverManager.chromedriver().setup();
    }

    public WebDriver getDriver() {
        if(driver == null){
            setDriver();
        }
        return driver;
    }

    public void setDriver() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }
}
