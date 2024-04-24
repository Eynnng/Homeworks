import PageObject.AutorisationPage;
import PageObject.SignUpPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignUpTest extends BaseTest{
    @Test
    //регистрация с неправильным номером телефона
    public void SignUpWithInvalidValueTest(){
        AutorisationPage autorisationPage = new AutorisationPage();
        String phone = "12345";
        String expected = "Неправильный номер телефона.";
        autorisationPage.clickSignUp();
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpByPhoneNumber(phone);
        String actual = signUpPage.getErrorText();
        Assertions.assertEquals(expected, actual);
    }
}
