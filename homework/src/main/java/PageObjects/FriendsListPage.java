package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FriendsListPage {
    WebDriver driver;

    public FriendsListPage(WebDriver driver) {
        this.driver = driver;
    }
    private By findFriendsField = By.xpath("//input[@type='search']");
    private By searchFriends = By.xpath(".//span[contains(@class, 'right')]");
    public FriendsListPage findFriendByName(String name){
        driver.findElement(findFriendsField).sendKeys(name);
        driver.findElement(searchFriends).click();
        return this;
    }//найти друзей по имени
    public FriendsListPage sendFriendsRequest(int age){
        String friend = "//span[text()='"+ age + " лет']/../../..//span[@class]";
        By friendLocator = By.xpath(friend);
        driver.findElement(friendLocator).click();
        return this;
    }//отправить запрос дружбы по годам (первый подходящий из списка)
    public String requestStatusText(){
        String request = "//*[text()='Запрос отправлен']";
        By requestLocator = By.xpath(request);
        try {
            return driver.findElement(requestLocator).getText();
        }catch (Exception e){
            return "Запрос не отправлен";
        }
    }//Проверка отправки запроса дружбы (Тут все сделал в лоб, устал думать)
}
