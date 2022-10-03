package Exercises;

import controlerDriver.Driver;
import controlerDriver.DriverName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class DynamicID {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new Driver(DriverName.CHROME).getWebDriver();
        driver.get("http://uitestingplayground.com/dynamicid");
    }

    @Test
    public void test() {
        WebElement button = null;
        try {
            button = driver.findElement(By.xpath("//button[@class= \"btn btn-primary\" and contains(text(), \"Button with Dynamic ID\")]"));
            button.click();
            assertNotNull(button, "SuccessFull");
        }catch (Exception e){
            assertNotNull(button, "Unsuccessfully");
        }

    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
