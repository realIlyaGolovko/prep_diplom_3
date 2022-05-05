package stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.api.user.User;
import stellarburgers.api.user.UserCredentials;
import stellarburgers.common.CommonTest;
import stellarburgers.pageobjects.RegisterPage;
import static com.codeborne.selenide.Selenide.*;
import static stellarburgers.pageobjects.PageConstants.REGISTER_PAGE_URL;

public class RegistrationValidationTest extends CommonTest {
    private static User user;

    @Before
    public void CreateUser() {
        user = User.getRandomUserWithGivenPassword(1,5);
        UserCredentials userCredentials = UserCredentials.from(user);
    }


    @Test
    @DisplayName("Проверка отображения ошибки для некорректного пароля ")
    public void UserCannotBeRegisterWithInValidPassword() {
        RegisterPage registerPage = open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.fillRegisterForm(user.getName(), user.getEmail(), user.getPassword());
        Assert.assertEquals("Некорректный пароль", registerPage.getPasswordErrorMsg());
    }

}
