package PageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AutorisationPage {

    public AutorisationPage() {
        checkAutorisationPage();
    }

    private final String username = "technopol74";
    private final String password = "technopolisPassword";

    private final By signInButton = By.xpath(".//*[@value='Войти в Одноклассники']");
    private final By signUpButton = By.xpath(".//form//a[contains(text(),'Зарегистрироваться')]");
    private final By searchButton = By.xpath(".//button[@type = 'submit']");
    private final By usernameField = By.xpath(".//*[@id='field_email']");
    private final By passwordField = By.xpath(".//*[@id='field_password']");
    private final By searchField = By.xpath(".//*[contains(@placeholder, 'Поиск в ОК')]");
    private final By errorText = By.xpath(".//div[contains(@class,'login_error')]");
    private final By vkServicesLabel = By.xpath(".//*[@aria-label='Сервисы VK']");

    public void signIn(){
        this.typeUserName(username);
        this.typePassword(password);
        this.clickSignInButton();
    }

    public String getErrorText() {
        return $(errorText).innerText();
    }//получить текст ошибки

    public AutorisationPage clickSignInButton(){
        $(signInButton).shouldBe(visible).click();
        return this;
    }//нажать на кнопку "Войти в Одноклассники" (Переход на главную страницу)

    public void clickSignUp() {
        $(signUpButton).shouldBe(visible).click();
    } //нажать на кнопку "Зарегистрироваться" (Переход на страницу регистрации)

    public void searchByText(String text) {
        $(searchField).shouldBe(visible).setValue(text);
        $(searchButton).shouldBe(visible).click();
    } //Искать по тексту через поле "Поиск в ОК"

    public void clickVkServicesLabel() {
        $(vkServicesLabel).shouldBe(visible).click();
    } //нажать на кнопку "VK Сервисы"

    public AutorisationPage typeUserName(String username) {
        $(usernameField).shouldBe(visible).setValue(username);
        return this;
    } //ввод Логина/Номера телефона/Электронной почты

    public AutorisationPage typePassword(String password) {
        $(passwordField).shouldBe(visible).setValue(password);
        return this;
    } // ввод Пароля


    public boolean checkAutorisationPage() {
        $(signInButton).shouldBe(visible);
        $(signUpButton).shouldBe(visible);
        $(usernameField).shouldBe(visible);
        $(passwordField).shouldBe(visible);
        return true;
    }//проверка нахождения на странице авторизации

}
