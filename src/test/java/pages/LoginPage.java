package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void loginAs(String email, String password) {
        WebElement loginInput = driver.findElement(By.className("form-control"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);
    }

}
