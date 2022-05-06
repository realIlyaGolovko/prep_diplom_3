package stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.common.CommonTest;
import stellarburgers.pageobjects.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static stellarburgers.pageobjects.PageConstants.MAIN_PAGE_URL;

public class ConstructorTest extends CommonTest {
    private static MainPage mainPage;

    @Before
    public void openManePage() {
        mainPage = open(MAIN_PAGE_URL, MainPage.class);
    }

    @Test
    @DisplayName("При открытии главной страницы отображается раздел 'Булки'")
    public void manePageDefaultOpenBunSection() {
        Assert.assertEquals("Булки", mainPage.getActiveSectionText());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void transitionToSaucesSection() {
        mainPage.clickSauceButton();
        Assert.assertEquals("Соусы", mainPage.getActiveSectionText());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void transitionToFillingSection() {
        mainPage.clickFillingButton();
        Assert.assertEquals("Начинки", mainPage.getActiveSectionText());
    }

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void transitionToBunSection() {
        mainPage.clickFillingButton();
        mainPage.clickBunButton();
        Assert.assertEquals("Булки", mainPage.getActiveSectionText());
    }

}
