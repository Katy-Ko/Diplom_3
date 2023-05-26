package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    //Название формы "Вход"
    private static final By LOGIN_FORM_NAME = By.xpath(".//h2[text()='Вход']");
    //Поле email
    private static final By EMAIL_INPUT = By.xpath(".//input[@name = 'name']");
    //Поле пароль
    private static final By PASSWORD_INPUT = By.xpath(".//input[@name = 'Пароль']");
    //Кнопка "Зарегистрироваться"
    private static final By SIGN_UP_BUTTON = By.className("Auth_link__1fOlj");
    //Кнопка "Войти"
    private static final By SIGN_IN_BUTTON = By.xpath(".//button[text()='Войти']");
    //Кнопка "Восстановить пароль"
    private static final By RECOVER_PASSWORD = By.xpath(".//a[text()='Восстановить пароль']");
    //Надпись "Некорректный пароль"
    private static final By INCORRECT_PASSWORD = By.xpath(".//p[text()='Некорректный пароль']");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadFormName() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FORM_NAME));
    }

    public void setUserCredentials(String email, String password){
        driver.findElement(EMAIL_INPUT).click();
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    public boolean isIncorrectPasswordDisplayed(){
        WebElement incorrectPassword =
                new WebDriverWait(driver, 10).
                        until(ExpectedConditions.visibilityOfElementLocated(INCORRECT_PASSWORD));
        return incorrectPassword.isDisplayed();
    }

    public void clickSignUpButton(){
        driver.findElement(SIGN_UP_BUTTON).click();
    }

    public void clickRecoverButton(){
        driver.findElement(RECOVER_PASSWORD).click();
    }

    public boolean isLoginFormNameDisplayed(){
        WebElement loginFormName =
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FORM_NAME));
        return loginFormName.isDisplayed();
    }

}
