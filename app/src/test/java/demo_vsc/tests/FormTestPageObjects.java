package demo_vsc.tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.logevents.SelenideLogger;

import demo_vsc.components.ButtonClickComponent;
import demo_vsc.components.VerificationComponent;
import demo_vsc.pages.RegistrationPage;
import static io.qameta.allure.Allure.step;
import io.qameta.allure.selenide.AllureSelenide;

public class FormTestPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ButtonClickComponent buttonClick = new ButtonClickComponent();
    VerificationComponent verification = new VerificationComponent();

    @DisplayName("Заполнение формы авторизации")
    @Test
    void formTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            registrationPage.openPage("https://demoqa.com/automation-practice-form");
        });

        step("Fill form", () -> {
            registrationPage.setFirstName("Ivan")
                            .setLatName("Petrov")
                            .setUserEmail("Petrov.Ivan@mail.com")
                            .setGender("1")
                            .setUserNumber("9998887755")
                            .setBirthday("21", "September", "1990")
                            .setSubjects("math")
                            .setHobbies("Sports")
                            .setAddress("NY, Lenins str, 21")
                            .setStateAndCity("NCR", "Delhi");
        });

        step("Buton click", () -> {
            buttonClick.buttonClick("submit");
        });

        step("Check resalts", () -> {
            verification.verificationForm("Petrov", "Petrov.Ivan@mail.com", "9998887755", "Sports");
        });
    }
}
