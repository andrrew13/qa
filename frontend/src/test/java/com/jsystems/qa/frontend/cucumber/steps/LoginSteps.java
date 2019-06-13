package com.jsystems.qa.frontend.cucumber.steps;

import com.jsystems.qa.frontend.Configuration;
import com.jsystems.qa.frontend.clasicfrontend.page.LoginPage;
import com.jsystems.qa.frontend.clasicfrontend.page.MainWordpressPage;
import com.jsystems.qa.frontend.clasicfrontend.page.UserPage;
import com.jsystems.qa.frontend.cucumber.CucumberStepConfig;
import com.jsystems.qa.frontend.cucumber.page.NotificationPage;
import com.jsystems.qa.frontend.cucumber.page.UserProfilePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class LoginSteps {

    WebDriver driver;

    MainWordpressPage wordpressPage;
    LoginPage loginPage;
    UserPage userPage;
    UserProfilePage userProfilePage;
    NotificationPage notificationPage;

    public LoginSteps(CucumberStepConfig stepConfig) {
        driver = stepConfig.setUp();
    }

    @Given("^User start on main page$")
    public void userStartOnMainPage() {
        driver.get(Configuration.BASE_URL);
    }

    @When("^User log in to the user page$")
    public void userLogInToTheUserPage() {
        login();

        userPage = new UserPage(driver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, 30);
        assertTrue(userPage.userAvatar.isDisplayed());
    }

    @Then("^User can modified user profile$")
    public void userCanModifiedUserProfiles() {
        userPage.userAvatar.click();
        userProfilePage = new UserProfilePage(driver);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.buttonSave, 120);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", userProfilePage.buttonSave);

        userProfilePage.waitForVisibilityOfElement(userProfilePage.buttonSave, 120);
        assertFalse(userProfilePage.buttonSave.isEnabled());


    }

    @Given("^User start on page \"([^\"]*)\"$")
    public void userStartOnPage(String arg0) throws Throwable {
        driver.get(arg0);
    }

    @Then("^User can modified user notifications$")
    public void userCanModifiedUserNotifications() {
        userPage.userAvatar.click();
        userProfilePage = new UserProfilePage(driver);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.notification, 120);
        userProfilePage.notification.click();
        notificationPage = new NotificationPage(driver);
        notificationPage.waitForVisibilityOfElement(notificationPage.firstCheckbox, 120);
        assertTrue(notificationPage.firstCheckbox.isSelected());
    }


    private void login() {
        wordpressPage = new MainWordpressPage(driver);
        wordpressPage.waitForVisibilityOfElement(wordpressPage.login, 30);
        wordpressPage.login.click();
        loginPage = new LoginPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 30);
        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(Configuration.LOGIN);
        loginPage.buttonContinue.click();
        loginPage.waitForVisibilityOfElement(loginPage.passwordInput, 30);
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(Configuration.PASSWORD);
        loginPage.buttonContinue.click();
    }

}