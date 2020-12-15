package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddressPage;

public class LogInSteps {
    AddressPage addresspage;
    WebDriver driver;

    @Given("Open the website (.*)")
    public void openWebsite(String website){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        //Open Google Chrome browser
        driver = new ChromeDriver();

        //Maximize browesers window
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
    public void writeAnAlias(){
}
    @And("Then write your (.*)")
    public void containsAddress(){
    }

    @And("Then make up the (.*)")
    public void containsZipCode() {
    }
    @And("What (.*) you live in")
    public void containsCity() {
    }

    @And("What is your (.*)")
    public void containsCountry(){
    }

    @And("Can i have you (.*) number")
    public void containsPhone(){
    }

    @And("close the browser")
    public void closeBrowser(){
        //driver.quit();
    }


    public void loginAs(String email, String password) {
        WebElement loginInput = driver.findElement(By.className("form-control"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);
}
}
