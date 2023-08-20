package com.inetbanking.pageObjects;


import com.inetbanking.pageBase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    //Constructor
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    //Locators
    @FindBy(name = "uid")
    WebElement txt_userID_loc;

    @FindBy(xpath = "//input[@name='password']")
    WebElement txt_password_loc;

    @FindBy(xpath = "//input[@name='btnLogin']")
    WebElement btn_login_loc;

    @FindBy(xpath="//marquee[@class='heading3']")
    WebElement txt_welcomePageHeading_loc;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement btn_logout_loc;


    //ACTIONS

    public void setUserID(String userID)
    {
        txt_userID_loc.sendKeys(userID);
    }

    public void setPassword(String password)
    {
        txt_password_loc.sendKeys(password);
    }

    public void clickLogin()
    {
        btn_login_loc.click();
    }

    public void clickLogout(){
        btn_logout_loc.click();
    }

    public void validateLogin()
    {
        String actualText=txt_welcomePageHeading_loc.getText();
        String expectedText="Welcome To Manager's Page of Guru99 Ban";
        if (actualText.equals(expectedText))
        {
            Assert.assertTrue(true);
            logger.info("Test Passed");
        }
        else{
            captureScreen("loginTest");
            Assert.assertFalse(false);
            logger.info("Test Failed");
        }

    }

}
