package ru.fkniga.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement userEmailInput = $(byName("phone_or_email")),
            userPasswordInput = $(byName("password")),
            btnEnterInAuth = $(".form__button"),
            checkTitle = $(".main__title"),
            checkEmail = $(".dataBox"),
            errorMassage = $(".errorlist li"),
            personalAccount = $(".btn-lk-user"),
            btnLogOutAccount = $(byText("Выйти из аккаунта")),
            btnEnter = $(".btn-auth__text");

    public void loginUser(String email, String password) {
        userEmailInput.setValue(email);
        userPasswordInput.setValue(password);
        btnEnterInAuth.click();
    }

    public void loginUserWithoutEmail(String password) {
        userPasswordInput.setValue(password);
        btnEnterInAuth.click();
    }

    public void loginUserWithoutPassword(String email) {
        userEmailInput.setValue(email);
        btnEnterInAuth.click();
    }

    public void logOutAccount() {
        personalAccount.hover();
        btnLogOutAccount.click();
    }

    public LoginPage checkTitle(String text) {
        checkTitle.shouldHave(text(text));
        return this;
    }

    public void checkEmail(String email) {
        checkEmail.shouldHave(text(email));
    }

    public void checkErrorMessage(String text) {
        errorMassage.shouldHave(text(text));
    }

    public void checkTextEnter(String text) {
        btnEnter.shouldHave(text(text));
    }
}
