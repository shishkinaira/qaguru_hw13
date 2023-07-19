package com.hw13.pages;
import com.codeborne.selenide.SelenideElement;
import com.hw13.pages.components.CalendarComponent;
import com.hw13.pages.components.CityComponent;
import com.hw13.pages.components.VerifyComponent;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SimpleFormWithPageObjects {
    //String loginInputLocator= "#firstName"; - bed practice
    CalendarComponent calendarComponent = new CalendarComponent();
    CityComponent cityComponent = new CityComponent();
    VerifyComponent verifyResultWO = new VerifyComponent();
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            ganderWrapper = $("#genterWrapper").parent(),
            userNumberInput = $("#userNumber"),
            dayBirthInput = $("#dateOfBirthInput"),
            currentAddressInput = $("#currentAddress"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            subjectsInput = $("#subjectsInput"),
            pictureFile = $("#uploadPicture"),
            submitButton = $("#submit");
    @Step("Open page")
    public SimpleFormWithPageObjects openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Remove banner")
    public SimpleFormWithPageObjects removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    @Step("Set First Name")
    public SimpleFormWithPageObjects setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Set Last Name")
    public SimpleFormWithPageObjects setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Set Email")
    public SimpleFormWithPageObjects setUserEmailName(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Set Gander")
    public SimpleFormWithPageObjects setGender(String value) {
        ganderWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Set Number")
    public SimpleFormWithPageObjects setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    @Step("Set BDay")
    public SimpleFormWithPageObjects setBirthDay(String day,
                                                 String month,
                                                 String year) {
        dayBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    @Step("Set Address")
    public SimpleFormWithPageObjects setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    @Step("Set Hobby")
    public SimpleFormWithPageObjects setHobby(String sport) {
        hobbiesWrapper.$(byText(sport)).click();
        return this;
    }
    @Step("Set Subjects")
    public SimpleFormWithPageObjects setSubjects(String value) {
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();
        return this;
    }
    @Step("Set City")
    public SimpleFormWithPageObjects setCity(String area, String city) {
        cityComponent.setCity(area, city);
        return this;
    }
    @Step("Set Picture")
    public SimpleFormWithPageObjects uploadPicture(String value) {
        pictureFile.uploadFile(new File(value));
        return this;
    }
    @Step("Click Submit Button")
    public SimpleFormWithPageObjects clickSubmit() {
        submitButton.click();
        return this;
    }
    @Step("Verify results")
    public SimpleFormWithPageObjects checkResult(String fromTable, String fromUser) {
        verifyResultWO.verifyResults(fromTable, fromUser);
        return this;
    }

}

