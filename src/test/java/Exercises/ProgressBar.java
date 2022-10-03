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
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new Driver(DriverName.CHROME).getWebDriver();
        driver.get("http://uitestingplayground.com/home");
    }

    @Test
    public void testCero() {
        driver.findElement(By.xpath("//a[@href='/progressbar']")).click();
        Integer valueProgressBar = Integer.valueOf(driver.findElement(By.xpath("//div[@id='progressBar']")).getAttribute("aria-valuenow"));
        driver.findElement(By.xpath("//button[@id='startButton']")).click();
        while (valueProgressBar < 75) {
            valueProgressBar = Integer.valueOf(driver.findElement(By.xpath("//div[@id='progressBar']")).getAttribute("aria-valuenow"));
        }
        driver.findElement(By.xpath("//button[@id='stopButton']")).click();
        String result = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();

        assertTrue(result.charAt(8) == '0');
    }

    @Test
    public void testNegative() {
        driver.findElement(By.xpath("//a[@href='/progressbar']")).click();
        Integer valueProgressBar = Integer.valueOf(driver.findElement(By.xpath("//div[@id='progressBar']")).getAttribute("aria-valuenow"));
        driver.findElement(By.xpath("//button[@id='startButton']")).click();
        while (valueProgressBar < 46) {
            valueProgressBar = Integer.valueOf(driver.findElement(By.xpath("//div[@id='progressBar']")).getAttribute("aria-valuenow"));
        }
        driver.findElement(By.xpath("//button[@id='stopButton']")).click();
        String result = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();

        assertTrue(Integer.parseInt(result.substring(8,10)) < 0);
    }

    @Test
    public void testPositive() {
        driver.findElement(By.xpath("//a[@href='/progressbar']")).click();
        Integer valueProgressBar = Integer.valueOf(driver.findElement(By.xpath("//div[@id='progressBar']")).getAttribute("aria-valuenow"));
        driver.findElement(By.xpath("//button[@id='startButton']")).click();
        while (valueProgressBar < 88) {
            valueProgressBar = Integer.valueOf(driver.findElement(By.xpath("//div[@id='progressBar']")).getAttribute("aria-valuenow"));
        }
        driver.findElement(By.xpath("//button[@id='stopButton']")).click();
        String result = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();

        assertTrue(Integer.parseInt(result.substring(8,9)) > 0);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
