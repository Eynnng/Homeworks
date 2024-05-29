import PageObject.AutorisationPage;
import PageObject.MainPage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@Owner("Азамат")
@Feature("Sign-in")


public class AutorisationTests extends BaseTest {

    @ParameterizedTest
    @Description("Проверка входа с неправильными входными данными")
    @MethodSource("signInWithInvalidArgs")
    @Tag("Failed_sign-in_attempts")
    public void signInWithInvalidArgsTest(String username, String password, String expectedErrorText) {
        AutorisationPage autorisationPage = new AutorisationPage();
        autorisationPage.checkPage();
        String actual = new AutorisationPage()
                .typeUserName(username)
                .typePassword(password)
                .clickSignInButton()
                .getErrorText();
        Assertions.assertEquals(expectedErrorText, actual);
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
    @Description("Проверка входа с корректными входными данными")
    @Tag("Successful sign-in")
    public void signInWithValidArgs(){
        AutorisationPage autorisationPage = new AutorisationPage();
        autorisationPage.checkPage();
        String password = "technopolisPassword";
        String username = "technopol74";
        autorisationPage.typeUserName(username)
                        .typePassword(password)
                        .clickSignInButton();
        Boolean result = new MainPage()
                    .checkPage();
        Assertions.assertTrue(result);
    }
}