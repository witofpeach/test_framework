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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/testParams.csv", delimiter = ';', numLinesToSkip = 1)
    public void test(String objectLastName, String objectFirstName, String objectBirthDate, String subjectLastName,
                     String subjectFirstName, String subjectMiddleName, String subjectBirthDate, String clientSex,
                     String passportSeries, String passportNumber, String documentDate, String documentIssue) {

        // Шаги 1 - 8

        ClientInfoInsuranceFormPage finalPage = pagesManager.getClientPage()
                .clickInsuranceMenu()
                .clickTravelInsurance()
                .clickButtonRequest()
                .selectMinimalInsuranceSum()
                .clickButtonSubmit()
                .setInputObjectOfInsuranceLastName(objectLastName)
                .setInputObjectOfInsuranceFirstName(objectFirstName)
                .setInputObjectOfInsuranceBirthDate(objectBirthDate)
                .setInputSubjectOfInsuranceLastName(subjectLastName)
                .setInputSubjectOfInsuranceFirstName(subjectFirstName)
                .setInputSubjectOfInsuranceMiddleName(subjectMiddleName)
                .setInputSubjectOfInsuranceBirthDate(subjectBirthDate)
                .setClientSex(clientSex)
                .setInputPassportSeries(passportSeries)
                .setInputPassportNumber(passportNumber)
                .setInputDocumentDate(documentDate)
                .setInputDocumentIssue(documentIssue);

        // Шаг 9 - Проверка правильного заполнения полей

        assertThat("Object's last name", finalPage.getInputObjectOfInsuranceLastName(), equalTo(objectLastName));
        assertThat("Object's first name", finalPage.getInputObjectOfInsuranceFirstName(), equalTo(objectFirstName));
        assertThat("Object's birth date", finalPage.getInputObjectOfInsuranceBirthDate(), equalTo(objectBirthDate));
        assertThat("Subject's last name", finalPage.getInputSubjectOfInsuranceLastName(), equalTo(subjectLastName));
        assertThat("Subject's first name", finalPage.getInputSubjectOfInsuranceFirstName(), equalTo(subjectFirstName));
        assertThat("Subject's middle name", finalPage.getInputSubjectOfInsuranceMiddleName(), equalTo(subjectMiddleName));
        assertThat("Subject's birth date", finalPage.getInputSubjectOfInsuranceBirthDate(), equalTo(subjectBirthDate));
        assertThat("Subject's sex", finalPage.getClientSex(), equalTo(clientSex));
        assertThat("Subject's passport series", finalPage.getInputPassportSeries(), equalTo(passportSeries));
        assertThat("Subject's passport number", finalPage.getInputPassportNumber(), equalTo(passportNumber));
        assertThat("Subject's document date", finalPage.getInputDocumentDate(), equalTo(documentDate));
        assertThat("Subject's document issue", finalPage.getInputDocumentIssue(), equalTo(documentIssue));

        // Шаг 10 Нажать кнопку "Продолжить"

        finalPage.clickButtonContinue();

        // Шаг 11 - Проверка наличия сообщения - "Заполнены не все обязательные поля"

        Assert.assertTrue("no error message", finalPage.errorMessagePresenceCheck());

    }
}
