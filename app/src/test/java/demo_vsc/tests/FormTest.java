package demo_vsc.tests;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.logevents.SelenideLogger;

import static io.qameta.allure.Allure.step;
import io.qameta.allure.selenide.AllureSelenide;

public class FormTest extends TestBase {

    @Test
    void formTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open("https://demoqa.com/automation-practice-form");
        });
        step("Fill form", () -> {
            $("#firstName").setValue("Ivan");
            $("#lastName").setValue("Petrov");
            $("#userEmail").setValue("Petrov.Ivan@mail.com");
            $("#gender-radio-1").parent().click();
            $("#userNumber").setValue("9998887721");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("September");
            $(".react-datepicker__year-select").selectOption("1992");
            $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
            $("#subjectsInput").setValue("math").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#currentAddress").setValue("NY, Lenins str, 21");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
            $("#submit").click();
        });
        step("Check resalts", () -> {
            $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Petrov"), text("Petrov.Ivan@mail.com"), text("9998887721"), text("Sports"));
        });
    }
}
