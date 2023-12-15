package com.loop.test.Day_07_windows;

import com.loop.test.base.Test_base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T0_iframe_practice extends Test_base {
    @Test (priority = 1)
    public void left() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement leftIframe = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]"));
        actual = leftIframe.getText();
        expected = "LEFT";
        System.out.println(actual); // LEFT
        Assert.assertEquals(actual, expected);
    }
    @Test (priority = 2)
    public void middle() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement middleIframe = driver.findElement(By.xpath("//*[contains(text(),'MIDDLE')]"));
        actual = middleIframe.getText();
        expected = "MIDDLE";
        System.out.println(expected); // MIDDLE
        Assert.assertEquals(actual, expected);
    }
    @Test (priority = 3)
    public void right() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");

        WebElement rightIframe = driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]"));
        actual = rightIframe.getText();
        expected = "RIGHT";
        System.out.println(expected); // RIGHT
        Assert.assertEquals(actual, expected);
    }
    @Test (priority = 4)
    public void bottom() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame(1);

        WebElement rightIframe = driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]"));
        actual = rightIframe.getText();
        expected = "BOTTOM";
        System.out.println(expected); // RIGHT
        Assert.assertEquals(actual, expected);

        driver.quit();
    }
}
