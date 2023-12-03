package com.loop.test.Day_05_testNG_checkbox_dropdown_radioButton;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T4_dropDown_options {
    WebDriver driver;
    String actual;
    String expected;
    /*
    1. Open Chrome browser
    2. Go to https://demoqa.com/select-menu
    3. go old style select menu
    4. Select Yellow and validate
    5. Select Red and validate
    6. Select White and validate
    Use all Select options. (visible text, value, index)
     */
    @BeforeClass
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
    @Test
    public void getWebsite () {
        driver.get("https://demoqa.com/select-menu");
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
        dropdown.selectByIndex(3);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Yellow", "TEST PASSED");

        dropdown.selectByValue("red"); // or byIndex(0);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Red", "TEST PASSED");

        dropdown.selectByVisibleText("White");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "White", "TEST PASSED");

    }
}
