# Diplom_UI

Проект по автоматизации тестирования для ресурса [fkniga.ru](https://fkniga.ru/)

> fkniga.ru - интернет магазин по продаже книг, канцелярии и подарков


### Реализованные проверки:
* Успешная авторизация
* Различные вариант неуспешной авторизации
* Выход из аккаунта
* Поиск товара
* Добавление товара в корзину
* Добавление товара в избранное 

____
### Технологии и инструменты:
<p align="center">
<img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/>
<img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/>
<img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/>
<img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/>
<img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/>
<img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/>
<img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/>
<img src="images/logo/Allure_Report.svg" width="50" height="50"  alt="Allure_Report"/>
<img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/>
</p>


____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="[images/logo/Jenkins.svg](https://p1c2u.gallerycdn.vsassets.io/extensions/p1c2u/jenkins/0.1.0/1551451475146/Microsoft.VisualStudio.Services.Icons.Default)" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/MalovDiplomUI/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/20-evgenii_k99-homework15/"><img src="images/screenshots/jenkins.png" alt="Jenkins" width="950"/></a>  
</p>


### **Параметры сборки в Jenkins:**

- *BROWSER (браузер, по умолчанию chrome)*
- *BROWSER_SIZE (размер окна браузера, по умолчанию 1920x1080)*
- *TESTS_TAG (выбор тестов для запуска, по умолчанию запуск всех тестов - test)*

<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean test -Denv=local
```

***Удалённый запуск через Jenkins:***
```bash  
clean ${TESTS_TAG}
"-Denv=remote"
"-Dbrowser=${BROWSER}"
"-DbrowserSize=${BROWSER_SIZE}"
```
___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/20-evgenii_k99-homework15/allure/)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screenshots/AllureReport.png" width="850">  
</p>  
