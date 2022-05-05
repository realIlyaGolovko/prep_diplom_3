package stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;

public class MainHeaderPage {
    //локатор кнопки "Личный Кабинет"
    @FindBy(how = How.XPATH, using = ".//a[starts-with(@class, 'AppHeader_header')]/p[text()='Личный Кабинет']")
    private static SelenideElement personalAreaButton;

    //локатор ссылки "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private static SelenideElement constructorLink;
    //локатор логотип Stellar Burgers
    @FindBy(how = How.XPATH, using = ".//div[starts-with(@class, 'AppHeader_header__logo')]")
    private static SelenideElement logo;


    @Step("Клик по кнопке «Личный Кабинет»")
    public void clickPersonalAreaButton() {
        personalAreaButton.click();
    }

    @Step("Клик по кнопке «Конструктор»")
    public void clickConstructorLink() {
        constructorLink.shouldBe(enabled).click();
    }

    @Step("Клик по логотипу Stellar Burgers")
    public  void clickLogoLink() {
        logo.shouldBe(enabled).click();
    }
}
