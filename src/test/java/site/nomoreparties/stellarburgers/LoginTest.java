package site.nomoreparties.stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import model.ForgotPasswordPage;
import model.LoginPage;
import model.MainPage;
import model.SignUpPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static model.MainPage.PAGE_URL;

public class LoginTest {

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
    public void checkLoginViaLoginButton(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForPersonalAccountButton();
        objMainPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadFormName();
        objLoginPage.setUserCredentials("foo-foo@bk.ru", "000555000");

        objMainPage.isMakeOrderButtonDisplayed();
    }

    @Test
    public void checkLoginViaPersonalAccountButton(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForPersonalAccountButton();
        objMainPage.clickPersonalAccountButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadFormName();
        objLoginPage.setUserCredentials("foo-foo@bk.ru", "000555000");

        objMainPage.isMakeOrderButtonDisplayed();
    }

    @Test
    public void checkLoginViaSignInButton_onSignUpPage(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForPersonalAccountButton();
        objMainPage.clickPersonalAccountButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadFormName();
        objLoginPage.clickSignUpButton();

        SignUpPage objSignUpPage = new SignUpPage(driver);
        objSignUpPage.waitForLoadFormName();
        objSignUpPage.clickSignInButton();

        objLoginPage.waitForLoadFormName();
        objLoginPage.setUserCredentials("foo-foo@bk.ru", "000555000");

        objMainPage.isMakeOrderButtonDisplayed();
    }

    @Test
    public void checkLoginViaSignInButton_onForgotPasswordPage(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForPersonalAccountButton();
        objMainPage.clickPersonalAccountButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadFormName();
        objLoginPage.clickRecoverButton();

        ForgotPasswordPage objForgotPassword = new ForgotPasswordPage(driver);
        objForgotPassword.waitForLoadFormName();
        objForgotPassword.clickSignInButton();

        objLoginPage.waitForLoadFormName();
        objLoginPage.setUserCredentials("foo-foo@bk.ru", "000555000");

        objMainPage.isMakeOrderButtonDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
        if (token != null) {
            userClient.delete(token);
        }
    }


}
