package com.loop.test.Day_10_upload_download;

import com.github.javafaker.Faker;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_javascriptExecutor {
    /*
1. Go to https://www.etsy.com
2. Scroll down
3. Generate random email and enter into subscribe box
4. Click on Subscribe
5. Verify "Great! We've sent you an email to confirm your subscription." is displayed
 */
    @Test
    public void javascriptExecutorScroll() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy.url"));
        WebElement emailBox = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));

        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(emailBox).perform();
        emailBox.sendKeys(faker.internet().emailAddress() + Keys.ENTER);

        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@aria-live='polite'][5]"));
        Thread.sleep(3000);
        String actual = successMessage.getText();
        String expected = "Great! We've sent you an email to confirm your subscription.";
        System.out.println("Actual message is: " + actual);
        Assert.assertEquals(actual, expected, "actual message not equal to expected result");

        Driver.closeDriver();

        /* how to scroll to element

            #1 use actions move to element
        actions.moveToElement(emailBox).perform();
        emailBox.sendKeys(faker.internet().emailAddress());

            #2 just use Key press
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

            #3 move horizontally or vertically
        js.executeScript("window.scrollBy(0, 5000);"); // -> scroll DOWN

            #4 use arguments, starts from 0
        js.executeScript("arguments[0].scrollIntoView(true)", emailBox);
        js.executeScript("arguments[0].click", emailBox);
        Thread.sleep(5000);
        js.executeScript("window.scroll(0, 0)");
         */
    }
}
