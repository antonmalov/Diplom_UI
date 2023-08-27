package ru.fkniga.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class LoginTest extends TestBase{

    @Test
    @DisplayName("Успешная авторизация")
    public void successfulLoginTest() {

        step("Авторизация с валидными данными", () -> {
            mainPage.openMainPage()
                    .pressEnter();
            loginPage.loginUser(userEmail, userPassword);
        });

        step("Проверка заголовка и почты в личном кабинете", () -> {
            loginPage
                    .checkTitle()
                    .checkEmail();
        });
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void logAutTest() {

        step("Авторизация с валидными данными", () -> {
            mainPage.openMainPage()
                    .pressEnter();
            loginPage.loginUser(userEmail, userPassword);
        });

        step("Выход из личного кабинета", () -> {
           loginPage.logOutAccount();
        });

        step("Проверка наличия кнопки Войти", () -> {
            loginPage
                    .checkTextEnter();
        });
    }

    @Test
    @DisplayName("Неуспешная авторизация без почты")
    public void withoutEmailLoginTest() {
        step("Авторизация без почты", () -> {
            mainPage.openMainPage()
                    .pressEnter();
            loginPage.loginUserWithoutEmail(userPassword);
        });

        step("Проверка текста ошибки", () -> {
            loginPage.checkErrorMessage("Обязательное поле.");
        });
    }

    @Test
    @DisplayName("Неуспешная авторизация без пароля")
    public void withoutPasswordLoginTest() {
        step("Авторизация без пароля", () -> {
            mainPage.openMainPage()
                    .pressEnter();
            loginPage.loginUserWithoutPassword(userEmail);
        });

        step("Проверка текста ошибки", () -> {
            loginPage.checkErrorMessage("Обязательное поле.");
        });
    }

    @Test
    @DisplayName("Неуспешная авторизация с невалидной почтой")
    public void missingEmailLoginTest() {
        step("Авторизация с невалидной почтой", () -> {
            mainPage.openMainPage()
                    .pressEnter();
            loginPage.loginUser("sdfsdf@yandex.ru", userPassword);
        });

        step("Проверка текста ошибки", () -> {
            loginPage.checkErrorMessage("Неверный телефон/почта или пароль.");
        });
    }

    @Test
    @DisplayName("Неуспешная авторизация с невылидным паролем")
    public void missingPasswordLoginTest() {
        step("Авторизация с невалидным паролем", () -> {
            mainPage.openMainPage()
                    .pressEnter();
            loginPage.loginUser(userEmail, "1234");
        });

        step("Проверка текста ошибки", () -> {
            loginPage.checkErrorMessage("Неверный телефон/почта или пароль.");
        });
    }


}
