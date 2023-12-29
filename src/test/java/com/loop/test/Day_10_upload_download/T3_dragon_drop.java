package com.loop.test.Day_10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_dragon_drop {
    @Test
    public void dragon_drop() throws InterruptedException {
        /*
    1- Open Chrome browser
    2- Go to: https://demo.guru99.com/test/drag_drop.html
    3- Drag “BANK” and drop into Account area under Debit Side
    4- Drag “5000” and drop into Amount area under Debit Side
    5- Drag “SALES” and drop into Account area under Credit Side
    6- Drag “5000” and drop into Amount area under Credit Side
    7- Validate “Perfect!” text displayed.
        */
        Driver.getDriver().get(ConfigurationReader.getProperty("demo.dragon"));
        WebElement dragBank = Driver.getDriver().findElement(By.xpath("//div[@id='products']//following-sibling::li/a[text()=' BANK ']"));
        WebElement debitAccount = Driver.getDriver().findElement(By.id("bank"));
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(dragBank, debitAccount).perform();

        WebElement drag5000 = Driver.getDriver().findElement(By.xpath("//a[.=' 5000']"));
        WebElement debitAmount = Driver.getDriver().findElement(By.id("amt7"));
        actions.dragAndDrop(drag5000, debitAmount).perform();

        WebElement dragSales = Driver.getDriver().findElement(By.xpath("//a[.=' SALES ']"));
        WebElement creditAccount = Driver.getDriver().findElement(By.xpath("//*[@id='loan']/li"));
        actions.dragAndDrop(dragSales, creditAccount).perform();

        WebElement creditAmount = Driver.getDriver().findElement(By.id("amt8"));
        actions.dragAndDrop(drag5000, creditAmount).perform();

        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//a[contains(.,'Perfect!')]"));
        String actual = successMessage.getText();
        String expected = "Perfect!";
        System.out.println(actual);

        Assert.assertEquals(actual, expected);

        Thread.sleep(5000);
        Driver.closeDriver();

    }
}
