package stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class ProfilePage {
    //локатор ссылки "Профиль"
    @FindBy(how = How.LINK_TEXT, using = "Профиль")
    private static SelenideElement profileLink;
    //локатор кнопки "Выход"
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private static SelenideElement exitButton;

    @Step("Клик по ссылке 'Профиль'")
    public void clickProfileLink() {
        profileLink.shouldBe(visible).click();
    }

    @Step("Клик по кнопке «Выход»")
    public void clickExitButton() {
        exitButton.shouldBe(enabled).click();
    }
}
