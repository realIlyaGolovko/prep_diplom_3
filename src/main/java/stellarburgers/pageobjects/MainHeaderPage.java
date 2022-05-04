package stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainHeaderPage {
    //локатор кнопки «Личный Кабинет»
    @FindBy(how = How.XPATH, using = ".//a[starts-with(@class, 'AppHeader_header')]/p[text()='Личный Кабинет']")
    private static SelenideElement personalAreaButton;






    @Step("Клик по кнопке «Личный Кабинет»")
    public static void clickPersonalAreaButton() {
        personalAreaButton.click();
    }
}
