package stepDefination;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class InfyniTest {
    WebDriver driver;

    @Given("user launch infyni Website {string}")
    public void user_launch_infyni_website(String string) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(string);
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));


    }

    @Then("user validate infyni Logo")
    public void user_validate_infyni_logo() {
        driver.findElement(By.xpath("//img[@alt='infyni']")).isDisplayed();


    }

    @When("user click on LogIn Button")
    public void user_click_on_log_in_button() {
        driver.findElement(By.xpath("//a[text()='Login']")).click();


    }

    @Then("user navigate to SignIn page")
    public void user_navigate_to_sign_in_page() {
        driver.findElement(By.xpath("//h2[text()='Log in to your Account']")).isDisplayed();

    }

    @Then("validate remember me check box is not checked by default")
    public void validate_remember_me_check_box_is_not_checked_by_default() {
        Assert.assertTrue(!driver.findElement(By.xpath("//input[@name='RememberMe']")).isSelected());


    }

    @Then("user input incorrect {string} and {string}")
    public void user_input_incorrect_and(String userID, String password) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userID);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        // driver.findElement(By.xpath("//button[text()='Sign In']")).click();


        WebElement element = driver.findElement(By.xpath("//button[text()='Sign In']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);


    }

    @Then("user see error message says invalid credentials")
    public void user_see_error_message_says_invalid_credentials() {
        driver.findElement(By.xpath("//div[@class='error btns']")).isDisplayed();
    }


    @Then("user clicks on don't have a account SingUp link")
    public void user_clicks_on_don_t_have_a_account_sing_up_link() {
        driver.findElement(By.xpath("//a[text()='Sign Up']")).click();


    }

    @Then("user successfully navigated to SignUp page")
    public void user_successfully_navigated_to_sign_up_page() {
        driver.findElement(By.xpath("//span[contains(.,'All fields are mandatory')]")).isDisplayed();
        driver.quit();


    }


}
