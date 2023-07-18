package com.hw13.tests;
import com.hw13.pages.SimpleFormWithPageObjects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.hw13.utils.RandomUtils.*;

public class TestRemoteSimpleFormWithPageObjects extends TestRemoteBase {
    SimpleFormWithPageObjects simpleFormWithPageObjects = new SimpleFormWithPageObjects();
    @Tag("formtest")
    @Tag("remote")
    @Tag("properties")
    @Test
    @DisplayName("Checking form and result content with Objects")
    void successfulRegistrationTest() {

        //обьявляем переменные и заносим в них рандомную дату из RundomUtils
        String  randomFirstName = faker.name().firstName(),
                randomLastN = faker.name().lastName(),
                randomUserEmail = faker.internet().emailAddress(),
                randomPhone = getRandomPhone(),
                randomCurrentAddress = faker.address().fullAddress(),
                randomUserGander = getRandomGender(),
                randomHobby = getRandomHobby(),
                randomSubjects = getRandomSubjects(),
                randomDay = getRandomDay(),
                randomMonth = getRandomMonth(),
                randomYear = getRandomYear(),
                randomState = getRandomState(),
                randomCity = getRandomCity(randomState);

        //Проверка заполения формы
        simpleFormWithPageObjects.openPage()
                .removeBanner()
                .setFirstName(randomFirstName)
                .setLastName(randomLastN)
                .setUserEmailName(randomUserEmail)
                .setGender(randomUserGander)
                .setUserNumber(randomPhone)
                .setBirthDay(randomDay, randomMonth, randomYear)
                .setCurrentAddress(randomCurrentAddress)
                .setHobby(randomHobby)
                .setSubjects(randomSubjects)
                .setCity(randomState, randomCity)
                .uploadPicture("src/test/resources/1.png")
                .clickSubmit();

        //Проверка данных попапа
        simpleFormWithPageObjects.checkResult("Student Name", randomFirstName)
                .checkResult("Student Email", randomUserEmail)
                .checkResult("Gender", randomUserGander)
                .checkResult("Mobile", randomPhone)
                .checkResult("Date of Birth", randomDay + " " + randomMonth + "," + randomYear)
                .checkResult("Subjects", randomSubjects)
                .checkResult("Hobbies", randomHobby)
                .checkResult("Picture", "1.png")
                .checkResult("Address", randomCurrentAddress)
                .checkResult("State and City", randomState + " " + randomCity);
    }

}