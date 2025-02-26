package demo_vsc.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import demo_vsc.components.CalendarComponent;
import demo_vsc.components.StateAndCityComponent;
import static io.qameta.allure.Allure.step;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    StateAndCityComponent stateAndCity = new StateAndCityComponent();

    public void openPage(String baseUrl) {
        step("Open page", () -> {
            open(baseUrl);
        });
    }

    public RegistrationPage setFirstName(String firstName) {
        step("Set first name", () -> {
            $("#firstName").setValue(firstName);
        });
        return this;
    }

    public RegistrationPage setLatName(String lastName) {
        step("Set last name", () -> {
            $("#lastName").setValue(lastName);
        });
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        step("Set user email", () -> {
           $("#userEmail").setValue(userEmail); 
        });
        return this;
    }

    public RegistrationPage setGender(String userGender) {
        step("Chuse gender", () -> {
           $("#gender-radio-" + userGender).parent().click(); 
        });
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        step("Set user phone number", () -> {
           $("#userNumber").setValue(userNumber); 
        });
        return this;
    }

    public RegistrationPage setBirthday(String day, String month, String year) {
        step("Setr Birthday", () -> {
           $("#dateOfBirthInput").click();
            calendarComponent.setDate(day, month, year); 
        });
        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        step("Set user subjectsr", () -> {
            $("#subjectsInput").setValue(subjects).pressEnter(); 
        });
        return this;
    }

    public RegistrationPage setHobbies(String userHobbies) {
        step("Set user hobbies", () -> {
            $("#hobbiesWrapper").$(byText(userHobbies)).click(); 
        });
        return this;
    }

    public RegistrationPage setAddress(String userAddress) {
        step("Set user address", () -> {
            $("#currentAddress").setValue(userAddress); 
        });
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        step("Set user state and city", () -> {
            stateAndCity.setStateAndCity(state, city);
        });
        return this;
    }
}
