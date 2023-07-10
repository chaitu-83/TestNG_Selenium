package stepDefination;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class infyni {
    WebDriver driver;


    @Given("user launch infyni application with URL as {string}")
    public void user_launch_infyni_application_with_url_as(String string) {

        System.out.println("############ STARTING CHROME###################");
        System.out.println("############ DATE : 26 June 2023 ###################");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(string);
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }


    @Then("user navigate to signup page")
    public void user_navigate_to_signup_page() {


        driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    @Then("user see Header as all fields are mandatory")
    public void user_see_header_as_all_fields_are_mandatory() {
        driver.findElement(By.xpath("//span[contains(.,'All fields are mandatory')]")).isDisplayed();

    }

    @Then("user fill First Name as {string}")
    public void user_fill_first_name_as(String string) {
        driver.findElement(By.id("first_name")).sendKeys(string);

    }

    @Then("user fill Last Name as {string}")
    public void user_fill_last_name_as(String string) {
        driver.findElement(By.id("last_name")).sendKeys(string);


    }

    @Then("user fill email address as {string}")
    public void user_fill_email_address_as(String string) {
        driver.findElement(By.id("email")).sendKeys(string);

    }

    @Then("user fill password as {string}")
    public void user_fill_password_as(String string) {
        driver.findElement(By.id("id_password")).sendKeys(string);

    }

    @Then("user fill confirm password as {string}")
    public void user_fill_confirm_password_as(String string) {
        driver.findElement(By.id("id_confirm_password")).sendKeys(string);


    }

    @Then("user close the infyni application")
    public void user_close_the_infyni_application() {
        driver.quit();
    }

}
