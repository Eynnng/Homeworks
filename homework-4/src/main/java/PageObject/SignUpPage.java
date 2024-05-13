package PageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {

    public SignUpPage(){
        checkSignUpPage();
    }


    private final By phoneNumberField = By.xpath(".//*[@id='field_phone']");
    private final By nextButton = By.xpath(".//input[@value='Далее']");
    private final By errorText = By.xpath(".//*[text()='Неправильный номер телефона.']");
    private final By vkServicesLabel = By.xpath(".//*[@aria-label='Сервисы VK']");
    private final By languageSelectButton = By.xpath(".//*[contains(@class, 'menulink')]");

    public void signUpByPhoneNumber(String phone){
        $(phoneNumberField).shouldBe(visible).setValue(phone);
        $(nextButton).shouldBe(visible).click();
    } // регистрация через номер телефона (А как иначе?..)

    public void clickLanguageSelectButton(){
        $(languageSelectButton).shouldBe(visible).click();
    } // нажать кнопку выбора языка

    public void clickVkServicesLabel(){
        $(vkServicesLabel).shouldBe(visible).click();
    } // нажать кнопку Сервисы VK

    public String getErrorText(){
        return $(errorText).shouldBe(visible).innerText();
    } //вернуть текст ошибки

    public boolean checkSignUpPage() {
        $(phoneNumberField).shouldBe(visible);
        $(nextButton).shouldBe(visible);
        $(languageSelectButton).shouldBe(visible);
        $(vkServicesLabel).shouldBe(visible);
        return true;
    } //проверка нахождения на странице регистрации

}
