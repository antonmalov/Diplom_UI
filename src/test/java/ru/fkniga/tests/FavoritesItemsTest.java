package ru.fkniga.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class FavoritesItemsTest extends TestBase{

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
