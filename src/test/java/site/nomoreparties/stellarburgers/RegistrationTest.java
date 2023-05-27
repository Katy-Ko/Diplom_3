package site.nomoreparties.stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import model.LoginPage;
import model.MainPage;
import model.SignUpPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static model.MainPage.PAGE_URL;

public class RegistrationTest {
    private WebDriver driver;
    private static UserClient userClient;
    private static UserCredentials userCredentials;
    private static User user;
    private static String token;

    @Before
    public void startUp() {
        userClient = new UserClient();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
    }

    @Test
    public void checkSuccessfulLoginWithValidCredentials(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForPersonalAccountButton();
        objMainPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadFormName();
        objLoginPage.clickSignUpButton();

        SignUpPage objSignUpPage = new SignUpPage(driver);
        objSignUpPage.waitForLoadFormName();
        objSignUpPage.setUserCredentialsToSignUp("Алексей - Царь гусей", "foo-foo@bk.ru", "000555000");

        objLoginPage.waitForLoadFormName();
        objLoginPage.setUserCredentials("foo-foo@bk.ru", "000555000");

        objMainPage.isMakeOrderButtonDisplayed();

    }

    @Test
    public void checkShortPasswordShowsError(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForPersonalAccountButton();
        objMainPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadFormName();
        objLoginPage.clickSignUpButton();

        SignUpPage objSignUpPage = new SignUpPage(driver);
        objSignUpPage.waitForLoadFormName();
        objSignUpPage.setUserCredentialsToSignUp("Алексей - Царь гусей", "foo-foo@bk.ru", "000");
        objLoginPage.isIncorrectPasswordDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public static void cleanUp(){
        userCredentials = new UserCredentials("foo-foo@bk.ru", "000555000");
        ValidatableResponse loginResponse = userClient.login(userCredentials);
        token = loginResponse.extract().path("accessToken");
        if (token != null) {
            userClient.delete(token);
        }
    }

}
