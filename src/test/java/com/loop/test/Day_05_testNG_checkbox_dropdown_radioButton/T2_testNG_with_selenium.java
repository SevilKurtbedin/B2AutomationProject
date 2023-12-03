package com.loop.test.Day_05_testNG_checkbox_dropdown_radioButton;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class T2_testNG_with_selenium {
    WebDriver driver;
    String expected;
    String actual;

    // set up chrome and create driver
    // go to google.com
    // Assert; title is "Google"


    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test (priority = 1) // number of priority mean when started test first or second or ...
    public void googleTitle(){
        driver.get("https://www.google.com/");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Google";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Actual: " + actual + " does not match expected: " + expected );

    }

    @Test (priority = 2)
    public void docuportTitle(){
        driver.get("https://beta.docuport.app/");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Docuport";
        actual = driver.getTitle();
        Assert.assertTrue(actual.contains(expected), "Actual does not match expected");
    }
}
