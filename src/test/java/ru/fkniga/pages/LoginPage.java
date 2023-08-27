package ru.fkniga.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement userEmailInput = $(byName("phone_or_email")),
    userPasswordInput = $(byName("password")),
    btnEnterInAuth = $(".form__button"),
    checkTitle = $(".main__title"),
    checkEmail = $(".dataBox"),
    errorMassage = $(".errorlist li"),
    personalAccount = $(".btn-lk-user"),
    btnLogOutAccount = $(byText("Выйти из аккаунта")),
    btnEnter = $(".btn-auth__text");



    public LoginPage loginUser(String email, String password) {
        userEmailInput.setValue(email);
        userPasswordInput.setValue(password);
        btnEnterInAuth.click();
        return this;
    }

    public LoginPage loginUserWithoutEmail(String password) {
        userPasswordInput.setValue(password);
        btnEnterInAuth.click();
        return this;
    }

    public LoginPage loginUserWithoutPassword(String email) {
        userEmailInput.setValue(email);
        btnEnterInAuth.click();
        return this;
    }

    public LoginPage logOutAccount() {
        personalAccount.hover();
        btnLogOutAccount.click();
        return this;
    }

    public LoginPage checkTitle() {
        checkTitle.shouldHave(text("Личный кабинет"));
        return this;
    }

    public LoginPage checkEmail() {
        checkEmail.shouldHave(text("maloanto@yandex.ru"));
        return this;
    }

    public LoginPage checkErrorMessage(String text) {
        errorMassage.shouldHave(text(text));
        return this;
    }

    public LoginPage checkTextEnter() {
        btnEnter.shouldHave(text("Войти"));
        return this;
    }



}
