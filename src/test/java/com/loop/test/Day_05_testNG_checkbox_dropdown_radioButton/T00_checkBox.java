package com.loop.test.Day_05_testNG_checkbox_dropdown_radioButton;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T00_checkBox {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
            /*
        1. Go to http://the-internet.herokuapp.com/checkboxes
        2. Confirm checkbox #1 is NOT selected by default
        3. Confirm checkbox #2 is SELECTED by default.
        4. Click checkbox #1 to select it.
        5. Click checkbox #2 to deselect it.
        6. Confirm checkbox #1 is SELECTED.
        7. Confirm checkbox #2 is NOT selected.

         */
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement checkBox1 = driver.findElement(By.xpath("//input/following-sibling::text()[contains(.,'checkbox 1')]/preceding-sibling::input"));
        if (!checkBox1.isSelected())
            System.out.println("TEST PASSED: CHECKBOX#1 IS NOT SELECTED BY DEFAULT");
        else
            System.out.println("TEST FAILED: CHECKBOX#1 IS SELECTED BY DEFAULT");

        WebElement checkBox2 = driver.findElement(By.xpath("//input/following-sibling::text()[contains(., 'checkbox 2')]/preceding-sibling::input/following-sibling::input"));
        if (checkBox2.isSelected())
            System.out.println("TEST PASSED: CHECKBOX#2 IS SELECTED BY DEFAULT");
        else
            System.out.println("TEST FAILED: CHECKBOX#2 IS NOT SELECTED BY DEFAULT");

        checkBox1.click();
        checkBox2.click();

        if (checkBox1.isSelected())
            System.out.println("TEST PASSED: CHECKBOX#1 IS SELECTED");
        else
            System.out.println("TEST FAILED: CHECKBOX#1 IS NOT SELECTED");

        if (!checkBox2.isSelected())
            System.out.println("TEST PASSED: CHECKBOX#2 IS NOT SELECTED");
        else
            System.out.println("TEST FAILED: CHECKBOX#2 IS SELECTED");

        driver.quit();
    }
}
