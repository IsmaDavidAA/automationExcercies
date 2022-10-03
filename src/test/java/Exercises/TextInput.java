package Exercises;

import controlerDriver.Driver;
import controlerDriver.DriverName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextInput {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new Driver(DriverName.CHROME).getWebDriver();
        driver.get("http://uitestingplayground.com/textinput");
    }

    @Test
    public void test() {
        WebElement input = null;
        WebElement button = null;
        String textChange = "this is the new text";
        try {
            input = driver.findElement(By.xpath("//*[@id=\"newButtonName\"]"));
            button = driver.findElement(By.xpath("//*[@id=\"updatingButton\"]"));
            input.sendKeys(textChange);
            button.click();
            assertEquals(button.getText(), textChange);
        }catch (Exception e){
            assertFalse(true);
        }

    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
