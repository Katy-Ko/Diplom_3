package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {

    //Название формы "Восстановление пароля"
    private static final By FORGOT_PASSWORD_FORM = By.xpath(".//h2[text()='Восстановление пароля']");
    //Кнопка "Войти" под формой восстановления пароля
    private static final By SIGN_IN_BUTTON_UNDER_FORGOT_PASSWORD_FORM = By.xpath(".//a[text()='Войти']");

    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadFormName() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(FORGOT_PASSWORD_FORM));
    }

    public void clickSignInButton(){
        driver.findElement(SIGN_IN_BUTTON_UNDER_FORGOT_PASSWORD_FORM).click();
    }
}
