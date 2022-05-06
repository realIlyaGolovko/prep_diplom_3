package stellarburgers.api.user;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.Data;

import java.util.Locale;

@Data
public class User {
    private String email;
    private String password;
    private String name;
    private static Faker faker = new Faker(new Locale("ru"));

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @Step("Инициализация нового пользователя с заданной длиной пароля")
    public static User getRandomUserWithGivenPassword(int minPasswordLength, int maxPasswordLength) {
        String email = faker.internet().emailAddress();
        Allure.addAttachment("email", email);
        String password = faker.internet().password(minPasswordLength, maxPasswordLength, true, true, true);
        Allure.addAttachment("password", password);
        String name = faker.name().firstName();
        Allure.addAttachment("name", name);
        return new User(email, password, name);
    }
}
