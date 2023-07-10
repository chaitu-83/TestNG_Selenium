package test_Script;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;


public class print_All_Links {


    //helps to generate the logs in the test report.
    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;
    public WebDriver driver;


    @BeforeClass
    public void setup() {


// initialize the HtmlReporter


// Create an object of Extent Reports
        extent = new ExtentReports();

      //  Path path = new File(getClass()
       //         .getResource("/<path to the image in your build/classes folder>")
       //         .getFile()).toPath();


        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/flipkartprintlinks.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("Host Name", "Chaitanya-QATester");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Test Team");
        spark.config().setDocumentTitle("Amazon HomePage Testing ");
        // Name of the report
        spark.config().setReportName("Amazon Application Using Selenium testNG ");
         // Dark Theme
        spark.config().setTheme(Theme.STANDARD);
        logger = extent.createTest("Validate  Amazon Checkout Application Using Selenium testNG");

         driver = new ChromeDriver();

        // Launch Website
        driver.get("https://filpkart.com");

        // Maximize the browser
        driver.manage().window().maximize();


    }

    @Test
    public void print_all_links() {

        try {
            int link_count = driver.findElements(By.xpath("//a")).size();
            for (int i = 1; i < link_count; i++) {


                String link = driver.findElement(By.xpath("(//a)[" + i + "]")).getText();
                // System.out.println("The Link Name is======>"+ link);
                String href = driver.findElement(By.xpath("(//a)[" + i + "]")).getAttribute("href");
                // System.out.println("The Link Name Is=====>"+ href);
                String innerHTML = driver.findElement(By.xpath("(//a)[" + i + "]")).getAttribute("innerHTML");
                System.out.println("The link name is==>" + innerHTML);
                logger.info(link);
                logger.info(href);

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @AfterClass
    public void quit_session()
    {

        driver.quit();
        extent.flush();

    }
}
