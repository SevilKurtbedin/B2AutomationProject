package com.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementBy {

    public static void findByRegularXPath (WebDriver driver, String tagName, String attribute, String value) {
        WebElement findByXPath = driver.findElement(By.xpath("//" + tagName + "[@" + attribute + "='" + value + "']"));
    }
    public static void findByNameXPath (WebDriver driver, String tagName, String value) {
        WebElement findByXPath = driver.findElement(By.xpath("//" + tagName + "[text()='" + value + "']"));
    }
}
