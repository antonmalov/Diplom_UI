package ru.fkniga.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FavoritesListPage {

    private final SelenideElement favoritesList = $(".js-favorites-list");

    public void checkFavoritesItem(String nameItem) {
        favoritesList.shouldHave(text(nameItem));
    }
}
