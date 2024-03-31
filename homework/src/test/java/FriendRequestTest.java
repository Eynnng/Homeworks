import PageObjects.FriendsListPage;
import PageObjects.MainPage;
import PageObjects.SignInPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.sleep;

public class FriendRequestTest extends BaseTest{
    @Test
    public void SendFriendRequestTest(){
        FriendsListPage friendsListPage = new FriendsListPage(driver);
        SignInPage autorize = new SignInPage(driver);
        MainPage friends = new MainPage(driver);
        String expected = "Запрос отправлен";
        String name = "Тутов Азамат";
        driver.get("https://ok.ru/");
        autorize.signIn();//здесь проходит авторизация
        friends.clickFriendsListButton();//переходим на страницу списка друзей
        sleep(5000);
        friendsListPage.findFriendByName(name);
        sleep(5000);
        friendsListPage.sendFriendsRequest(18);
        sleep(5000);
        Assertions.assertEquals(expected, friendsListPage.requestStatusText());
        //sleep добавил потому что без них тест падает
    }
}
