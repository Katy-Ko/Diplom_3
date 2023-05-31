package site.nomoreparties.stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import model.LoginPage;
import model.MainPage;
import model.ProfilePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static model.MainPage.PAGE_URL;

public class SignOutTest {

    private WebDriver driver;
    private static UserClient userClient;
    private User user;
    private String token;

    @Before
    public void startUp() {
        userClient = new UserClient();
        user = UserGenerator.getDefaultCredentials();
        ValidatableResponse createResponse = userClient.create(user);
        token = createResponse.extract().path("accessToken");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
    }

    @Test
    public void checkSignOutFromPersonalProfile(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForPersonalAccountButton();
        objMainPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadFormName();
        objLoginPage.setUserCredentials("foo-foo@bk.ru", "000555000");

        objMainPage.isMakeOrderButtonDisplayed();
        objMainPage.clickPersonalAccountButton();

        ProfilePage objProfilePage = new ProfilePage(driver);
        objProfilePage.waitForSignOutButton();
        objProfilePage.clickSignOutButton();

        objLoginPage.isLoginFormNameDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();

        if (token != null) {
            userClient.delete(token);
        }
    }
}
