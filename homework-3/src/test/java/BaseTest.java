import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "edge";
        Selenide.open("https://ok.ru/");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
