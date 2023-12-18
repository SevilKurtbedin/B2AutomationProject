package com.loop.test.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.Set;
/**
 * Validate if driver switched to expected url and title
 * @param driver
 * @param expectedUrl
 * @param expectedTitle
 * @author Sevil
 * implements assertion
 */
public class BrowserUtils {
    public static void windowsHandles(WebDriver driver, String expectedUrl, String expectedTitle) {
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set <String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * Validate if title name contains targetTitle name.
     * @param driver
     * @param targetTitle
     * @author Loop Camp
     * return: true or false
     */
    public static void switchToWindow (WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }
}

