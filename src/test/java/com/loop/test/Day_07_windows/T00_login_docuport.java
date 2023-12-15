package com.loop.test.Day_07_windows;

import com.loop.test.base.Test_base;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import org.testng.annotations.Test;

public class T00_login_docuport extends Test_base {
    @Test
    public void test_login_docPort() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.CLIENT);
        DocuportUtils.logOut(driver);
    }
}
