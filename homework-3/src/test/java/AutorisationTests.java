import PageObject.AutorisationPage;
import PageObject.MainPage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class AutorisationTests extends BaseTest {

    @ParameterizedTest
    //проверка входа с неплавильными входными данными
    @MethodSource("signInWithInvalidArgs")
    public void signInWithInvalidArgsTest(String username, String password, String expectedErrorText) {
        AutorisationPage autorisationPage = new AutorisationPage();
        autorisationPage.typeUserName(username);
        autorisationPage.typePassword(password);
        autorisationPage.clickSignInButton();
        autorisationPage.checkAutorisationPage();
        String acual = autorisationPage.getErrorText();
        Assertions.assertEquals(expectedErrorText, acual);
    }
    private static Stream<Arguments> signInWithInvalidArgs() {
        return Stream.of(
                Arguments.of("invalidUser", "technopolisPassword", "Неправильно указан логин и/или пароль"),
                Arguments.of("technopol74", "invalidPassword", "Неправильно указан логин и/или пароль"),
                Arguments.of("invalidUser", "invalidPassword", "Неправильно указан логин и/или пароль"),
                Arguments.of("anyUserLogin", "", "Введите пароль"),
                Arguments.of("", "", "Введите логин")
        );
    }
    @Test
    //проверка входа с корректными входными данными
    public void signInWithValidArgs(){
        AutorisationPage autorisationPage = new AutorisationPage();
        boolean result;
        autorisationPage.checkAutorisationPage();
        String password = "technopolisPassword";
        String username = "technopol74";
        autorisationPage.typeUserName(username);
        autorisationPage.typePassword(password);
        autorisationPage.clickSignInButton();
        MainPage mainPage = new MainPage();
        result = mainPage.checkMainPage();
        Assertions.assertTrue(result);
    }
}