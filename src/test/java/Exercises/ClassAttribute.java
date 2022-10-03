package Exercises;

import controlerDriver.Driver;
import controlerDriver.DriverName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        try{
            driver.findElement(By.xpath("//button[contains(@class, \"btn-primary\")]")).click();
            Thread.sleep(3000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(3000);
            assertNotNull(driver.findElement(By.xpath("//button[contains(@class, \"btn-primary\")]")), "Button identified");
        }catch (Exception e){
            assertNotNull(driver.findElement(By.xpath("//button[contains(@class, \"btn-primary\")]")), "Button not identified");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
