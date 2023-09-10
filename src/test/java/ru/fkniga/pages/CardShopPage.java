package ru.fkniga.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CardShopPage {

    private final SelenideElement nameTitle = $(".card__title");
    private final SelenideElement countTitle = $(".cartBox__inner");

    public CardShopPage checkNameTitle(String title) {
        nameTitle.shouldHave(text(title));
        return this;
    }

    public void checkCount(String countText) {
        countTitle.shouldHave(text(countText));
    }
}
