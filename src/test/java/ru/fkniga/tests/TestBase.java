package ru.fkniga.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.fkniga.helpers.Attach;
import ru.fkniga.pages.*;

import java.util.Map;
import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
    String userEmail = "maloanto@yandex.ru";
    String userPassword = "kjhgfdsfghgjkgfdhj";
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    SearchResultsPage resultsPage = new SearchResultsPage();
    CardShopPage cardShop = new CardShopPage();
    FavoritesListPage favoritesList = new FavoritesListPage();
    Faker faker = new Faker();

    @BeforeAll
    static void beforeAll() {
        Configuration.remote = System.getProperty("selenoidUrl"); //для запуска тестов удаленно
        Configuration.baseUrl = System.getProperty("baseUrl", "https://fkniga.ru/");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        //Configuration.holdBrowserOpen = true;


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
