package ru.appline.tests;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.pages.ClientInfoInsuranceFormPage;
import ru.appline.framework.pages.ClientPage;
import ru.appline.framework.pages.InsuranceSumSelectionPage;
import ru.appline.framework.pages.TravelInsurancePage;
import ru.appline.framework.utils.DriverManager;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/testParams.csv", delimiter = ';', numLinesToSkip = 1)
    public void test(String objectLastName, String objectFirstName, String objectBirthDate, String subjectLastName,
                     String subjectFirstName, String subjectMiddleName, String subjectBirthDate, String clientSex,
                     String passportSeries, String passportNumber, String documentDate, String documentIssue) throws InterruptedException {

        // Создание обьектов страниц

        ClientPage clientPage = new ClientPage();
        TravelInsurancePage travelInsurancePage = new TravelInsurancePage();
        InsuranceSumSelectionPage insuranceSumSelectionPage = new InsuranceSumSelectionPage();
        ClientInfoInsuranceFormPage clientInfoInsuranceFormPage = new ClientInfoInsuranceFormPage();

        // Шаги 2-3

        clientPage.clickInsuranceMenu();
        clientPage.clickTravelInsurance();

        // Шаги 4-5

        travelInsurancePage.clickButtonRequest();

        // Шаги 6-7

        insuranceSumSelectionPage.selectMinimalInsuranceSum();
        insuranceSumSelectionPage.clickButtonSubmit();

        // Шаг 8 - Заполнение полей

        clientInfoInsuranceFormPage.setInputObjectOfInsuranceLastName(objectLastName);
        clientInfoInsuranceFormPage.setInputObjectOfInsuranceFirstName(objectFirstName);
        clientInfoInsuranceFormPage.setInputObjectOfInsuranceBirthDate(objectBirthDate);
        clientInfoInsuranceFormPage.setInputSubjectOfInsuranceLastName(subjectLastName);
        clientInfoInsuranceFormPage.setInputSubjectOfInsuranceFirstName(subjectFirstName);
        clientInfoInsuranceFormPage.setInputSubjectOfInsuranceMiddleName(subjectMiddleName);
        clientInfoInsuranceFormPage.setInputSubjectOfInsuranceBirthDate(subjectBirthDate);
        clientInfoInsuranceFormPage.setClientSex(clientSex);
        clientInfoInsuranceFormPage.setInputPassportSeries(passportSeries);
        clientInfoInsuranceFormPage.setInputPassportNumber(passportNumber);
        clientInfoInsuranceFormPage.setInputDocumentDate(documentDate);
        clientInfoInsuranceFormPage.setInputDocumentIssue(documentIssue);

        // Шаг 9 - Проверка правильного заполнения полей

        assertThat("Object's last name", clientInfoInsuranceFormPage.getInputObjectOfInsuranceLastName(), equalTo(objectLastName));
        assertThat("Object's first name", clientInfoInsuranceFormPage.getInputObjectOfInsuranceFirstName(), equalTo(objectFirstName));
        assertThat("Object's birth date", clientInfoInsuranceFormPage.getInputObjectOfInsuranceBirthDate(), equalTo(objectBirthDate));
        assertThat("Subject's last name", clientInfoInsuranceFormPage.getInputSubjectOfInsuranceLastName(), equalTo(subjectLastName));
        assertThat("Subject's first name", clientInfoInsuranceFormPage.getInputSubjectOfInsuranceFirstName(), equalTo(subjectFirstName));
        assertThat("Subject's middle name", clientInfoInsuranceFormPage.getInputSubjectOfInsuranceMiddleName(), equalTo(subjectMiddleName));
        assertThat("Subject's birth date", clientInfoInsuranceFormPage.getInputSubjectOfInsuranceBirthDate(), equalTo(subjectBirthDate));
        assertThat("Subject's sex", clientInfoInsuranceFormPage.getClientSex(), equalTo(clientSex));
        assertThat("Subject's passport series", clientInfoInsuranceFormPage.getInputPassportSeries(), equalTo(passportSeries));
        assertThat("Subject's passport number", clientInfoInsuranceFormPage.getInputPassportNumber(), equalTo(passportNumber));
        assertThat("Subject's document date", clientInfoInsuranceFormPage.getInputDocumentDate(), equalTo(documentDate));
        assertThat("Subject's document issue", clientInfoInsuranceFormPage.getInputDocumentIssue(), equalTo(documentIssue));

        // Шаг 10 Нажать кнопку "Продолжить"

        clientInfoInsuranceFormPage.clickButtonContinue();

        // Шаг 11 - Проверка наличия сообщения - "Заполнены не все обязательные поля"

        Assert.assertTrue("no error message", clientInfoInsuranceFormPage.errorMessagePresenceCheck());

    }
}
