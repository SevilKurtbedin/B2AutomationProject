package com.loop.test.Day_10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import io.github.bonigarcia.wdm.online.Downloader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_upload {
    /*
1. Go to “http://demo.guru99.com/test/upload”
2. Upload file into Choose File
3. Click terms of service check box
4. Click Submit File button
5. Validate expected message appeared. Expected: “1 file has been successfully uploaded.
 */
    @Test
    public void upload_file() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("demo.guru"));
        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@type='file']"));
        String pathFile = "C:\\Users\\isevi\\Downloads\\LoopCamp.docx";
        chooseFile.sendKeys(pathFile);

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();

        WebElement submitMessage = Driver.getDriver().findElement(By.id("res"));
        Thread.sleep(5000);

        String expected = "1 file\nhas been successfully uploaded.";
        Assert.assertEquals(submitMessage.getText(), expected);

        Driver.closeDriver();
    }
}
