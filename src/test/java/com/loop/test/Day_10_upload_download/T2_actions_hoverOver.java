package com.loop.test.Day_10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T2_actions_hoverOver {
    @Test
    public void actionsHoverOver() throws InterruptedException {
           /*
    1. Go to https://www.google.com
    2. Hover over on Search button
    3. Hover over on Feeling Lucky button
     */
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        WebElement googleSearch = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input"));
        WebElement feelingLucky = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']"));
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(3000);
        actions.moveToElement(googleSearch).perform();
        Thread.sleep(3000);
        actions.moveToElement(feelingLucky).perform();
        actions.sendKeys(Keys.UP, Keys.LEFT).perform();


        Driver.closeDriver();
    }
}
