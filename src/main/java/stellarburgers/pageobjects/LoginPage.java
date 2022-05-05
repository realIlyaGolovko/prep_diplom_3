package stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    //локатор поля ввода "Email"
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/../input")
    private static SelenideElement emailInputField;
    //локатор поля ввода "Пароль"
    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/../input")
    private static SelenideElement passwordInputField;
    //локатор кнопки "Войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private static SelenideElement signInrButton;
    //локатор ссылки 'Зарегистрироваться'
    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private static SelenideElement registerLink;
    //локатор ссылки 'Восстановить пароль'
    @FindBy(how = How.LINK_TEXT, using = "Восстановить пароль")
    private static SelenideElement restorePassword;

    @Step("Ввод значения {email} в поле 'Email'")
    public void setEmail (String email) {
        emailInputField.click();
        emailInputField.setValue(email);
    }
    @Step("Ввод значения {password} в поле 'Пароль'")
    public void setPassword(String password) {
        passwordInputField.click();
        passwordInputField.setValue(password);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickSignInButton() {
        signInrButton.click();
    }

    @Step("Заполнение полей на странице 'Вход' и клик по кнопке 'Войти'")
    public void fillLoginForm(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickSignInButton();
    }
    @Step("Клик по ссылки 'Зарегистрироваться'")
    public void clickRegisterLink() {
        registerLink.scrollTo();
        registerLink.click();
    }
    @Step("Клик по ссылке 'Восстановить пароль'")
    public void clickRestorePassword() {
        restorePassword.click();
    }
}
