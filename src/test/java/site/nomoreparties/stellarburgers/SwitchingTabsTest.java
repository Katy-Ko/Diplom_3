package site.nomoreparties.stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static model.MainPage.PAGE_URL;

public class SwitchingTabsTest {

    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
    }

    @Test
    public void checkSaucesTabOpens(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForPersonalAccountButton();
        objMainPage.clickSaucesTab();
        objMainPage.isSaucesHeaderDisplayed();
    }

    @Test
    public void checkFillingsTabOpens(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForPersonalAccountButton();
        objMainPage.clickFillingsTab();
        objMainPage.isFillingsHeaderDisplayed();
    }

    @Test
    public void checkSwitchBetweenFillingsAndBuns(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForPersonalAccountButton();
        objMainPage.clickFillingsTab();
        objMainPage.clickBunsTab();
        objMainPage.isBunsHeaderDisplayed();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
