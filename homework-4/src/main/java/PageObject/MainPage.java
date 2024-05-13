package PageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage{


    public MainPage() {
        checkMainPage();
    }

    private final By momentsButton = By.xpath(".//*[contains(text(), 'Моменты')]");
    private final By profileButton = By.xpath(".//*[contains(@data-l, 'userPage')]");
    private final By feedButton = By.xpath(".//*[contains(@href, 'feed') and contains(@data-l, 'userMain')]");
    private final By musicButton = By.xpath(".//*[contains(@aria-label, 'Музыка')]");
    private final By friendsListButton = By.xpath(".//*[contains(@hrefattrs, 'User_Friends')]");
    private final By profilePhotosButton = By.xpath(".//*[contains(@data-l, 'userPhotos')]");
    private final By invisibleButton = By.xpath(".//input[@id='invisibleToggler']");
    private final By bookmarksButton = By.xpath(".//*[contains(@href, 'bookmarks')]");


    public void goToMyProfilePage(){
        $(profileButton).shouldBe(visible).click();
    } //нажать на кнопку профиля (переход на страницу профиля)

    public void goToFeedPage(){
        $(feedButton).shouldBe(visible).click();
    } //нажать на кнопку "Лента" (Переход на страницу ленты новостей)

    public void goToMomentsPage(){
        $(momentsButton).shouldBe(visible).click();
    } //нажать на кнопку "Увлечения" (Переход на страницу увлечений)

    public void goToFriendsListPage(){
        $(friendsListButton).shouldBe(visible).click();
    } //нажать на кнопку "Друзья" (Переход на страницу с друзьями)

    public void goToMyProfilePhotos(){
        $(profilePhotosButton).shouldBe(visible).click();
    } //нажать на кнопку "Фото" (Переход на страницу с фотогафиями профиля)

    public void switchInvisibleModeCheckBox(){
        $(invisibleButton).shouldBe(visible).click();
    } //(включить или выключить режим неведимки) или (переход на страницу покупки режима неведимки)

    public void goToBookmarksPage(){
        $(bookmarksButton).shouldBe(visible).click();
    } //нажать на кнопку "Закладки" (Переход на страницу с закладками)

    public void goToMusicPage(){
        $(musicButton).shouldBe(visible).click();
    } //нажать на кнопку "Музыка" (Переход на страницу с музыкой)


    public boolean checkMainPage(){
        $(momentsButton).shouldBe(visible);
        $(invisibleButton).shouldBe(visible);
        $(musicButton).shouldBe(visible);
        $(friendsListButton).shouldBe(visible);
        $(bookmarksButton).shouldBe(visible);
        return true;
    }//проверка нахождения на главной странице

}
