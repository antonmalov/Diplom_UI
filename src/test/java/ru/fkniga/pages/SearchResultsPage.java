package ru.fkniga.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {

    SelenideElement resultSearch = $(".grid--removePaddingContainer"),
    addedToCard = $(".card__controls .icon-cart"),
    addedToFavoritesList = $(".js-add-favorites");


    public SearchResultsPage resultSearchBooks(String resultText) {
        resultSearch.shouldHave(text(resultText));
        return this;
    }

    public SearchResultsPage addedItemToCard() {
        addedToCard.click();
        return this;
    }

    public SearchResultsPage addedItemToFavoritesList() {
        addedToFavoritesList.click();
        return this;
    }
}
