import PageObject.AutorisationPage;
import PageObject.SignUpPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignUpTest extends BaseTest{
    @Test
    //регистрация с неправильным номером телефона
    public void SignUpWithInvalidValueTest(){
        String phone = "12345";
        String expected = "Неправильный номер телефона.";
        AutorisationPage autorisationPage = new AutorisationPage();
        SignUpPage signUpPage = new SignUpPage();
        autorisationPage.clickSignUp();
        signUpPage.signUpByPhoneNumber(phone);
        String actual = signUpPage.getErrorText();
        Assertions.assertEquals(expected, actual);
    }
}
