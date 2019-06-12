package com.jsystems.qa.frontend.test;

import com.jsystems.qa.frontend.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ConfigFrontend {

    WebDriver driver;

    @BeforeAll
    public static void setUpAll(){

        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemClassLoader().getResource("driver/chromedriver.exe").getFile());
    }
    @BeforeEach
    public void setUpEach(){

        String browser = Configuration.getBROWSER();

        if(browser.equals("chrome")){

            driver= new ChromeDriver();
        }else if(browser.equals("firefox")){
            driver= new FirefoxDriver();
        }

//        WebDriver driver = new ChromeDriver();
        setDriver();

        driver.get(Configuration.BASE_URL);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();

    }

    private void setDriver() {

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }


}
