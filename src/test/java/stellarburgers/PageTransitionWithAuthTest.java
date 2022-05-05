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
    private static MainPage mainPage;
    private static MainHeaderPage mainHeaderPage;
    private static String token;

    @Before
    public void openMainPage() {
        user = User.getRandomUserWithGivenPassword(6, 12);
        UserCredentials userCredentials = UserCredentials.from(user);
        userClient = new UserClient();
        userClient.create(user);
        mainPage = open(MAIN_PAGE_URL, MainPage.class);
        mainHeaderPage = page(MainHeaderPage.class);
        mainHeaderPage.clickPersonalAreaButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillLoginForm(userCredentials.getEmail(), userCredentials.getPassword());
        ValidatableResponse validatableResponse = userClient.login(userCredentials);
        token = validatableResponse.extract().jsonPath().getString("accessToken");
    }

    @After
    public void deleteUser() {
        userClient.deleteUser(user, token);
    }

    @DisplayName("Переход по клику на 'Личный кабинет' с предварительной авторизацией")
    @Test
    public void UserCanTransitionInPersonalAreaWithAuth() {
        mainHeaderPage.clickPersonalAreaButton();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickProfileLink();
    }

    @DisplayName("Переход по клику на 'Конструктор' из личного кабинета с предварительной авторизацией")
    @Test
    public void UserCanTransitionInConstructorWithAuth() {
        mainHeaderPage.clickPersonalAreaButton();
        mainHeaderPage.clickConstructorLink();
        Assert.assertEquals("Соберите бургер", mainPage.getHeadingCreateBurger());
    }

    @DisplayName("Переход по клику на 'логотип Stellar Burgers' из личного кабинета с предварительной авторизацией")
    @Test
    public void UserCanTransitionInLogoWithAuth() {
        mainHeaderPage.clickPersonalAreaButton();
        mainHeaderPage.clickLogoLink();
        Assert.assertEquals("Соберите бургер", mainPage.getHeadingCreateBurger());
    }
}
