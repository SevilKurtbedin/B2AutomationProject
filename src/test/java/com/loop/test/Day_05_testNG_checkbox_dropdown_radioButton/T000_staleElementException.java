package com.loop.test.Day_05_testNG_checkbox_dropdown_radioButton;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T000_staleElementException {
    public static void main(String[] args) throws InterruptedException {
//        1. Open Chrome browser
//        2. Go to http://the-internet.herokuapp.com/add_remove_elements/
//        3. Click to “Add Element” button
//        4. Verify “Delete” button is displayed after clicking.
//        5. Click to “Delete” button.
//        6. Verify “Delete” button is NOT displayed after clicking.
//        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addElement = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElement.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));

        if (deleteButton.isDisplayed())
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");

        deleteButton.click();

        try {
            deleteButton.isDisplayed();
            System.out.println("Check your code");
        } catch (StaleElementReferenceException s) {
            System.out.println("Exception handled");
            System.out.println("Element is not displayed anymore");
        }

        driver.quit();
    }
}
