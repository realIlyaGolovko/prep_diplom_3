package stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;

public class MainPage {
    //локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private static SelenideElement signInButton;
    // Раздел «Конструктор»
    //локатор кнопки «Булки»
    @FindBy(how = How.XPATH, using = "//*[text()='Булки']")
    private static SelenideElement bunButton;
    //локатор кнопки «Соусы»
    @FindBy(how = How.XPATH, using = "//*[text()='Соусы']")
    private static SelenideElement saucesButton;
    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private static SelenideElement fillingButton;

    //локатор раздел «Булки»
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private static SelenideElement bunSection;
    //локатор раздел «Соусы»
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private static SelenideElement sauceSection;
    //локатор раздел «Начинки»
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private static SelenideElement fillingSection;


    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickSignInButton() {
        signInButton.scrollTo();
        signInButton.click();
    }

    // Раздел «Конструктор»
    @Step("Клик по разделу «Булки»")
    public static void clickBunButton() {
        bunButton.shouldBe(enabled).click();
    }

    @Step("Клик по разделу «Соусы»")
    public static void clickSauceButton() {
        saucesButton.click();
    }

    @Step("Клик по разделу «Начинки»")
    public static void clickFillingButton() {
        fillingButton.shouldBe(enabled).click();
    }

    @Step("Проверка корректности отображения раздела Булки")
    public void checkBunSectionText() {
        bunSection.shouldHave(exactText("Булки"));
    }

    @Step("Проверка корректности отображения раздела Соусы")
    public void checkSaucesSectionText() {
        sauceSection.shouldHave(exactText("Соусы"));
    }

    @Step("Проверка корректности отображения раздела Начинки")
    public void checkFillingSectionText() {
        fillingSection.shouldHave(exactText("Начинки"));
    }
}
