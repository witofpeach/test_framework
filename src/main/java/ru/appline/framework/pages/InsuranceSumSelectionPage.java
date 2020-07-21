package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsuranceSumSelectionPage extends BasePage {

    @FindBy(xpath = "//h3[text()='Минимальная']//..//div[contains(@class, 'selected')]")
    WebElement cardMinimalInsuranceSum;

    @FindBy(xpath = "//button[text()='Оформить']")
    WebElement buttonSubmit;

    public void selectMinimalInsuranceSum() {
        if (!checkPresence(cardMinimalInsuranceSum))
            Assert.fail("Couldn't find minimal sum card");
    }

    public void clickButtonSubmit() {
        if (checkPresence(buttonSubmit))
            hoverAndClick(buttonSubmit);
        else
            Assert.fail("Couldn't click submit button");
    }
}
