package ru.appline.framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.utils.DriverManager;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public boolean isElementPresent(WebElement element) {
        try {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }


    public void hover(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(element).build().perform();
    }

    public void hoverAndClick(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(element).click(element).build().perform();
    }

    public void fillField(WebElement element, String value)  {
        element.clear();
        element.click();
        element.sendKeys(value);
    }

    public void fillFieldAction(WebElement element, String value) {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(element).click(element).sendKeys(value).build().perform();
    }

    public boolean checkPresence(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    public void click(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", element);
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions action = new Actions(DriverManager.getDriver());
        action.click(element).build().perform();
    }
}
