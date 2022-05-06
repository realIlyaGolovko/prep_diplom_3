package stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pageobjects.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static stellarburgers.pageobjects.PageConstants.MAIN_PAGE_URL;

public class ConstructorTest {
    private static MainPage mainPage;
    @Before
    public void openManePage(){
       mainPage=open(MAIN_PAGE_URL,MainPage.class);
    }
    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void transitionToTheBunSection(){
    }

}
