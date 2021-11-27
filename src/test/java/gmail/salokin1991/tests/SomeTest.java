package gmail.salokin1991.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("pikabu")
public class SomeTest extends TestBase {

    @Test
    @DisplayName("Funny test")
    @Owner("dsalokin")
    void pikabuSimpleTest() {

        step("Open story page", () -> {
            mainPage.openPage();
        });
        step("Checking menu items", () -> {
            mainPage.checkingHeaderMenu();
        });
        step("Checking main words", () -> {
            mainPage.checkingMainWords();
        });
        step("Checking story author", () -> {
            mainPage.checkingAuthor();
        });
    }
}
