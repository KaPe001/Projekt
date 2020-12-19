package PrestaShop;


import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Shopping {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        //Open Google Chrome browser
        driver = new ChromeDriver();

        //Maximize browsers window
        driver.manage().window().maximize();

        //Go to the website
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void logIn() throws IOException {
        WebElement email = driver.findElement(By.className("form-control"));
        email.clear();
        email.sendKeys("LudmilaCzerwinska@armyspy.com");

        WebElement password = driver.findElement(By.className("js-child-focus"));
        password.clear();
        password.sendKeys("12345");
        password.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement logo = driver.findElement(By.className("img-responsive"));
        logo.click();

        WebElement tshirt = driver.findElement(By.xpath("//*[@id='content']/section/div/article[1]/div/a/img"));
        tshirt.click();

        Select size = new Select(driver.findElement(By.id("group_1")));
        size.selectByVisibleText("L");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement amount = driver.findElement(By.id("quantity_wanted"));
        amount.clear();
        amount.sendKeys("5");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement addToCard = driver.findElement(By.className("add-to-cart"));
        addToCard.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement checkout = driver.findElement(By.className("btn-primary"));
        checkout.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id='main']/div/div[2]/div[1]/div[2]/div/a"));
        proceedToCheckout.click();

        WebElement confirmAddress = driver.findElement(By.name("confirm-addresses"));
        confirmAddress.click();

        WebElement pickUp = driver.findElement(By.xpath("//*[@id='js-delivery']/div/div[1]/div[1]/div/span/span"));
        pickUp.click();

        WebElement continueButton = driver.findElement(By.name("confirmDeliveryOption"));
        continueButton.click();

        WebElement payment = driver.findElement(By.id("payment-option-1"));
        payment.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement conditionsCheckBox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        conditionsCheckBox.click();

        WebElement submitButton = driver.findElement(By.xpath("//*[@id='payment-confirmation']/div[1]/button"));
        submitButton.click();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss'-screenshot.png'").format(new Date());
        FileUtils.copyFile(scrFile, new File("screenshots/" + fileName));

    }

    @After
    public void tearDown() throws Exception {
        //Close the browser
        driver.quit();
    }
}
