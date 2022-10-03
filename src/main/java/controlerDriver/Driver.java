package controlerDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private WebDriver driver;
    public Driver(DriverName driverName) {
        this.driver = findDriverPath(driverName);
    }
    private WebDriver findDriverPath(DriverName driverName){
        WebDriver instantWebSriver;
        switch (driverName){
            case CHROME:
                System.out.println("chrome");
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                instantWebSriver = new ChromeDriver();
                break;
            case EDGE:
                System.out.println("edge");
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                instantWebSriver = new ChromeDriver();
                break;
            default: FIREFOX:
                System.out.println("firefox");
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                instantWebSriver = new ChromeDriver();
                break;
        }
        return instantWebSriver;
    }
    public WebDriver getWebDriver() {
        return driver;
    }
}
