package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.utils.DriverManager;

public class TravelInsurancePage extends ru.appline.framework.pages.BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Чувствуйте')]//..//..//preceding-sibling::div//h1")
    WebElement headerTravelInsurance;

    @FindBy(xpath = "//b[text()='Оформить онлайн']")
    WebElement buttonRequest;

    public void clickButtonRequest() {
        if (isElementPresent(headerTravelInsurance) && isElementPresent(buttonRequest)) {

            click(buttonRequest);
        }
        else
            Assert.fail("Couldn't click request button");
    }
}
