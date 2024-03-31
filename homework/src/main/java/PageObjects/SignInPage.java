package PageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;


public class SignInPage {
    private final WebDriver driver;

    public void CheckSignInPage() {

    }

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By signInButton = By.xpath(".//*[@value='Войти в Одноклассники']");
    private final By signUpButton = By.xpath(".//form//a[contains(text(),'Зарегистрироваться')]");
    private final By userNameField = By.xpath(".//*[@id=\"field_email\"]");
    private final By passwordField = By.xpath(".//*[@id=\"field_password\"]");
    private final By errorText = By.xpath(".//div[contains(@class,'login_error')]");

    public String getErrorText() {
        return driver.findElement(errorText).getText();
    }

    public void signIn() {
        typePassword("technopolisPassword");
        typeUserName("technopol74");
        clickSignIn();
    }

    public boolean checkSignInButton() {
        List<WebElement> signInButtons = driver.findElements(signInButton);
        return signInButtons.isEmpty();
    }//проверка наличия кнопки логина

    public MainPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new MainPage(driver);
    } //нажать на кнопку "Войти в Одноклассники" (Переход на главную страницу)

    public SignUpPage clickSignUp() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    } //нажать на кнопку "Зарегистрироваться" (Переход на страницу регистрации)

    public SignInPage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    } //ввод Логина/Номера телефона/Электронной почты

    public SignInPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    } // ввод Пароля

}
