package stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.api.user.User;
import stellarburgers.api.user.UserClient;
import stellarburgers.api.user.UserCredentials;
import stellarburgers.common.CommonTest;
import stellarburgers.pageobjects.*;

import static com.codeborne.selenide.Selenide.*;
import static stellarburgers.pageobjects.PageConstants.MAIN_PAGE_URL;

public class LoginTest extends CommonTest {
    private static User user;
    private static UserClient userClient;
    private static UserCredentials userCredentials;

    @Before
    public void CreateUser() {
        userClient = new UserClient();
        user = User.getRandomUserWithGivenPassword(6, 12);
        userClient.create(user);
        userCredentials = UserCredentials.from(user);

    }

    @After
    public void deleteUser() {
        String token = userClient.login(userCredentials);
        userClient.deleteUser(user, token);
    }

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной")
    public void UserCanLoginWithMainPageSignInButton() {
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        mainPage.clickSignInButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillLoginForm(userCredentials.getEmail(), userCredentials.getPassword());
        Assert.assertEquals("Соберите бургер", mainPage.getHeadingCreateBurger());
    }

    @Test
    @DisplayName("Вход по кнопке 'Личный кабинет'")
    public void UserCanLoginWithPersonalAreaButton() {
        MainHeaderPage mainHeaderPage = open(MAIN_PAGE_URL, MainHeaderPage.class);
        mainHeaderPage.clickPersonalAreaButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillLoginForm(userCredentials.getEmail(), userCredentials.getPassword());
        MainPage mainPage = page(MainPage.class);
        Assert.assertEquals("Соберите бургер", mainPage.getHeadingCreateBurger());
    }

    @Test
    @DisplayName("Вход по кнопке на форме регистрации")
    public void UserCanLoginWithRegisterPageSignInLink() {
        MainHeaderPage mainHeaderPage = open(MAIN_PAGE_URL, MainHeaderPage.class);
        mainHeaderPage.clickPersonalAreaButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterLink();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickSignInLink();
        loginPage.fillLoginForm(userCredentials.getEmail(), userCredentials.getPassword());
        MainPage mainPage = page(MainPage.class);
        Assert.assertEquals("Соберите бургер", mainPage.getHeadingCreateBurger());
    }

    @Test
    @DisplayName("Вход по кнопке на форме восстановления пароля")
    public void UserCanLoginWithForgotPasswordPageSignInrLink() {
        MainHeaderPage mainHeaderPage = open(MAIN_PAGE_URL, MainHeaderPage.class);
        mainHeaderPage.clickPersonalAreaButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRestorePassword();
        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.clickSignInrLink();
        loginPage.fillLoginForm(userCredentials.getEmail(), userCredentials.getPassword());
        MainPage mainPage = page(MainPage.class);
        Assert.assertEquals("Соберите бургер", mainPage.getHeadingCreateBurger());
    }
}
