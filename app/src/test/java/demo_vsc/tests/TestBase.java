package demo_vsc.tests;

import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;

public class TestBase {

    @BeforeAll
    static void pageWait() {
        Configuration.pageLoadTimeout = 600000;
    }
}
