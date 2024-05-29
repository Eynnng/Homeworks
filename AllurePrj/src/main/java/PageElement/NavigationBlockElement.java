package PageElement;

import PageObject.FriendsListPage;
import PageObject.LoadablePage;
import PageObject.ProfilePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class NavigationBlockElement implements LoadablePage {
    private final By profileButton = By.xpath(".//*[@data-l='t,userPage']");
    private final By feedButton = By.xpath(".//*[@data-l='t,userMain']");
    private final By hobbiesButton = By.xpath(".//*[@data-l='t,hobby']");
    private final By friendsButton = By.xpath(".//*[@data-l='t,userFriend']");
    private final By photosButton = By.xpath(".//*[@data-l='t,userPhotos']");
    private final By groupsButton = By.xpath(".//*[@data-l='t,userAltGroup']");
    private final By gamesButton = By.xpath(".//*[@data-l='t,appsShowcaseHD']");
    private final By giftsButton = By.xpath(".//*[@data-l='t,giftsFront']");
    private final By recommendationButton = By.xpath(".//*[@data-l='t,discovery']");

    @Override
    public boolean checkPage(){
        $(profileButton).shouldBe(visible);
        $(feedButton).shouldBe(visible);
        $(hobbiesButton).shouldBe(visible);
        $(friendsButton).shouldBe(visible);
        $(photosButton).shouldBe(visible);
        return true;
    }

    public FriendsListPage openFriendsList(){
        $(friendsButton).shouldBe(visible).click();
        return new FriendsListPage();
    }

}
