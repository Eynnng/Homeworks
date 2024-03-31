package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    private By phoneNumberField = By.xpath("//*[@id=\"field_phone\"]");
    private By nextButton = By.xpath(".//input[@value='Далее']");
    private By errorText = By.xpath(".//*[text()='Неправильный номер телефона.']");
    public SignUpPage typePhoneNumber(String phone){
        driver.findElement(phoneNumberField).sendKeys(phone);
        return this;
    } // ввод номера телефона

    public void clickNextButton(){
        driver.findElement(nextButton).click();
    } // нажать кнопку "Далее"
    public String getErrorText(){
        return driver.findElement(errorText).getText();
    }

}
