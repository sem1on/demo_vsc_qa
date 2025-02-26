package demo_vsc.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class VerificationComponent {
    public void verificationForm(String key_1, String key_2, String key_3, String key_4) {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(key_1), text(key_2), text(key_3), text(key_4));
    }
}
