package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage{
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By friendsListButton = By.xpath("//*[@id=\"hook_Block_Navigation\"]//div[4]/a");

    public FriendsListPage clickFriendsListButton(){
        driver.findElement(friendsListButton).click();
        return new FriendsListPage(driver);
    } //нажать на кнопку "Друзья" (Переход на старницу с Друзьями)

}
