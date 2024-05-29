package PageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import PageElement.UserCardElement;

public class FriendsListPage implements LoadablePage {

    private final By friendsField = By.xpath(".//input[@type='search']");
    private final By addFriendButton = By.xpath(".//*[contains(text(), 'Добавить в друзья')]"); //Добавление 1-го человека в друзья из списка предложенных
    private final By searchFriendsButton = By.xpath(".//span[contains(@class, 'right')]");
    private final By schoolFriendsButton = By.xpath(".//*[@aria-label='Школьные друзья']");
    private final By friendsMenuMoreButton = By.xpath(".//button[contains(@id, 'FriendMenuMore')]");
    private final By friendRequestStatusText = By.xpath(".//span[@class='lstp-t ellip']");
    //После обновления страницы где мы находим друзей мнеяется с "Запрос отправлен" на "Заявка отправлена"
    private final By outgoingFriendRequestButton = By.xpath(".//*[contains(text(), 'Исходящие заявки')]");
    private final By outgoingFriendRequestProfileLink = By.xpath(".//*[@class='o']");//Ссылка на первый профиль в списке Исходящих заявок
    private final By outgoingFriendRequestRemoveButton = By.xpath(".//*[text()='Отменить заявку']"); //Кнопка отмены заявки у 1-го человека из списка Исходящих заявок

    private final UserCardElement userCard = new UserCardElement();

    public FriendsListPage() {
        checkPage();
    }

    @Override
    public boolean checkPage(){
        $(friendsField).shouldBe(visible);
        $(friendsMenuMoreButton).shouldBe(visible);
        $(searchFriendsButton).shouldBe(visible);
        return true;
    }//Проверка нахождения на странице "Друзья"

    public FriendsListPage goToOutgoingFriendRequests(){
        $(friendsMenuMoreButton).shouldBe(visible).click();
        sleep(2000);
        $(outgoingFriendRequestButton).shouldBe(visible).click();
        return this;
    }//Переход к списку исходящих заявок в друзья

    public FriendsListPage addFirstPersonToFriends(){
        return userCard.addUserToFriends();
    }//Отправить заявку в друзья первому из списка найденных пользователей

    public String outgoingRequestStatusText(){
        return $(outgoingFriendRequestRemoveButton).shouldBe(visible).text();
    }//Получить текст статуса заявки в друзья у первого из списка исходящих заявок

    public FriendsListPage removeFirstOutgoingFriendRequest(){
        sleep(2000);
        $(outgoingFriendRequestRemoveButton).shouldBe(visible).click();
        return this;
    }//Отменить заявку в друзья у первого из списка исходящих заявок

    public FriendsListPage findFriendByName(String name){
        $(friendsField).shouldBe(visible).click();
        $(friendsField).shouldBe(visible).setValue(name);
        sleep(2000);
        $(friendsField).shouldBe(visible).click();
        sleep(2000);
        return this;
    }//Найти друзей по имени

    public ProfilePage goToFirstProfileInOutgoingRequests(){
        $(outgoingFriendRequestProfileLink).shouldBe(visible).click();
        return new ProfilePage();
    }//Переход на страницу профиля первого из списка исходящих заявок

    public String getFriendRequestStatusText(){
        return $(friendRequestStatusText).shouldBe(visible).innerText();
    }//Получить текст статуса заявки






    /*
            public void sendFriendsRequest(int age){
                String friend = "//span[text()='"+ age + " лет']/../../..//span[@class]";
                By friendLocator = By.xpath(friend);
                $(friendLocator).shouldBe(visible).click();
            }
            реализация добавления в друзья по имени и годам (первый подходящий из списка) (при надобности)
    */

}
