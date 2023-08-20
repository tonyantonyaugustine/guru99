package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.testBase.BaseTest;
import com.inetbanking.utilities.XcelUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;



public class TC_002_LoginDDT extends BaseTest {
    String path = "C:\\Users\\tonya\\IdeaProjects\\Guru99\\TestData\\LoginData.xlsx";

    @Test(dataProvider = "LoginDatta")
    public void loginDDT(String username, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.setUserID(username);
        lp.setPassword(password);
        lp.clickLogin();
        lp.validateLogin();
        if (isAlertPresent()) {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.fail();
        } else {
            Assert.assertTrue(true);
            lp.clickLogout();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();

        }

    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }

    }


    @DataProvider(name = "LoginDatta")
    public String[][] getData() throws IOException {


        int row_count = XcelUtils.getRowCount(path, "sheet1");
        int cell_count = XcelUtils.getCellCount(path, "sheet1", 1);
        String[][] logindata = new String[row_count][cell_count];

        for (int r = 1; r <= row_count; r++) {
            for (int c = 0; c < cell_count; c++) {
                logindata[r - 1][c] = XcelUtils.getCellData(path, "sheet1", r, c);

            }

        }
        return logindata;
    }



}
