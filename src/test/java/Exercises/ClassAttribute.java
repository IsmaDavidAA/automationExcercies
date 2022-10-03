package Exercises;

import controlerDriver.Driver;
import controlerDriver.DriverName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ClassAttribute {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new Driver(DriverName.CHROME).getWebDriver();
        driver.get("http://uitestingplayground.com/classattr");
    }

    @Test
    public void test() {
        WebElement button = null;
        try{
            button = driver.findElement(By.xpath("//button[contains(@class, \"btn-primary\")]"));
            button.click();
            Thread.sleep(3000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(3000);
            assertNotNull(button, "Button identified");
        }catch (Exception e){
            assertNotNull(button, "Button not identified");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
