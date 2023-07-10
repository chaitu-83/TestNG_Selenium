package stepDefination;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;


public class Google {
    WebDriver driver;
    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;



    @Given("User launch Google URL")
    public void user_launch_google_url() {


        System.out.println("############ STARTING CHROME###################");
        System.out.println("############ DATE : 26 June 2023 ###################");
      //  ChromeOptions opt = new ChromeOptions();
      //  opt.addArguments("--remote-allow-origins=*");
      //  WebDriverManager.chromedriver().setup();

        extent = new ExtentReports();


        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Cucumber_Google.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("Host Name", "https://www.google.com/ Application - Home Plan");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("User Name", "Test Team");
        spark.config().setDocumentTitle("Google Application QA ");
        // Name of the report
        spark.config().setReportName("Google Application Using Cucumber testNG ");
        // Dark Theme
        spark.config().setTheme(Theme.DARK);
        logger = extent.createTest("Validate Google Application Using Selenium testNG");


        System.out.println("##### Starting Chrome Browser ############");


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        logger.info("The Application launched successfully ...");




    }


    @Then("user see google logo")
    public void user_see_google_logo() {

        driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
        logger.info("Google logo is Displayed");
    }
    @Then("user validate title as Google")
    public void user_validate_title_as_google() {
        Assert.assertEquals(driver.getTitle() , "Google");
        logger.info("User Validates title as Google");
    }
    @When("user type Automation testing in Google search box")
    public void user_type_automation_testing_in_google_search_box() {
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Automation testing");
        logger.info("User type automation testing in Google search box");
    }
    @Then("user see Search result")
    public void user_see_search_result() {


    }


    @Then("user close the application")
    public void user_close_the_application() {
        driver.quit();
        extent.flush();
    }

}
