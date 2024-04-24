package PageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class FriendsListPage {


    public FriendsListPage() {
        checkFriendsListPage();
    }

    private final By friendsField = By.xpath(".//input[@type='search']");
    private final By friendsListButton = By.xpath(".//*[contains(@hrefattrs, 'User_Friends')]");
    private final By searchFriendsButton = By.xpath(".//span[contains(@class, 'right')]");
    private final By friendsMenuMoreButton = By.xpath(".//button[contains(@id, 'FriendMenuMore')]");
    private final By outgoingFriendRequestButton = By.xpath(".//*[contains(text(), 'Исходящие заявки')]");
    private final By schoolFriendsButton = By.xpath(".//*[contains(@aria-label, 'Школьные друзья')]");
    private final By addFriendButton = By.xpath(".//*[contains(text(), 'Добавить в друзья')]"); //Добавление 1-го человека в друзья из списка предложенных
    private final By outgoingFriendRequestRemoveButton = By.xpath("//*[text()='Отменить заявку']"); //Кнопка отмены заявки у 1-го человека из списка Исходящих заявок
    private final By friendRequestStatusText = By.xpath(".//*[@class='lstp-t ellip']");//После обновления страницы где мы находим друзей мнеяется с "Запрос отправлен" на "Заявка отправлена"
    private final By outgoingFriendRequestProfileLink = By.xpath(".//*[@class='o']");//Ссылка на первый профиль в списке Исходящих заявок
    //После обновления страницы где мы находим друзей мнеяется с "Запрос отправлен" на "Заявка отправлена"

    public void goToOutgoingFriendRequests(){
        $(friendsMenuMoreButton).shouldBe(visible).click();
        $(outgoingFriendRequestButton).shouldBe(visible).click();
    }//Переход к списку исходящих заявок в друзья

    public void goToFriendsList(){
        $(friendsListButton).shouldBe(visible).click();
    }//Переход на страницу с друзьями

    public void addFirstPersonToFriends(){
        $(addFriendButton).shouldBe(visible).click();
    }//Отправить заявку в друзья первому из списка найденных пользователей

    public String outgoingRequestStatusText(){
        return $(outgoingFriendRequestRemoveButton).shouldBe(visible).innerText();
    }//Получить текст статуса заявки в друзья у первого из списка исходящих заявок

    public void removeFirstOutgoingFriendRequest(){
        $(outgoingFriendRequestRemoveButton).shouldBe(visible).click();
    }//Отменить заявку в друзья у первого из списка исходящих заявок

    public void findFriendByName(String name){
        $(friendsField).shouldBe(visible).setValue(name);
        sleep(2000);
        $(friendsField).shouldBe(visible).pressEnter();
    }//Найти друзей по имени

    public void goToFirstProfileInOutgoingRequests(){
        $(outgoingFriendRequestProfileLink).shouldBe(visible).click();
    }//Переход на страницу профиля первого из списка исходящих заявок

    public String getFriendRequestStatusText(){
        return $(friendRequestStatusText).shouldBe(visible).innerText();
    }//Получить текст статуса заявки

    public boolean checkFriendsListPage(){
        $(friendsField).shouldBe(visible);
        $(friendsMenuMoreButton).shouldBe(visible);
        $(searchFriendsButton).shouldBe(visible);
        $(schoolFriendsButton).shouldBe(visible);
        return true;//Проверка нахождения на странице "Друзья"
    }




    /*
            public void sendFriendsRequest(int age){
                String friend = "//span[text()='"+ age + " лет']/../../..//span[@class]";
                By friendLocator = By.xpath(friend);
                $(friendLocator).shouldBe(visible).click();
            }
            реализация добавления в друзья по имени и годам (первый подходящий из списка) (при надобности)
    */

}
