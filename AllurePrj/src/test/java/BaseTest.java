import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {
    protected final static String BASE_URL = "https://ok.ru/";

    @BeforeEach
    public void setUp() {
        Configuration.browser = "edge";
        Selenide.open(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
