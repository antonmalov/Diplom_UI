package ru.fkniga.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardShop {

    SelenideElement nameTitle = $(".card__title"),
    countTitle = $(".cartBox__inner");

    public CardShop checkNameTitle(String title) {
        nameTitle.shouldHave(text(title));
        return this;
    }

    public CardShop checkCount(String countText) {
        countTitle.shouldHave(text(countText));
        return this;
    }

}
