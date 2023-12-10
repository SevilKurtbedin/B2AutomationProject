package com.loop.test.Day_06_alerts_iframes;

import com.loop.test.base.Test_base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Test extends Test_base {
    @org.testng.annotations.Test
    public void getWebSite() {
        driver.get("https://loopcamp.vercel.app/");
        WebElement getToDropdown = driver.findElement(By.xpath("//a[text()='Radio Buttons']"));
        getToDropdown.click();

        WebElement checkColorBlue = driver.findElement(By.xpath("//label[text()='Blue']"));
        Assert.assertTrue(checkColorBlue.isEnabled(), "Check");
        System.out.println(checkColorBlue.isEnabled());

        WebElement checkColorRed = driver.findElement(By.xpath("//label[text()='Red']"));
        System.out.println(checkColorRed.isSelected());
    }
}
