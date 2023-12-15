package com.loop.test.Day_07_windows;

import com.loop.test.base.Test_base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class T1_window extends Test_base {
    @Test
    public void testWindowHandle() {/*
    1. Open a chrome browser
    2. Go to : http://the-internet.herokuapp.com/windows
    3. Assert: Title is “The Internet”
    4. Click to: “Click Here” link
    5. Switch to new Window.
    6. Assert: Title is “New Window”
     */

        driver.get("http://the-internet.herokuapp.com/windows");
        Assert.assertEquals(driver.getTitle(), "The Internet", "Results aren't matching!");
        WebElement clickHere = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        clickHere.click();
        Set <String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            System.out.println("Each window handles: " + each);
            driver.switchTo().window(each);
        }
        System.out.println("New Window: " + driver.getCurrentUrl()); // https://the-internet.herokuapp.com/windows/new
        Assert.assertEquals(driver.getTitle(), "New Window", "Results aren't matching!");

    }
}
