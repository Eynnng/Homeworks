import PageObject.AutorisationPage;
import PageObject.SignUpPage;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignUpTest extends BaseTest{
    @Test
    @Owner("")
    @Description("")
    //регистрация с неправильным номером телефона
    public void SignUpWithInvalidValueTest(){
        String phone = "12345";
        String expected = "Неправильный номер телефона.";
        String actual = new AutorisationPage()
                .clickSignUp()
                .signUpByPhoneNumber(phone)
                .getErrorText();
        Assertions.assertEquals(expected, actual);
    }
}
