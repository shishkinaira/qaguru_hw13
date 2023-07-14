package com.hw13.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestSimpleFormWithComments extends TestBase {
    @Tag("formtest")
    @DisplayName("Checking form and result content without Objects")
    @Test
    void successTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        //fill form
        $("#firstName").setValue("TestFirstName");
        $("#lastName").setValue("TestLastN");
        $("#userEmail").setValue("test@test.test");
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue("1111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#currentAddress").setValue("TestCurrentAddress");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        //check popup
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("TestFirstName"),
                text("TestLastN"),
                text("test@test.test"),
                text("1111111111"),
                text("Maths"),
                text("TestCurrentAddress"),
                text("30 July,2000"),
                text("Sports"),
                text("1.png"),
                text("NCR Delhi"));
    }

}