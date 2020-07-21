package ru.appline.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class DriverManager {

    private static WebDriver driver;
    private static Properties properties = TestProperties.getInstance().getProperties();

    private DriverManager(){
    }

    private static void initDriver() {
        if (driver == null) {
            switch (properties.getProperty("browser")) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                    driver = new ChromeDriver();
            }
        }
    }


    public static WebDriver getDriver() {
        if(driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
