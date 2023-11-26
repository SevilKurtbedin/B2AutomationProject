package com.loop.test.Day_03_locators_css_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {
    public static void main(String[] args) {
        // setup the driver
        WebDriverManager.chromedriver().setup();

        // create driver object
        WebDriver driver = new ChromeDriver();

        // navigate to https://loopcamp.vercel.app/registration_form.html
        driver.get("https://loopcamp.vercel.app/registration_form.html");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Loop");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Academy");
    }
}
