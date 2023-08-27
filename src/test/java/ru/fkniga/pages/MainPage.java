package ru.fkniga.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private static final String MAIN_PAGE_URL = "https://fkniga.ru/";
    private final SelenideElement logo = $(".logo"),
            btnEnter = $(byText("Войти")),
            inputSearch = $(byName("q")),
            btnHeart = $(".js-set-add-favorites"),
            btnCard = $(".headerControls__item .icon-cart");

    public MainPage openMainPage() {
        open(MAIN_PAGE_URL);
        logo.should(be(visible));
        return this;
    }

    public MainPage pressEnter() {
        btnEnter.click();
        return this;
    }

    public MainPage inputSearchText(String textForSearch) {
        inputSearch.setValue(textForSearch).pressEnter();
        return this;
    }

    public MainPage goToCard() {
        btnCard.click();
        return this;
    }

    public MainPage goToFavoritesList() {
        btnHeart.click();
        return this;
    }





}
