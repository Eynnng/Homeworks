package PageElement;

import PageObject.FriendsListPage;
import PageObject.LoadablePage;
import PageObject.ProfilePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class UserCardElement implements LoadablePage {

    private final By addFriendCardButton = By.xpath(".//*[text()='Добавить в друзья']");
    private final By cardImageButton = By.xpath(".//a[@class='dblock']");
    private final By cardNameAddress = By.xpath(".//a[contains(@class,'name')]");
    private final By cardFriendRequestStatusText = By.xpath(".//span[@class='lstp-t ellip']");

    @Override
    public boolean checkPage(){
        $(cardImageButton).shouldBe(visible);
        $(cardNameAddress).shouldBe(visible);
        return true;
    }

    public FriendsListPage addUserToFriends(){
        $(addFriendCardButton).shouldBe(visible).click();
        return new FriendsListPage();
    }//Отправить заявку в друзья первому из списка найденных пользователей

    public ProfilePage goToUserPageViaName(){
        $(cardNameAddress).shouldBe(visible.because("Username should be visible to see name and go to user profile")).click();
        return new ProfilePage();
    }

    public ProfilePage goToUserPageViaPhoto(){
        $(cardImageButton).shouldBe(visible.because("Image should be visible to see and go to user profile")).click();
        return new ProfilePage();
    }

    public String getFriendRequestText(){
        return $(cardFriendRequestStatusText).shouldBe(visible.because("Request status should be visible to find out the status")).text();
    }
}
