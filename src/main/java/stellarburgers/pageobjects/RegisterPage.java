package stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {
    //локатор поля ввода "Имя"
    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/../input")
    private static SelenideElement nameInputField;
    //локатор поля ввода "Email"
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/../input")
    private static SelenideElement emailInputField;
    //локатор поля ввода "Пароль"
    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/../input")
    private static SelenideElement passwordInputField;
    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private static SelenideElement registerButton;
    //локатор надписи "Некорректный пароль"
    @FindBy(how = How.XPATH,using = ".//p[text()='Некорректный пароль']")
    private static SelenideElement errorPasswordMsg;



    @Step("Ввод значения {name} в поле 'Имя'")
    public void setName (String name) {
        nameInputField.click();
        nameInputField.setValue(name);
    }


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

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegisterButton() {
        registerButton.click();
    }

    @Step("Заполнение полей на странице 'Регистрация' и клик по кнопке 'Зарегистрироваться'")
    public void fillRegisterForm(String name,String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }
    @Step("Отображение сообщения об ошибке при невалидном пароле")
    public String getPasswordErrorMsg(){
        errorPasswordMsg.shouldBe(Condition.visible);
        return errorPasswordMsg.getText();
    }
}
