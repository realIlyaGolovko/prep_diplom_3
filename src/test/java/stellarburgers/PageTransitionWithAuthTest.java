package stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.api.user.User;
import stellarburgers.api.user.UserClient;
import stellarburgers.api.user.UserCredentials;
import stellarburgers.common.CommonTest;
import stellarburgers.pageobjects.LoginPage;
import stellarburgers.pageobjects.MainHeaderPage;
import stellarburgers.pageobjects.MainPage;
import stellarburgers.pageobjects.ProfilePage;

import static com.codeborne.selenide.Selenide.*;
import static stellarburgers.pageobjects.PageConstants.MAIN_PAGE_URL;

public class PageTransitionWithAuthTest extends CommonTest {
    private static User user;
    private static UserClient userClient;
    private static String token;
    private static MainPage mainPage;
    private static MainHeaderPage mainHeaderPage;
    private static LoginPage loginPage;


    @Before
    public void setUP() {
        user = User.getRandomUserWithGivenPassword(6, 12);
        UserCredentials userCredentials = UserCredentials.from(user);
        userClient = new UserClient();
        userClient.create(user);
        mainPage = open(MAIN_PAGE_URL, MainPage.class);
        mainHeaderPage = page(MainHeaderPage.class);
        mainHeaderPage.clickPersonalAreaButton();
        loginPage = page(LoginPage.class);
        loginPage.fillLoginForm(userCredentials.getEmail(), userCredentials.getPassword());
        ValidatableResponse validatableResponse = userClient.login(userCredentials);
        token = validatableResponse.extract().jsonPath().getString("accessToken");
        mainHeaderPage.clickPersonalAreaButton();
    }

    @After
    public void deleteUser() {
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
    public void UserCanSignOutWithClickExitButton(){
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickExitButton();
        Assert.assertEquals("Вход",loginPage.getHeadingSearchLogin());
    }
}
