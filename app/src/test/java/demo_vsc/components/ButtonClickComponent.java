package demo_vsc.components;

import static com.codeborne.selenide.Selenide.$;

public class ButtonClickComponent {

    public void buttonClick(String idButton) {
        $("#" + idButton).click();
    }
}
