package ru.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientInfoInsuranceFormPage extends ru.appline.framework.pages.BasePage {



    // Поля застрахованных

    @FindBy(xpath = "//input[@id='surname_vzr_ins_0']")
    WebElement inputObjectOfInsuranceLastName;

    @FindBy(xpath = "//input[@id='name_vzr_ins_0']")
    WebElement inputObjectOfInsuranceFirstName;

    @FindBy(xpath = "//input[@id='birthDate_vzr_ins_0']")
    WebElement inputObjectOfInsuranceBirthDate;


    // Поля страхователя

    @FindBy(xpath = "//input[@id='person_lastName']")
    WebElement inputSubjectOfInsuranceLastName;

    @FindBy(xpath = "//input[@id='person_firstName']")
    WebElement inputSubjectOfInsuranceFirstName;

    @FindBy(xpath = "//input[@id='person_middleName']")
    WebElement inputSubjectOfInsuranceMiddleName;

    @FindBy(xpath = "//input[@id='person_birthDate']")
    WebElement inputSubjectOfInsuranceBirthDate;

    @FindBy(xpath = "//label[text()='Мужской']")
    WebElement inputSubjectOfInsuranceSexMale;
    @FindBy(xpath = "//label[text()='Женский']")
    WebElement inputSubjectOfInsuranceSexFemale;

    // Паспортные данные

    @FindBy(xpath = "//input[@id='passportSeries']")
    WebElement inputPassportSeries;

    @FindBy(xpath = "//input[@id='passportNumber']")
    WebElement inputPassportNumber;

    @FindBy(xpath = "//input[@id='documentDate']")
    WebElement inputDocumentDate;

    @FindBy(xpath = "//input[@id='documentIssue']")
    WebElement inputDocumentIssue;

    // Контакты(на всякий случай)

    @FindBy(xpath = "//input[@id='phone']")
    WebElement inputClientPhone;

    @FindBy(xpath = "//input[@id='email']")
    WebElement inputClientEmail;

    @FindBy(xpath = "//input[@id='repeatEmail']")
    WebElement inputClientRepeatEmail;

    // Выбранный пол(для проверки)

    @FindBy(xpath = "//label[contains(@class, 'active') and (text()='Мужской' or text()='Женский')]")
    WebElement selectedClientSex;

    // Кнопка "Продолжить"

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    WebElement buttonContinue;

    // Сообщение об ошибке

    @FindBy(xpath = "//div[@role='alert-form']")
    WebElement errorMessage;

    // -------

    // Методы для заполнения полей

    public ClientInfoInsuranceFormPage setInputObjectOfInsuranceLastName(String lastName) {
        fillField(inputObjectOfInsuranceLastName, lastName);
        return this;
    }

    public ClientInfoInsuranceFormPage setInputObjectOfInsuranceFirstName(String firstName) {
        fillField(inputObjectOfInsuranceFirstName, firstName);
        return this;
    }

    public ClientInfoInsuranceFormPage setInputObjectOfInsuranceBirthDate(String objectBirthDateInput) {
        String objectBirthDate = objectBirthDateInput.replaceAll("[.]+[/]+", "");
        fillField(inputObjectOfInsuranceBirthDate, objectBirthDate);
        return this;
    }

    public ClientInfoInsuranceFormPage setInputSubjectOfInsuranceLastName(String lastName) {
        fillField(inputSubjectOfInsuranceLastName, lastName);
        return this;
    }

    public ClientInfoInsuranceFormPage setInputSubjectOfInsuranceFirstName(String firstName) {
        fillField(inputSubjectOfInsuranceFirstName, firstName);
        return this;
    }

    public ClientInfoInsuranceFormPage setInputSubjectOfInsuranceMiddleName(String middleName) {
        fillField(inputSubjectOfInsuranceMiddleName, middleName);
        return this;
    }

    public ClientInfoInsuranceFormPage setInputSubjectOfInsuranceBirthDate(String subjectBirthDateInput) {
        String subjectBirthDate = subjectBirthDateInput.replaceAll("[.]+", "");
        fillField(inputSubjectOfInsuranceBirthDate, subjectBirthDate);
        click(inputPassportSeries);
        return this;
    }

    public ClientInfoInsuranceFormPage setClientSex(String sex) {
        if (sex.equals("Мужской")) {
            hoverAndClick(inputSubjectOfInsuranceSexMale);
        } else if (sex.equals("Женский")) {
            hoverAndClick(inputSubjectOfInsuranceSexFemale);
        }
        return this;
    }

    public ClientInfoInsuranceFormPage setInputPassportSeries(String passportSeries) {
        fillField(inputPassportSeries, passportSeries);
        return this;
    }

    public ClientInfoInsuranceFormPage setInputPassportNumber(String passportNumber) {
        fillField(inputPassportNumber, passportNumber);
        return this;
    }

    public ClientInfoInsuranceFormPage setInputDocumentDate(String documentDateInput) {
        String documentDate = documentDateInput.replaceAll("[.]+", "");
        fillFieldAction(inputDocumentDate, documentDate);
        return this;
    }

    public ClientInfoInsuranceFormPage setInputDocumentIssue(String documentIssue) {
        fillField(inputDocumentIssue, documentIssue);
        return this;
    }

    // -------

    // Методы для получения значения полей

    public String getInputObjectOfInsuranceLastName() {
        return inputObjectOfInsuranceLastName.getAttribute("value");
    }

    public String getInputObjectOfInsuranceFirstName() {
        return inputObjectOfInsuranceFirstName.getAttribute("value");
    }

    public String getInputObjectOfInsuranceBirthDate() {
        return inputObjectOfInsuranceBirthDate.getAttribute("value");
    }

    public String getInputSubjectOfInsuranceLastName() {
        return inputSubjectOfInsuranceLastName.getAttribute("value");
    }

    public String getInputSubjectOfInsuranceFirstName() {
        return inputSubjectOfInsuranceFirstName.getAttribute("value");
    }

    public String getInputSubjectOfInsuranceMiddleName() {
        return inputSubjectOfInsuranceMiddleName.getAttribute("value");
    }

    public String getInputSubjectOfInsuranceBirthDate() {
        return inputSubjectOfInsuranceBirthDate.getAttribute("value");
    }

    public String getClientSex() {
        return selectedClientSex.getText();
    }

    public String getInputPassportSeries() {
        return inputPassportSeries.getAttribute("value");
    }

    public String getInputPassportNumber() {
        return inputPassportNumber.getAttribute("value");
    }

    public String getInputDocumentDate() {
        return inputDocumentDate.getAttribute("value");
    }

    public String getInputDocumentIssue() {
        return inputDocumentIssue.getAttribute("value");
    }

    public void clickButtonContinue() {
        click(buttonContinue);
    }

    public boolean errorMessagePresenceCheck() {

        return checkPresence(errorMessage);
    }
}
