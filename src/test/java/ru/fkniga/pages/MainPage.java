package ru.fkniga.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final String MAIN_PAGE_URL = "https://fkniga.ru/";
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

    public void pressEnter() {
        btnEnter.click();
    }

    public void inputSearchText(String textForSearch) {
        inputSearch.setValue(textForSearch).pressEnter();
    }

    public void goToCard() {
        btnCard.click();
    }

    public void goToFavoritesList() {
        btnHeart.click();
    }
}
