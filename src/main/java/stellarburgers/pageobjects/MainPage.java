package stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class MainPage {
    //локатор заголовка "Соберите бургер"
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private static SelenideElement headingCreateBurger;
    //локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private static SelenideElement signInButton;

    // Раздел "Конструктор"
    //локатор кнопки "Булки"
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Булки')]")
    private static SelenideElement bunButton;
    //локатор кнопки "Соусы"
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Соусы')]")
    private static SelenideElement saucesButton;
    //локатор кнопки "Начинки"
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Начинки')]")
    private static SelenideElement fillingButton;
    //локатор активного раздела
    @FindBy(how = How.CSS, using = ".tab_tab_type_current__2BEPc")
    public SelenideElement activeSection;

    @Step("Получение текста заголовка 'Соберите бургер'")
    public String getHeadingCreateBurger() {
        headingCreateBurger.shouldBe(Condition.visible);
        return headingCreateBurger.getText();
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickSignInButton() {
        signInButton.scrollTo();
        signInButton.click();
    }

    // Раздел «Конструктор»
    @Step("Клик по разделу «Булки»")
    public void clickBunButton() {
        bunButton.shouldBe(enabled).click();
    }

    @Step("Клик по разделу «Соусы»")
    public void clickSauceButton() {
        saucesButton.click();
    }

    @Step("Клик по разделу «Начинки»")
    public void clickFillingButton() {
        fillingButton.shouldBe(enabled).click();
    }

    @Step("Получение текста активного раздела")
    public String getActiveSectionText() {
        return activeSection.getText();
    }
}
