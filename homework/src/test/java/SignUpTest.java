import PageObjects.SignInPage;
import PageObjects.SignUpPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignUpTest extends BaseTest{
    @Test
    public void SignUpWithInvalidValueTest(){
        SignInPage autorize = new SignInPage(driver);
        String phone = "12345";
        driver.get("https://ok.ru/");
        String expected = "Неправильный номер телефона.";
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickSignUp();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.typePhoneNumber(phone);
        signUpPage.clickNextButton();
        Assertions.assertEquals(expected, signUpPage.getErrorText());
    }//регистрация с неправильным номером телефона
}
