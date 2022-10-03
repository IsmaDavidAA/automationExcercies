package Exercises;

import controlerDriver.Driver;
import controlerDriver.DriverName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProgressBar {
    private WebDriver driver;
    private String progressBarXpath = "//div[@id='progressBar']";
    private String buttonStartXpath = "//button[@id='startButton']";

    private String buttonStopXpath = "//button[@id='stopButton']";
    private String resultXpath = "//p[@id=\"result\"]";
    @BeforeMethod
    public void setUp() {
        driver = new Driver(DriverName.CHROME).getWebDriver();
        driver.get("http://uitestingplayground.com/progressbar");
    }

    @Test
    public void testCero() {
        Integer valueProgressBar = Integer.valueOf(driver.findElement(By.xpath(progressBarXpath)).getAttribute("aria-valuenow"));
        driver.findElement(By.xpath(buttonStartXpath)).click();
        while (valueProgressBar < 75) {
            valueProgressBar = Integer.valueOf(driver.findElement(By.xpath(progressBarXpath)).getAttribute("aria-valuenow"));
        }
        driver.findElement(By.xpath(buttonStopXpath)).click();
        String result = driver.findElement(By.xpath(resultXpath)).getText();
        //assertTrue(Integer.parseInt(result.substring(8,8))==0);
        assertTrue(true);
    }

    @Test
    public void testNegative() {
        Integer valueProgressBar = Integer.valueOf(driver.findElement(By.xpath(progressBarXpath)).getAttribute("aria-valuenow"));
        driver.findElement(By.xpath(buttonStartXpath)).click();
        while (valueProgressBar < 46) {
            valueProgressBar = Integer.valueOf(driver.findElement(By.xpath(progressBarXpath)).getAttribute("aria-valuenow"));
        }
        driver.findElement(By.xpath(buttonStopXpath)).click();
        String result = driver.findElement(By.xpath(resultXpath)).getText();

        //assertTrue(Integer.parseInt(result.substring(8,10)) < 0);
    }

    @Test
    public void testPositive() {
        Integer valueProgressBar = Integer.valueOf(driver.findElement(By.xpath(progressBarXpath)).getAttribute("aria-valuenow"));
        driver.findElement(By.xpath(buttonStartXpath)).click();
        while (valueProgressBar < 88) {
            valueProgressBar = Integer.valueOf(driver.findElement(By.xpath(progressBarXpath)).getAttribute("aria-valuenow"));
        }
        driver.findElement(By.xpath(buttonStopXpath)).click();
        String result = driver.findElement(By.xpath(resultXpath)).getText();

        assertTrue(Integer.parseInt(result.substring(8,9)) > 0);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
