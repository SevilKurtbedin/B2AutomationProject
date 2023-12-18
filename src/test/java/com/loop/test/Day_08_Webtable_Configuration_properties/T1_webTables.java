package com.loop.test.Day_08_Webtable_Configuration_properties;

import com.loop.test.base.Test_base;
import com.loop.test.utilities.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_webTables extends Test_base {
    @Test
    public void getToDocPort() throws InterruptedException {
    //  1. login as an advisor
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);

    //  2. go to users
        WebElement users = driver.findElement(By.xpath("//a[@href='/users']"));
        users.click();

    //  3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
        actual = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "full name");
        expected = "Alex De Souza";
        Assert.assertEquals(actual, expected);
        System.out.println(actual + ": is equals to -> " + expected);

    //  4. validate that user name for alex.de.souza@gmail.com is alexdesouze
        actual = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "user name");
        expected = "alexdesouze";
        Assert.assertEquals(actual, expected);
        System.out.println(actual + ": is equals to -> " + expected);

    //  5. validate that phone number for alex.de.souza@gmail.com is +994512060042
        actual = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "phone number");
        expected = "+994512060042";
        Assert.assertEquals(actual, expected);
        System.out.println(actual + ": is equals to -> " + expected);

    //  6. validate that role for alex.de.souza@gmail.com is client
        actual = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "role");
        expected = "Client";
        Assert.assertEquals(actual, expected);
        System.out.println(actual + ": is equals to -> " + expected);

    //  7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
        actual = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "butch group");
        expected = "Batch1 Group1";
        Assert.assertEquals(actual, expected);
        System.out.println(actual + ": is equals to -> " + expected);
    }
}
