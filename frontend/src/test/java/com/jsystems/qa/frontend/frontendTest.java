package com.jsystems.qa.frontend;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class frontendTest {



    @BeforeAll
    public static void setUpAll(){

        System.setProperty("webdriver.gecko.driver", "D:/firefox/geckodriver.exe");
    }


    @Test
    public void firstFrontTest(){
//        WebDriverManager.chromedriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);



        driver.get("https://wordpress.com/");
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement login = driver.findElement(By.cssSelector("x-nav-item x-nav-item--wide x-nav-item--logged-in" + "a.x-na-link.x-link"));
       // WebElement buildEWebsite

        driver.findElement()
        driver.quit();
    }


}
