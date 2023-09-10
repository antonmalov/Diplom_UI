package ru.fkniga.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {

    private final SelenideElement resultSearch = $(".grid--removePaddingContainer"),
            addedToCard = $(".card__controls .icon-cart"),
            addedToFavoritesList = $(".js-add-favorites");


    public void resultSearchBooks(String resultText) {
        resultSearch.shouldHave(text(resultText));
    }

    public void addedItemToCard() {
        addedToCard.click();
    }

    public void addedItemToFavoritesList() {
        addedToFavoritesList.click();
    }
}
