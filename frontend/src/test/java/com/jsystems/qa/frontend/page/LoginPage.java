package com.jsystems.qa.frontend.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{

    public WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "usernameOrEmail")
    public WebElement emailInput;

//    public WebElement emailInput = driver.findElement(By.id("usernameOrEmail"));
    @FindBy(id = "button form-button is-primary")
    public WebElement buttonContinue;

//    public WebElement buttonContinue = driver.findElement(By.cssSelector("button form-button is-primary"));

//  brak password    @FindBy(id = "")

}
