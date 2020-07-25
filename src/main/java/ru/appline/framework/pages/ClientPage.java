package ru.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientPage extends ru.appline.framework.pages.BasePage {

    @FindBy(xpath = "//button[@aria-label='Меню Страхование']")
    WebElement buttonInsuranceMenu;

    @FindBy(xpath = "//a[text()='Страхование путешественников' and @class='lg-menu__sub-link']")
    WebElement linkTravelInsurance;

    public ClientPage clickInsuranceMenu() {
        if (isElementPresent(buttonInsuranceMenu))
            hover(buttonInsuranceMenu);
//        else
//            Assert.fail("Couldn't click insurance menu");
        return this;
    }

    public TravelInsurancePage clickTravelInsurance() {
        if (isElementPresent(linkTravelInsurance))
            click(linkTravelInsurance);
//        else
//            Assert.fail("Couldn't click travel insurance menu");
        return pagesManager.getTravelInsurancePage();
    }
}
