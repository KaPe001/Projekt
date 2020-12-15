package pages;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.LogInSteps;

public class AddressPage {
    WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "address1")
    WebElement addressElement;

    @FindBy(name = "city")
    WebElement cityElement;

    @FindBy(name = "postcode")
    WebElement zipCodeElement;

    @FindBy(css = ".alert.alert-success")
    WebElement successInformation;

    @FindBy(className = "btn-primary")
    WebElement submit;

    public void setAddress(String address) {
        addressElement.click();
        addressElement.clear();
        addressElement.sendKeys(address);
    }

    public void submitUsersAddress() {
        submit.click();
    }

    public void setCity(String city) {
        cityElement.click();
        cityElement.clear();
        cityElement.sendKeys(city);
    }

    public void setZipCode(String zipcode) {
        zipCodeElement.click();
        zipCodeElement.clear();
        zipCodeElement.sendKeys(zipcode);
    }

    public String getUpdateInformation() {
        return successInformation.getText();

    }
}
