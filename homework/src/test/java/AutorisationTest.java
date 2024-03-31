import PageObjects.SignInPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

public class AutorisationTest extends BaseTest{
    @ParameterizedTest
    @MethodSource("signInWithInvalidArgs")
    public void signInWithInvalidArgsTest(String username, String password){
        boolean result;
        driver.get("https://ok.ru/");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.typeUserName(username);
        signInPage.typePassword(password);
        signInPage.clickSignIn();
        result = signInPage.checkSignInButton();
        Assertions.assertFalse(result);
    }//проверка входа с неплавильными входными данными
    private static Stream<Arguments> signInWithInvalidArgs() {
        return Stream.of(
                Arguments.of("invalidUser", "technopolisPassword"),
                Arguments.of("technopol74", "invalidPassword"),
                Arguments.of("invalidUser", "invalidPassword"),
                Arguments.of("", "")
        );
    }
    @Test
    public void signInWithValidArgs(){
        driver.get("https://ok.ru/");
        SignInPage signInPage = new SignInPage(driver);
        boolean result;
        String password = "technopolisPassword";
        String username = "technopol74";
        signInPage.typeUserName(username);
        signInPage.typePassword(password);
        signInPage.clickSignIn();
        result = signInPage.checkSignInButton();
        Assertions.assertTrue(result);
    }//проверка входа с корректными входными данными
}