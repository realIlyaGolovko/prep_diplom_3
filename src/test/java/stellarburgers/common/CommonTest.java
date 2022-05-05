package stellarburgers.common;

import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;

public class CommonTest {
    @BeforeClass
    public static void setUp() {
        Configuration.browser = "chrome";//дефолтное значение
    }
}