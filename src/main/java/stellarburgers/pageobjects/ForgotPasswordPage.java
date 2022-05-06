package stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    //локатор ссылки "Войти"
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private static SelenideElement signInrLink;

    @Step("Нажать ссылку 'Войти'")
    public void clickSignInrLink() {
        signInrLink.scrollTo();
        signInrLink.click();
    }
}
