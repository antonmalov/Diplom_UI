package ru.fkniga;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestLib {

    @Test
    public void successfulLoginTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        open("https://fkniga.ru/");
        $(byText("Войти")).click();
        $(byName("phone_or_email")).setValue("maloanto@yandex.ru");
        $(byName("password")).setValue("kjhgfdsfghgjkgfdhj");
        $(".form__button").$(byText("Войти")).click();
        $(".main__title").shouldHave(text("Личный кабинет"));
        $(".dataBox").shouldHave(text("maloanto@yandex.ru"));

    }

    @Test
    public void missingEmailLoginTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        open("https://fkniga.ru/");
        $(byText("Войти")).click();
        $(byName("phone_or_email")).setValue("fgfghfghfg@yandex.ru");
        $(byName("password")).setValue("kjhgfdsfghgjkgfdhj");
        $(".form__button").$(byText("Войти")).click();
        $(".errorlist li").shouldHave(text("Неверный телефон/почта или пароль."));
    }

    @Test
    public void missingPasswordLoginTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        open("https://fkniga.ru/");
        $(byText("Войти")).click();
        $(byName("phone_or_email")).setValue("maloanto@yandex.ru");
        $(byName("password")).setValue("kjhgf");
        $(".form__button").$(byText("Войти")).click();
        $(".errorlist li").shouldHave(text("Неверный телефон/почта или пароль."));
    }


    @Test
    public void logAutTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        open("https://fkniga.ru/");
        $(byText("Войти")).click();
        $(byName("phone_or_email")).setValue("maloanto@yandex.ru");
        $(byName("password")).setValue("kjhgfdsfghgjkgfdhj");
        $(".form__button").$(byText("Войти")).click();
        $(".main__title").shouldHave(text("Личный кабинет"));

        $(".btn-lk-user").hover();
        $(byText("Выйти из аккаунта")).click();
        $(".btn-auth__text").shouldHave(text("Войти"));
    }

    @Test
    public void searchBookByAuthorSanaev() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        open("https://fkniga.ru/");
        $(byName("q")).setValue("Санаев").pressEnter();
        $(".grid--removePaddingContainer").shouldHave(text("Похороните меня за плинтусом"));
    }

    @Test
    public void addingItemToTheCart() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        open("https://fkniga.ru/");
        $(byName("q")).setValue("нет орхидей для мисс блэндиш").pressEnter();
        $(".card__controls .icon-cart").click();
        $(".headerControls__item .icon-cart").click();
        $(".card__title").shouldHave(text("Нет орхидей для мисс Блэндиш"));
        $(".cartBox__inner").shouldHave(text("В корзине 1 товар"));
    }


    @Test
    public void addedFavoritesItem() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        open("https://fkniga.ru/");
        $(byName("q")).setValue("нет орхидей для мисс блэндиш").pressEnter();
        $(".js-add-favorites").click();
        $(".js-set-add-favorites").click();
    }

}
