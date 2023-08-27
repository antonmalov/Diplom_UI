package ru.fkniga.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardShopPage {

    SelenideElement nameTitle = $(".card__title"),
    countTitle = $(".cartBox__inner");

    public CardShopPage checkNameTitle(String title) {
        nameTitle.shouldHave(text(title));
        return this;
    }

    public CardShopPage checkCount(String countText) {
        countTitle.shouldHave(text(countText));
        return this;
    }

}
