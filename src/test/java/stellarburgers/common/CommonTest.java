package stellarburgers.common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.BeforeClass;

public class CommonTest {
    @BeforeClass
    public static void setUp() {
        Configuration.browser = "chrome";//дефолтное значение
        Configuration.browserSize="1920x1080";
    }

    @After
    public void clearState() {
        Selenide.clearBrowserLocalStorage();
    }
}