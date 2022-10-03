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

public class Click {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new Driver(DriverName.CHROME).getWebDriver();
        driver.get("http://uitestingplayground.com/home");
    }

    @Test
    public void test() {
        String initialButtonText = "Botón que ignora el evento de clic de DOM";
        driver.findElement(By.xpath("//a[@href='/click']")).click();
        driver.findElement(By.xpath("//button[@id='badButton']")).click();
        String secondButtonText = driver.findElement(By.xpath("//button[@id='badButton']")).getText();
        assertFalse(initialButtonText.equals(secondButtonText),"SuccesFull");
    }

    @AfterClass
    public void tearDown() {
        //driver.close();
        //driver.quit();
    }
}
