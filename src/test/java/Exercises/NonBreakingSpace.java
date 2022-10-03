package Exercises;

import controlerDriver.Driver;
import controlerDriver.DriverName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class NonBreakingSpace {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new Driver(DriverName.CHROME).getWebDriver();
        driver.get("http://uitestingplayground.com/nbsp");
    }

    @Test
    public void test() {
        WebElement button = null;
        try {
            button = driver.findElement(By.xpath("//button[text()='My Button']"));//alt+0160
            button.click();
            assertNotNull(button, "SuccessFull");
        }catch (Exception e){
            assertFalse(Boolean.TRUE);
        }

    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
