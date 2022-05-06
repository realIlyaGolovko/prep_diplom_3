package stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.api.user.User;
import stellarburgers.api.user.UserCredentials;
import stellarburgers.common.CommonUserTest;
import stellarburgers.pageobjects.LoginPage;
import stellarburgers.pageobjects.MainHeaderPage;
import stellarburgers.pageobjects.MainPage;
import stellarburgers.pageobjects.ProfilePage;

import static com.codeborne.selenide.Selenide.*;
import static stellarburgers.pageobjects.PageConstants.MAIN_PAGE_URL;

public class PageTransitionWithAuthTest extends CommonUserTest {
    private static String token;
    private static MainPage mainPage;
    private static MainHeaderPage mainHeaderPage;
    private static LoginPage loginPage;


    @Before
    public void setUP() {
        //создали нового пользоватлея
        user = User.getRandomUserWithGivenPassword(6, 12);
        UserCredentials userCredentials = UserCredentials.from(user);
        userClient.create(user);
        token = userClient.login(userCredentials);
        //открыли главную страницу
        mainPage = open(MAIN_PAGE_URL, MainPage.class);
        mainHeaderPage = page(MainHeaderPage.class);
        //перешли в личный кабинет
        mainHeaderPage.clickPersonalAreaButton();
        loginPage = page(LoginPage.class);
        //перешли на форму логина и авторизовались
        loginPage.fillLoginForm(userCredentials.getEmail(), userCredentials.getPassword());
        //перешли в личный кабнет
        mainHeaderPage.clickPersonalAreaButton();
    }

    @After
    public void deleteUser() {
        //почистили тестовые данные
        userClient.deleteUser(user, token);
    }

    @DisplayName("Переход по клику на 'Личный кабинет' с предварительной авторизацией")
    @Test
    public void UserCanTransitionInPersonalAreaWithAuth() {
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickProfileLink();
    }

    @DisplayName("Переход по клику на 'Конструктор' из личного кабинета с предварительной авторизацией")
    @Test
    public void UserCanTransitionInConstructorWithAuth() {
        mainHeaderPage.clickConstructorLink();
        Assert.assertEquals("Соберите бургер", mainPage.getHeadingCreateBurger());
    }

    @DisplayName("Переход по клику на 'логотип Stellar Burgers' из личного кабинета с предварительной авторизацией")
    @Test
    public void UserCanTransitionInLogoWithAuth() {
        mainHeaderPage.clickLogoLink();
        Assert.assertEquals("Соберите бургер", mainPage.getHeadingCreateBurger());
    }

    @Test
    @DisplayName("Выход по кнопке 'Выйти' в личном кабинете")
    public void UserCanSignOutWithClickExitButton() {
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickExitButton();
        Assert.assertEquals("Вход", loginPage.getHeadingSearchLogin());
    }
}
