package stellarburgers.common;

import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
//общий класс для тестов с настройками
public class CommonTest {
    @BeforeClass
    public static void setUp() {
        Configuration.browser = "chrome";//дефолтное значение
        Configuration.browserSize="1920x1080";
    }

    @After
    public void clearState() {
        clearBrowserLocalStorage();
    }
}