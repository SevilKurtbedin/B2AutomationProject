package com.loop.test.Day_05_testNG_checkbox_dropdown_radioButton;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T3_simple_dropDown {
    WebDriver driver;
    String expected = "Please select an option";
    String actual;
    @BeforeClass
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
    @Test (priority = 1)
    public void getWebSite () {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        // create dropdown
        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        actual = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected, "Actual massage are equal expected result");
    }
}
