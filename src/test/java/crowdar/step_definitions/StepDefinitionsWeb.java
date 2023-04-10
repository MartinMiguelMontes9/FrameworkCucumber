package crowdar.step_definitions;

import com.crowdar.pages.HomePage;
import com.crowdar.pages.LoginPage;
import com.crowdar.utilities.ConfigReader;
import com.crowdar.utilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StepDefinitionsWeb {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ConfigReader configReader;

    @Before
    public void setUp() {
        configReader = new ConfigReader();
        driver = DriverFactory.getDriver(configReader.getProperty("browser"));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();

    }

    @Given("the user is on the login page$")
    public void the_user_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");;
    }

    @Given("the user is logged in whit a valid user {string} and pass {string}")
    public void the_user_is_login_(String username,String password) {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @When("the user is on the product page")
    public void the_user_is_on_product_page() {
        homePage.clickAddCartBrn();
        homePage.clickCartBrn();
    }

    @When("the user clicks on the Add to Cart button")
    public void the_user_clicks_on_Add_Cart_button() {
        Assert.assertTrue("Se muestra la pagina principal",homePage.getHomeTittle());
    }

    @When("the user enters the username {string} and the password valid {string}")
    public void the_user_enters_the_username_and_the_password(String username,String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user enters the username {string} and the password {string} blocked")
    public void the_user_enters_the_username_and_the_password_blocked(String username,String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @When("the user clicks on the Remove button for a specific product")
    public void user__Remove_product() {
        homePage.clickRemoveCartBrn();
    }

    @Then("the user should see the home page")
    public void the_user_should_see_the_page() {
        Assert.assertTrue("Se muestra la pagina principal",homePage.getHomeTittle());
    }
    @Then("the user should see an error message about as blocked")
    public void the_user_should_see_error_blocked() {
        Assert.assertTrue("Se muestra la pagina principal",loginPage.getErrorBlocked());
    }

    @Then("the product should be added to the shopping cart")
    public void the_product_should_be_added_to_cart() {
        Assert.assertTrue("No se agrego el producto",homePage.getItemCart());
    }

    @Then("the product should be removed from the shopping cart")
    public void the_product_should_be_removed() {
        Assert.assertFalse("Se muestra la pagina principal",homePage.getItemCart());
    }


    @AfterStep
    public void captureScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            InputStream stream = new ByteArrayInputStream(screenshot);
            Allure.addAttachment("Screenshot on Failure", "image/png", stream, "png");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}