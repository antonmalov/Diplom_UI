package ru.fkniga.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SearchBooksTest extends TestBase {

    @Test
    @DisplayName("Поиск книги по автору")
    public void searchBookByAuthor() {

        step("Введение поискового запроса", () -> {
            mainPage
                    .openMainPage()
                    .inputSearchText("Санаев");
        });

        step("Проверка поисковой выдачи", () -> {
            resultsPage.resultSearchBooks("Похороните меня за плинтусом");
        });
    }
}
