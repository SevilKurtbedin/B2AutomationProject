package com.loop.test.Day_03_locators_css_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {
        // setup the driver
        WebDriverManager.chromedriver().setup();

        // create your object
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/"); // navigate to Google
        driver.manage().window().maximize(); // Maximize windows

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + " => TEST PASS");
        } else {
            System.err.println("Actual title: " + actualTitle + ", DOES NOT match expected title: " + expectedTitle + "=> TEST FAILED");
        }

        String expectedURL = "https://www.google.com/";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.equalsIgnoreCase(expectedURL)) {
            System.out.println("Actual URL: " + actualURL + ", matches expected URL: " + expectedURL + " => TEST PASS");
        } else {
            System.err.println("Actual URL: " + actualURL + ", DOES NOT match expected URL: " + expectedURL + "=> TEST FAILED");
        }

        driver.quit();
    }
}
