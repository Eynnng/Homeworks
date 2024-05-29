import PageElement.NavigationBlockElement;
import PageObject.FriendsListPage;
import PageObject.MainPage;
import PageObject.AutorisationPage;
import PageObject.ProfilePage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Owner("Азамат")
@Feature("")

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
    @Tag("FriendRequests")
    @Description("Проверка отправки заявки в друзья по трем разным положениям")
    // Проверка статусов отправки заявки в друзья
    public void SendFriendRequestTest(){
        String name = "technopol40";
        String expectedStatusInFoundFriends = "Запрос отправлен";
        String expectedStatusInOutgoingFriendRequests = "Отменить заявку";
        String expectedStatusInProfile = "Запрос отправлен";
        String actualStatusInFoundFriends = new FriendsListPage()
                .findFriendByName(name)
                .addFirstPersonToFriends()
                .getFriendRequestStatusText();
        String actualStatusInOutgoingRequests = new FriendsListPage()
                .goToOutgoingFriendRequests()
                .outgoingRequestStatusText();
        String actualStatusInProfile = new FriendsListPage()
                .goToFirstProfileInOutgoingRequests()
                .getFriendRequestButtonText();
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
        FriendsListPage navigationBlockElement = new NavigationBlockElement()
                .openFriendsList()
                .goToOutgoingFriendRequests()
                .removeFirstOutgoingFriendRequest();
    }
}
