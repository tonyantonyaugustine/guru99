package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.testBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_001_Login_Test extends BaseTest {
    @Test
    void loginTest() {
        try {
            logger.info("Driver Initiated ");
            LoginPage lp = new LoginPage(driver);
            logger.info("Setting UserID....................");
            lp.setUserID(rb.getString("username"));
            logger.info("Setting Password....................");
            lp.setPassword(rb.getString("password"));
            logger.info("Clicking login............");
            lp.clickLogin();
            logger.info("Validating login.............");
            lp.validateLogin();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }
}
