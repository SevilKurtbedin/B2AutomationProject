package com.loop.test.Day_06_alerts_iframes;

import com.loop.test.base.Test_base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_alerts extends Test_base {
    @Test (priority = 1)
    public void informationAlert1() {
        /*
    Information alert practice
    1. Open browser
    2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed
     */
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        clickForJSAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        actual = successMessageForInformationAlert.getText();
        expected = "You successfully clicked an alert";
        Assert.assertEquals(actual, expected, "True");
    }
    @Test (priority = 2)
    public void informationAlertConfirmation() {
        /*
        Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.
         */
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJsConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        clickForJsConfirm.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // You clicked: Ok
        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        actual = successMessageForInformationAlert.getText();
        expected = "You clicked: Ok";
        Assert.assertEquals(actual, expected, "True");

        clickForJsConfirm.click();
        alert.dismiss();
        actual = successMessageForInformationAlert.getText();
        expected = "You clicked: Cancel";
        Assert.assertEquals(actual, expected);
    }
    @Test (priority = 3)
    public void informationAlertPrompt() {
        /*
        Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed
         */
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJsPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        clickForJsPrompt.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Loop Academy");
        alert.accept();
        // You entered: Loop Academy
        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        actual = successMessageForInformationAlert.getText();
        expected = "You entered: Loop Academy";
        Assert.assertEquals(actual, expected, "True");
    }
}
