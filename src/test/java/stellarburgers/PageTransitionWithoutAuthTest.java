package stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.common.CommonTest;
import stellarburgers.pageobjects.LoginPage;
import stellarburgers.pageobjects.MainHeaderPage;
import stellarburgers.pageobjects.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static stellarburgers.pageobjects.PageConstants.MAIN_PAGE_URL;

public class PageTransitionWithoutAuthTest extends CommonTest {
    private static MainPage mainPage;
    private static MainHeaderPage mainHeaderPage;
    @Before
    public void openMainPage() {
        mainPage = open(MAIN_PAGE_URL, MainPage.class);
        mainHeaderPage=page(MainHeaderPage.class);
    }

    @DisplayName("Переход по клику на 'Личный кабинет' без предварительной авторизации")
    @Test
    public void UserCanTransitionInPersonalAreaWithoutAuth() {
        mainHeaderPage.clickPersonalAreaButton();
        LoginPage loginPage = page(LoginPage.class);
        Assert.assertEquals("Вход", loginPage.getHeadingSearchLogin());
    }
    @DisplayName("Переход по клику на 'Конструктор' из личного кабинета без предварительной авторизации")
    @Test
    public void UserCanTransitionInConstructorWithoutAuth(){
        mainHeaderPage.clickPersonalAreaButton();
        mainHeaderPage.clickConstructorLink();
        Assert.assertEquals("Соберите бургер",mainPage.getHeadingCreateBurger());

    }
    @DisplayName("Переход по клику на 'логотип Stellar Burgers' из личного кабинета без предварительной авторизации")
    @Test
    public void UserCanTransitionInLogoWithoutAuth(){
        mainHeaderPage.clickPersonalAreaButton();
        mainHeaderPage.clickLogoLink();
        Assert.assertEquals("Соберите бургер",mainPage.getHeadingCreateBurger());
    }
}