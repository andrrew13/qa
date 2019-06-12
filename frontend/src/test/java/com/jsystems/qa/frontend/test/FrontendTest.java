package com.jsystems.qa.frontend.test;

import com.jsystems.qa.frontend.Configuration;
import com.jsystems.qa.frontend.page.LoginPage;
import com.jsystems.qa.frontend.page.MainWordpressPage;
import com.jsystems.qa.frontend.page.UserPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrontendTest extends ConfigFrontend{


//
//    @BeforeAll
//    public static void setUpAll(){
//
//        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemClassLoader().getResource("driver/chromedriver.exe").getFile());
//    }

    MainWordpressPage wordpressPage;
    LoginPage loginPage;
    UserPage userPage;




    @Test
    public void firstFrontTest(){
//        WebDriverManager.chromedriver().setup();


        driver.get("https://wordpress.com/");


        wordpressPage = new MainWordpressPage(driver);
        assertTrue(wordpressPage.buildEWebsite.isDisplayed());
        assertEquals(wordpressPage.buildEWebsite.getText(), "Build a website,");

        assertTrue(wordpressPage.login.isDisplayed());
        assertEquals(wordpressPage.login.getText(), "Log In");
        wordpressPage.login.click();




        driver.quit();
    }

    @Test

    public void loginTest(){

    wordpressPage = new MainWordpressPage(driver);
    wordpressPage.waitForVisibilityOfElement(wordpressPage.login, 30);
    wordpressPage.login.click();

    loginPage = new LoginPage(driver);
    loginPage.waitForVisibilityOfElement(loginPage.emailInput,30);
    loginPage.emailInput.clear();
    loginPage.emailInput.sendKeys(Configuration.LOGIN);
    loginPage.buttonContinue.click();

    loginPage.waitForVisibilityOfElement(loginPage.passwordInput, 30);
    loginPage.passwordInput.clear();
    loginPage.passwordInput.sendKeys(Configuration.PASSWORD);
    loginPage.buttonContinue.click();

    userPage = new UserPage(driver);
    userPage.waitForVisibilityOfElement(userPage.userAvatar, 30);
    assertTrue(userPage.userAvatar.isDisplayed());

    }

}
