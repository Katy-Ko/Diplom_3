package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    //Кнопка "Личный кабинет"
    private static final By PERSONAL_ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    //Кнопка "Войти в аккаунт"
    private static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка "Оформить заказ"
    private static final By MAKE_ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");
    //Текст конструктора "Соберите бургер"
    private static final By MAKE_BURGER_TEXT = By.xpath(".//h1[text()='Соберите бургер']");
    //Кнопка "Конструктор"
    private static final By CONSTRUCTOR_BUTTON = By.xpath(".//p[text()='Конструктор']");
    //Логотип
    private static final By APP_LOGO = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    //Вкладка "Булки"
    private static final By BUNS_TAB = By.xpath(".//span[text()='Булки']");
    //Вкладка "Соусы"
    private static final By SAUCES_TAB = By.xpath(".//span[text()='Соусы']");
    //Вкладка "Начинки"
    private static final By FILLINGS_TAB = By.xpath(".//span[text()='Начинки']");
    //Активная вкладка
    private static final By CURRENT_TAB = By.className("tab_tab_type_current__2BEPc");



    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPersonalAccountButton() {
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(PERSONAL_ACCOUNT_BUTTON));
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public boolean isMakeOrderButtonDisplayed() {
        WebElement makeOrderButton =
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.visibilityOfElementLocated(MAKE_ORDER_BUTTON));
        return makeOrderButton.isDisplayed();
    }

    public void clickPersonalAccountButton(){
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }

    public boolean isConstructorTextDisplayed(){
        WebElement makeBurgerText =
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.visibilityOfElementLocated(MAKE_BURGER_TEXT));
        return makeBurgerText.isDisplayed();
    }

    public void clickAppLogo(){
        driver.findElement(APP_LOGO).click();
    }

    public void clickConstructorButton(){
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }

    public void clickBunsTab(){
        driver.findElement(BUNS_TAB).click();
    }

    public void clickSaucesTab(){
        driver.findElement(SAUCES_TAB).click();
    }

    public void clickFillingsTab(){
        driver.findElement(FILLINGS_TAB).click();
    }

    public String getCurrentTabName(){
        new WebDriverWait(driver, 5);
        return driver.findElement(CURRENT_TAB).getText();
    }

}
