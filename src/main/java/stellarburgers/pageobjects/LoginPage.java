package stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    //локатор ссылки 'Зарегистрироваться'
    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private SelenideElement registerLink;





    @Step("Клик по ссылки «Зарегистрироваться»")
    public void clickRegisterLink() {
        registerLink.scrollTo();
        registerLink.click();}
}
