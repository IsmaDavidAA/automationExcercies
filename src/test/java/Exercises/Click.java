package Exercises;

import controlerDriver.Driver;
import controlerDriver.DriverName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Click {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new Driver(DriverName.CHROME).getWebDriver();
        driver.get("http://uitestingplayground.com/click");
    }

    @Test
    public void test() {
        String initialButtonText = "Button That Ignores DOM Click Event";
        driver.findElement(By.xpath("//button[@id='badButton']")).click();
        String secondButtonText = driver.findElement(By.xpath("//button[@id='badButton']")).getText();
        assertTrue(initialButtonText.equals(secondButtonText),"SuccessFull");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
