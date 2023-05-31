package site.nomoreparties.stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.LoginPage;
import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static model.MainPage.PAGE_URL;

public class ReturnToMainPageTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
    }

    @Test
    public void checkReturnViaConstructorButton(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForPersonalAccountButton();
        objMainPage.clickPersonalAccountButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadFormName();

        objMainPage.clickConstructorButton();
        objMainPage.isConstructorTextDisplayed();
    }

    @Test
    public void checkReturnViaAppLogo(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForPersonalAccountButton();
        objMainPage.clickPersonalAccountButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadFormName();

        objMainPage.clickAppLogo();
        objMainPage.isConstructorTextDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
