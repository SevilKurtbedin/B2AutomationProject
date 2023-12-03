package com.loop.test.Day_05_testNG_checkbox_dropdown_radioButton;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class T5_multi_dropdown {
    WebDriver driver;
    String actual;
    String expected;
    @BeforeClass
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/select-menu");
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
    @Test
    public void getWebsite() throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
        Assert.assertTrue(dropdown.isMultiple());
        // select by index
        List <WebElement> options = new ArrayList<>();
        options = dropdown.getOptions();
        options.forEach(option -> {
            option.click();
            System.out.println(option.getText());
        });

        System.out.println();

        for (WebElement option : options) {
            option.click();
            System.out.println(option.getText());
        }

        dropdown.deselectAll();
    }
}
