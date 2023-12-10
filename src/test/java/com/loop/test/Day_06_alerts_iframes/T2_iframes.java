package com.loop.test.Day_06_alerts_iframes;

import com.loop.test.base.Test_base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T2_iframes extends Test_base {
            /*
    1- Open a chrome browser
    2- Go to: https://loopcamp.vercel.app/iframe.html
    3- Clear text from comment body
    4- Type "Loop Academy" in comment body
    5- Verify "Loop Academy" text is written in comment body
    6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed

     */
    @Test
    public void iframeTest() {
        driver.get("https://loopcamp.vercel.app/iframe.html");
        // WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        // driver.switchTo().frame(iframe);
        // #1 - use findElement
        // driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"))); // first one

        // #2 - use Id
        // driver.switchTo().frame("mce_0_ifr"); -> by.id

        // #3 - use Index
        driver.switchTo().frame(0); // by Index

        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']")); // with xpath
        textBox.clear();

        driver.switchTo().defaultContent(); // if we have one frame
        // driver.switchTo().parentFrame(); -> if we have more than one frame

        WebElement poweredBy = driver.findElement(By.xpath("//a[@href='https://www.loopcamp.io/']"));

        System.out.println(poweredBy.getText());
    }
}
