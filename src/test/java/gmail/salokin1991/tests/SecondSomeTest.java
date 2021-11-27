package gmail.salokin1991.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class SecondSomeTest extends TestBase {

    @Test
    @DisplayName("Not funny test")
    @Owner("dsalokin")
    void pikabuSimpleTest() {

        step("Open page, checking Email label", () -> {
            open("https://demoqa.com/text-box");
            $("#userEmail-label").shouldHave(text("Email"));
        });
    }
}
