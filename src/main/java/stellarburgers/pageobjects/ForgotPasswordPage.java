package stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    //локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement singInButton;

    @Step("Нажать кнопку 'Войти'")
    public void clickSingInButton() {
        singInButton.scrollTo();
        singInButton.click();
    }
}
