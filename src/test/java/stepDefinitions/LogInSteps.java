package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LogInSteps {
    WebDriver driver;

    @Given("Open the website (.*)")
    public void openWebsite(String website) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        //Open Google Chrome browser
        driver = new ChromeDriver();

        //Maximize browser's window
        driver.manage().window().maximize();

        //Go to the website
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("email and password were entered")
    public void logIn() {
        WebElement email = driver.findElement(By.className("form-control"));
        email.clear();
        email.sendKeys("LudmilaCzerwinska@armyspy.com");

        WebElement password = driver.findElement(By.className("js-child-focus"));
        password.clear();
        password.sendKeys("12345");
        password.submit();
    }

    @When("enter address information")
    public void addressInfo() {
        WebElement addAddress = driver.findElement(By.xpath("//*[@id='address-link']/span/i"));
        addAddress.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("First write an (.*)")
    public void writeAnAlias(String alias) {
        WebElement aliasElement = driver.findElement(By.name("alias"));
        aliasElement.sendKeys(alias);
    }

    @And("Then write your (.*)")
    public void containsAddress(String address) {
        WebElement addressElement = driver.findElement(By.name("address1"));
        addressElement.sendKeys(address);
    }

    @And("Then make up the (.*)")
    public void containsZipCode(String zipcode) {
        WebElement zipcodeElement = driver.findElement(By.name("postcode"));
        zipcodeElement.sendKeys(zipcode);
    }

    @And("What (.*) you live in")
    public void containsCity(String city) {
        WebElement cityElement = driver.findElement(By.name("city"));
        cityElement.sendKeys(city);
    }

    @And("What is your country")
    public void containsCountry() {
        Select countryElement = new Select(driver.findElement(By.name("id_country")));
        countryElement.selectByVisibleText("United Kingdom");
    }

    @And("Can i have you (.*) number")
    public void containsPhone(String phone) {
        WebElement phoneElement = driver.findElement(By.name("phone"));
        phoneElement.sendKeys(phone);
    }

    @Then("confirm entered data")
    public void confirmData() {
        WebElement confirmButton = driver.findElement(By.className("btn-primary"));
        confirmButton.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("delete the address")
    public void deleteAddress() {
        WebElement deleteButton = driver.findElement(By.xpath("//span[contains(.,'Delete')]"));
        deleteButton.click();

    }
}
