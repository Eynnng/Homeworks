package PageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage implements LoadablePage {

    private final By profileNameText = By.xpath(".//*[contains(@class,'user-profile-name')]");
    private final By sendMessageButton = By.xpath(".//*[text() = 'Написать']");
    private final By sendFriendRequest = By.xpath(".//*[text()='Добавить в друзья']");
    private final By friendRequestButton = By.xpath(".//*[contains(text(), 'Запрос отправлен')]");
    private final By friendsListButton = By.xpath(".//*[contains(@hrefattrs, 'User_Friends')]");
    private final By cancelFriendRequestButton = By.xpath(".//*[contains(text(), 'Отменить запрос')]");
    private final By profilePhotosButton = By.xpath(".//*[contains(@data-l, 'friendPhotos')]");
    private final By profileHobbyButton = By.xpath(".//a[contains(text(), 'Увлечения')]");

    public ProfilePage(){
        checkPage();
    }

    @Override
    public boolean checkPage(){
        $(profileNameText).shouldBe(visible);
        $(sendMessageButton).shouldBe(visible);
        $(profileHobbyButton).shouldBe(visible);
        $(profilePhotosButton).shouldBe(visible);
        return true;
    }//проверка нахождения на странице профиля

    public String getProfileNameText(){
        return $(profileNameText).shouldBe(visible).innerText();
    }//Получить текст имени профиля

    public String getFriendRequestButtonText(){
        return $(friendRequestButton).shouldBe(visible).text();
    }//Получить текст кнопки после отправления Заявки

    public void goToMessages(){
        $(sendMessageButton).shouldBe(visible).click();
    }//Перейти на страницу Сообщения с этим профилем

    public void goToFriendsListPage(){
        $(friendsListButton).shouldBe(visible).click();
    }//Перейти на страницу Друзей

    public void sendFriendRequest(){
        $(sendFriendRequest).shouldBe(visible).click();
    }//Отправить заявку в друзья

    public void goToProfilePhotos(){
        $(profilePhotosButton).shouldBe(visible).click();
    }//Перейти на страницу фотографий профиля

    public void cancelFriendRequest(){
        $(friendRequestButton).shouldBe(visible).click();
        $(cancelFriendRequestButton).shouldBe(visible).click();
    }//Отменить заявку в друзья

    public void goToProfileHobbies(){
        $(profileHobbyButton).shouldBe(visible).click();
    }//Посмотреть публикации в вкладке Увлечения профиля


}
