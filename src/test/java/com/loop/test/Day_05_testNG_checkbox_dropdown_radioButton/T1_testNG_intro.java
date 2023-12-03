package com.loop.test.Day_05_testNG_checkbox_dropdown_radioButton;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class T1_testNG_intro {
    @BeforeClass
    public void setUp(){
        System.out.println("Before class is running");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class is running");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running");
    }

    @Test (priority = 1)
    public void test1(){
        System.out.println("test1 is running");
        String actual = "Feyruz";
        String expected = "Feyruz";

        Assert.assertEquals(actual, expected, "Message from Assertion, it will show if test fails");
    }

    @Test (priority = 2)
    public void test2(){
        System.out.println("test 2 is running");
    }
}
