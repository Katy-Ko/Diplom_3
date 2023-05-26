package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    //Кнопка "Выход"
    private static final By SIGN_OUT_BUTTON = By.xpath(".//button[text()='Выход']");

    private WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSignOutButton() {
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(SIGN_OUT_BUTTON));
    }

    public void clickSignOutButton(){
        driver.findElement(SIGN_OUT_BUTTON).click();
    }
}
