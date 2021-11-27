package gmail.salokin1991.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    // locators & elements

    private final String STORY_URL = "https://pikabu.ru/story/vyi_prinyatyi_na_rabotu_8642670",
            ITEM_1 = "Горячее",
            ITEM_2 = "Лучшее",
            ITEM_3 = "Свежее",
            ITEM_4 = "Подписки",
            AN_IMPORTANT_WORDS = "Вы приняты на работу!",
            AUTHOR = "Pacan4ik1";
    private final SelenideElement
            headerMenuBoardLocator = $(".header-menu"),
            storyAuthorLocator = $(".story__user-info");

    // actions

    public MainPage openPage() {
        open(STORY_URL);
        return this;
    }

    public MainPage checkingHeaderMenu() {
        headerMenuBoardLocator.shouldHave(
                text(ITEM_1),
                text(ITEM_2),
                text(ITEM_3),
                text(ITEM_4));
        return this;
    }

    public MainPage checkingMainWords() {
        $(byText(AN_IMPORTANT_WORDS)).shouldBe(visible);
        return this;
    }

    public MainPage checkingAuthor() {
        storyAuthorLocator.shouldHave(text(AUTHOR));
        return this;
    }
}
