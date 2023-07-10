package stepDefination;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Docker {

    WebDriver driver;
    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;


    @Given("user launch the Docker website with Url as {string}")
    public void user_launch_the_docker_website_with_url_as(String string) {
        extent = new ExtentReports();


        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Cucumber_Docker.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("Host Name", "string");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("User Name", "Test Team");
        spark.config().setDocumentTitle("Docker Application QA ");
        // Name of the report
        spark.config().setReportName("Docker Application Using Cucumber testNG ");
        // Dark Theme
        spark.config().setTheme(Theme.DARK);
        logger = extent.createTest("Validate Docker Application Using Cucumber testNG");



        System.out.println("############ STARTING CHROME###################");
        System.out.println("############ DATE : 26 June 2023 ###################");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(string);
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        logger.info("The Application launched successfully ...");

    }


    @Then("user validate logo is present")
    public void user_validate_logo_is_present() {
        driver.findElement(By.xpath("//li[@class='logo']")).isDisplayed();
        logger.info("The Application launched successfully ...");
    }

    @Then("user check Sign in  link present")
    public void user_check_sign_in_link_present() {
        driver.findElement(By.xpath("(//a[text()='Sign In'])[1]")).isDisplayed();
        logger.info("user check Sign in  link present successfully ...");

    }

    @Then("user validate Get Started link")
    public void user_validate_get_started_link() {
        // driver.findElement(By.xpath("//a[text()='Get Started']")).click();
        driver.findElement(By.className("header_button")).isDisplayed();
        logger.info("user validate Get Started link successfully ...");


    }

    @Then("user validate the Products dropdown by Hovering it")
    public void user_validate_the_products_dropdown_by_hovering_it() {

        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("(//a[text()='Products'])[1]"));
        builder.moveToElement(element).build().perform();
        logger.info("user validate the Products dropdown by Hovering it successfully ...");

    }

    @Then("user scroll down to bottom of the page and validate {string}")
    public void user_scroll_down_to_bottom_of_the_page_and_validate(String string) {
        WebElement element = driver.findElement(By.xpath("//h2[text()='Accelerate your application development today.']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        logger.info("user scroll down to bottom of the page and validates the text ...");


    }




    @Then("user validate all SocialMedia links")
    public void user_validate_all_social_media_links() {
        driver.findElement(By.xpath("//img[@alt='facebook logo']")).isDisplayed();
        driver.findElement(By.xpath("//img[@alt='twitter logo']")).isDisplayed();
        driver.findElement(By.xpath("//img[@alt='youtube logo']")).isDisplayed();
        driver.findElement(By.xpath("//img[@alt='linkedin logo']")).isDisplayed();
        driver.findElement(By.xpath("//img[@alt='rss feed logo']")).isDisplayed();
        logger.info("User Validates all social  media links ...");
    }


    @Then("user close the Docker application")
    public void user_close_the_docker_application() {
        driver.quit();
        extent.flush();

    }


}








