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
import stellarburgers.pageobjects.RegisterPage;

import static com.codeborne.selenide.Selenide.*;
import static stellarburgers.pageobjects.PageConstants.REGISTER_PAGE_URL;

public class RegistrationTest extends CommonTest {
    private static User user;
    private static UserClient userClient;
    private static UserCredentials userCredentials;
    private static String token;

    @Before
    public void CreateUser() {
        userClient = new UserClient();
        user = User.getRandomUserWithGivenPassword(6,12);
        userCredentials = UserCredentials.from(user);
    }

    @After
    public void deleteUser() {
        userClient.deleteUser(user, token);
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void registerUserWithValidCredentials() {
        RegisterPage registerPage = open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.fillRegisterForm(user.getName(), user.getEmail(), user.getPassword());
        ValidatableResponse validatableResponse = userClient.login(userCredentials);
        token = validatableResponse.extract().jsonPath().getString("accessToken");
        LoginPage loginPage=page(LoginPage.class);
        Assert.assertEquals("Вход",loginPage.getHeadingSearchLogin());
    }
}
