package com.loop.test.Day_01_Selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Test {
    public static void main(String[] args) throws InterruptedException {

        // setting up the web driver
        WebDriverManager.chromedriver().setup();

        // create an instance of web-driver
        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000); // waiting for 1 sec... and after open our page

        // navigate to web page
        // driver.get("https://www.google.com");
        driver.navigate().to("https://www.google.com");

        // maximize
        driver.manage().window().maximize(); // open maximize window
        // driver.manage().window().fullscreen(); -> open full screen

        driver.navigate().to("https://www.etsy.com");

        // navigate back -> he back to url what we wrote before
        driver.navigate().back();

        // navigate forward -> he go to url what we wrote after
        driver.navigate().forward();

        // navigate refresh -> hw will refresh our url page
        driver.navigate().refresh();

        // driver.quit and .close -> quit will off browser, close will clean driver after test
        driver.quit();

    }
}
