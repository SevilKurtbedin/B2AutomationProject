package com.loop.test.Day_11_waits_pom;

import com.loop.pages.LoopPracticeDynamicLoading_1;
import com.loop.test.utilities.BrowserUtils;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/*
1. go to https://loopcamp.vercel.app/dynamic_loading/1.html
2. click start
3. wait loading bar disappears
4. validate username is displayed
5. enter username tomsmith
6. enter password incorrectpassword
7. click submit button
8. validate "Your password is invalid!" is displayed
 */
public class T3_dynamic_loading {
    LoopPracticeDynamicLoading_1 loopPracticeDynamicLoading1;
    @BeforeMethod
    public void setUpMethod() {
        loopPracticeDynamicLoading1 = new LoopPracticeDynamicLoading_1();
        Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));
    }
    @Test
    public void dynamic_test() {
        BrowserUtils.loopLinkClick("Dynamic Loading");
        BrowserUtils.waitForClickable(loopPracticeDynamicLoading1.dynamicLoading_1, 5).click();
        BrowserUtils.waitForClickable(loopPracticeDynamicLoading1.startButton, 5).click();
        BrowserUtils.waitForInVisibility(loopPracticeDynamicLoading1.loadingBar, 10);
        assertTrue(loopPracticeDynamicLoading1.username.isDisplayed());
        loopPracticeDynamicLoading1.username.sendKeys(ConfigurationReader.getProperty("dynamicLoading.username"));
        loopPracticeDynamicLoading1.password.sendKeys(ConfigurationReader.getProperty("dynamicLoading.incorrectPassword"));
        loopPracticeDynamicLoading1.submitButton.click();
        loopPracticeDynamicLoading1.errorMessage.isDisplayed();
    }
}
