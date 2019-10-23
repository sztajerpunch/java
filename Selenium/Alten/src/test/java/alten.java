import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

// Created by Rafał Walecki [16.06.2019]
// to do in next verision:
// add global wait/sleep method to prevent Thread.sleep(2000) repetition
// move scenarios to separeted classes / make page objects class
// move fixed and sensitive values like password to .properties file

public class alten {
    WebDriver driver;

    @Before
    public void Startup() {

        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test //Scenario 1 - Creata an account
    public void CreateAnAccount() throws InterruptedException {

        String email = "rafal+" + Math.floor(Math.random() * 11111) + "@gmail.com";

        WebElement SignIn = driver.findElement(By.cssSelector("[title=\"Log in to your customer account\"]"));
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title=\"Log in to your customer account\"]")));
        SignIn.click();
        Thread.sleep(2000);

        WebElement emailAddressField = driver.findElement((By.id("email_create")));
        emailAddressField.sendKeys(email);

        WebElement CreateAnAccount = driver.findElement(By.id("SubmitCreate"));
        CreateAnAccount.click();
        Thread.sleep(2000);

        WebElement genderCheckbox = driver.findElement(By.id("id_gender1"));
        genderCheckbox.click();
        Thread.sleep(2000);

        driver.findElement(By.id("customer_firstname")).sendKeys("Jan");
        Thread.sleep(2000);

        driver.findElement(By.id("customer_lastname")).sendKeys("Kowalski");
        Thread.sleep(2000);

        driver.findElement(By.id("passwd")).sendKeys("Haslo1989");
        Thread.sleep(2000);

        driver.findElement(By.id("days")).sendKeys("10");
        Thread.sleep(2000);

        driver.findElement(By.id("months")).sendKeys("June");
        Thread.sleep(2000);

        driver.findElement(By.id("years")).sendKeys("1989");
        Thread.sleep(2000);

        driver.findElement(By.id("company")).sendKeys("HP");
        Thread.sleep(2000);

        driver.findElement(By.id("address1")).sendKeys("Złota");
        Thread.sleep(2000);

        driver.findElement(By.id("city")).sendKeys("Warsaw");
        Thread.sleep(2000);

        driver.findElement(By.id("postcode")).sendKeys("01766");
        Thread.sleep(2000);

        driver.findElement(By.id("id_country")).sendKeys("-");
        Thread.sleep(2000);

        driver.findElement(By.id("id_country")).sendKeys("United States");
        Thread.sleep(2000);

        driver.findElement(By.id("id_state")).sendKeys("Alabama");
        Thread.sleep(2000);

        driver.findElement(By.id("phone")).sendKeys("987664335");
        Thread.sleep(2000);

        driver.findElement(By.id("phone_mobile")).sendKeys("987664335");
        Thread.sleep(2000);

        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys("testAlten");
        Thread.sleep(2000);

        driver.findElement(By.id("submitAccount")).click();
        Thread.sleep(2000);
    }

    @Test //Scenario 2 - Log in using created account
    public void LogInWithValidData() throws InterruptedException {

        WebElement SignIn = driver.findElement(By.cssSelector("[title=\"Log in to your customer account\"]"));
        SignIn.click();
        Thread.sleep(2000);

        WebElement LoginField = driver.findElement(By.name("email"));
        LoginField.click();
        LoginField.sendKeys("sztajerpunch@wp.pl");
        Thread.sleep(2000);

        WebElement PassField = driver.findElement(By.name("passwd"));
        PassField.click();
        PassField.sendKeys("Haslo1989");
        Thread.sleep(2000);

        WebElement SumbitLogin = driver.findElement(By.id("SubmitLogin"));
        SumbitLogin.click();
    }

    @Test //Scenario 3 - Log in and buy something
    public void BuySomething() throws InterruptedException {

        driver.get("http://automationpractice.com/index.php?id_category=5&controller=category");
        Thread.sleep(2000);

        WebElement SizeM = driver.findElement(By.id("layered_id_attribute_group_1"));
        SizeM.click();
        Thread.sleep(2000);

        WebElement selectProductSort = driver.findElement(By.id("selectProductSort"));
        selectProductSort.sendKeys("Price: Lowest first");
        Thread.sleep(2000);

        WebElement ListView = driver.findElement(By.id("list"));
        ListView.click();
        Thread.sleep(2000);

        WebElement AddToCart = driver.findElement(By.cssSelector("[title=\"Add to cart\"]"));
        AddToCart.click();
        Thread.sleep(2000);

        WebElement ProceedToCheckout = driver.findElement(By.cssSelector("[title=\"Proceed to checkout\"]"));
        ProceedToCheckout.click();
        Thread.sleep(2000);

        WebElement QuantityUp = driver.findElement(By.id("cart_quantity_up_1_1_0_0"));
        QuantityUp.click();
        Thread.sleep(2000);

        driver.get("http://automationpractice.com/index.php?controller=order&step=1");
        Thread.sleep(2000);

        WebElement LoginField = driver.findElement(By.name("email"));
        LoginField.click();
        LoginField.sendKeys("sztajerpunch@wp.pl");
        Thread.sleep(2000);

        WebElement PassField = driver.findElement(By.name("passwd"));
        PassField.click();
        PassField.sendKeys("Haslo1989");
        Thread.sleep(2000);

        WebElement SumbitLogin = driver.findElement(By.id("SubmitLogin"));
        SumbitLogin.click();
        Thread.sleep(2000);

        WebElement ProceedToShipping = driver.findElement(By.name("processAddress"));
        ProceedToShipping.click();
        Thread.sleep(2000);

        WebElement AgreeTerms = driver.findElement(By.id("cgv"));
        AgreeTerms.click();
        Thread.sleep(2000);

        WebElement ProceedToCarrier = driver.findElement(By.name("processCarrier"));
        ProceedToCarrier.click();
        Thread.sleep(2000);

        WebElement PayByBankWire = driver.findElement(By.cssSelector("[title=\"Pay by bank wire\"]"));
        PayByBankWire.click();
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
