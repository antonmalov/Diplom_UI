package ru.fkniga.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.fkniga.pages.CardShopPage;
import ru.fkniga.pages.MainPage;
import ru.fkniga.pages.SearchResultsPage;

import static io.qameta.allure.Allure.step;

public class CardShopTest extends TestBase {
    MainPage mainPage = new MainPage();
    SearchResultsPage resultsPage = new SearchResultsPage();
    CardShopPage cardShop = new CardShopPage();

    @Test
    @DisplayName("Добавление товара в корзину")
    public void addedTitleCardShop() {

        step("Добавление товара в корзину", () -> {
            mainPage.openMainPage()
                    .inputSearchText("нет орхидей для мисс блэндиш");
            resultsPage.addedItemToCard();
        });

        step("Проверка наличия товара в корзине", () -> {
            mainPage.goToCard();
            cardShop.checkNameTitle("Нет орхидей для мисс Блэндиш")
                    .checkCount("В корзине 1 товар");
        });
    }
}
