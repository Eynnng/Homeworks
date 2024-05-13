import PageObject.FriendsListPage;
import PageObject.MainPage;
import PageObject.AutorisationPage;
import PageObject.ProfilePage;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FriendRequestTest extends BaseTest{
    @BeforeEach
    // Вход в профиль и переход на страницу Друзей
    public void ligInAndGoToFriendsPage(){
        AutorisationPage autorisationPage = new AutorisationPage();
        autorisationPage.signIn();
        MainPage mainPage = new MainPage();
        mainPage.goToFriendsListPage();
    }

    @Test
    @Tag("Friend Requests")
    // Проверка статусов отправки заявки в друзья
    public void SendFriendRequestTest(){
        String name = "technopol40";
        String expectedStatusInFoundFriends = "Запрос отправлен";
        //Ожидаемая надпись в списке найденных пользователей после отправки заявки в друзья
        String expectedStatusInOutgoingFriendRequests = "Отменить заявку";
        //Ожидаемая надпись в списке исходящих заявок в друзья
        String expectedStatusInProfile = "Запрос отправлен";
        //Ожидаемая надпись в профиле пользователя после отправки заявки в друзья
        FriendsListPage friendsListPage = new FriendsListPage();
        friendsListPage.findFriendByName(name);
        friendsListPage.addFirstPersonToFriends();
        String actualStatusInFoundFriends = friendsListPage.getFriendRequestStatusText();
        //Фактическая надпись в списке найденных пользователей после отправки заявки в друзья
        friendsListPage.goToOutgoingFriendRequests();
        String actualStatusInOutgoingRequests = friendsListPage.outgoingRequestStatusText();
        //Фактическая надпись в списке исходящих заявок в друзья
        friendsListPage.goToFirstProfileInOutgoingRequests();
        ProfilePage profilePage = new ProfilePage();
        String actualStatusInProfile = profilePage.getFriendRequestButtonText();
        //Фактическая надпись в профиле пользователя после отправки заявки в друзья
        Assertions.assertAll("status",
                () -> assertEquals(expectedStatusInFoundFriends, actualStatusInFoundFriends),
                () -> assertEquals(expectedStatusInOutgoingFriendRequests, actualStatusInOutgoingRequests),
                () -> assertEquals(expectedStatusInProfile, actualStatusInProfile)
        );
    }
    @AfterEach
    // Отмена заявки в друзья
    public void CancelFriendRequest() {
        open(BASE_URL);
        MainPage mainPage = new MainPage();
        mainPage.goToFriendsListPage();
        FriendsListPage friendsListPage = new FriendsListPage();
        friendsListPage.goToOutgoingFriendRequests();
        friendsListPage.removeFirstOutgoingFriendRequest();
    }
}
