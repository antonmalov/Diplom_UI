package ru.fkniga.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.fkniga.pages.FavoritesListPage;
import ru.fkniga.pages.MainPage;
import ru.fkniga.pages.SearchResultsPage;

import static io.qameta.allure.Allure.step;

public class FavoritesItemsTest extends TestBase {
    MainPage mainPage = new MainPage();
    SearchResultsPage resultsPage = new SearchResultsPage();
    FavoritesListPage favoritesList = new FavoritesListPage();

    @Test
    @DisplayName("Добавление товара в избранное")
    public void addedItemsInFavoritesList() {

        step("Добавление товара в избранные", () -> {
            mainPage.openMainPage()
                    .inputSearchText("нет орхидей для мисс блэндиш");
            resultsPage.addedItemToFavoritesList();
        });

        step("Проверка наличия товара в списке избранных", () -> {
            mainPage.goToFavoritesList();
            favoritesList.checkFavoritesItem("Нет орхидей для мисс Блэндиш");
        });
    }
 }
