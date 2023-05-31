package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    //Название формы "Регистрация"
    private static final By SIGN_UP_FORM_NAME = By.xpath(".//h2[text()='Регистрация']");
    //Поле "Имя"
    private static final By NAME_INPUT = By.xpath(".//input[@name='name'][1]");
    //Поле Email
    private static final By EMAIL_INPUT_ON_SIGN_UP_PAGE = By.xpath(".//fieldset[2]/div/div/input");
    //Поле "Пароль"
    private static final By PASSWORD_INPUT_ON_SIGN_UP_PAGE = By.xpath(".//input[@name='Пароль']");
    //Кнопка "Зарегистрироваться"
    private static final By SIGN_UP_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    //Кнопка "Войти" под формой регистрации
    private static final By SIGN_IN_BUTTON_UNDER_SIGN_UP_FORM = By.xpath(".//a[text()='Войти']");

    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadFormName() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(SIGN_UP_FORM_NAME));
    }
    public void setUserCredentialsToSignUp(String name, String email, String password){
        driver.findElement(NAME_INPUT).click();
        driver.findElement(NAME_INPUT).sendKeys(name);
        driver.findElement(EMAIL_INPUT_ON_SIGN_UP_PAGE).click();
        driver.findElement(EMAIL_INPUT_ON_SIGN_UP_PAGE).sendKeys(email);
        driver.findElement(PASSWORD_INPUT_ON_SIGN_UP_PAGE).click();
        driver.findElement(PASSWORD_INPUT_ON_SIGN_UP_PAGE).sendKeys(password);
        driver.findElement(SIGN_UP_BUTTON).click();
    }

    public void clickSignInButton(){
        driver.findElement(SIGN_IN_BUTTON_UNDER_SIGN_UP_FORM).click();
    }

}
