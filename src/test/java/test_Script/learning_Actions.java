package test_Script;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class learning_Actions {

    WebDriver driver;
    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;

    @BeforeClass
    public void setup() {
        // Create an object of Extent Reports
        extent = new ExtentReports();


        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Selenium_Actions.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("Host Name", "https://the-internet.herokuapp.com/ Application - Home Plan");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("User Name", "Test Team");
        spark.config().setDocumentTitle("herokuapp Application QA ");
        // Name of the report
        spark.config().setReportName("herokuapp Application Using Selenium testNG ");
        // Dark Theme
        spark.config().setTheme(Theme.DARK);
        logger = extent.createTest("Validate herokuapp Application Using Selenium testNG");


        System.out.println("##### Starting Chrome Browser ############");

        // ChromeOptions opt = new ChromeOptions();
        //  opt.addArguments("---read to allow-origins");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        logger.info("The Application launched successfully ...");


    }
     // Validate Click Functionality in Selenium
    @Test
    public void validate_Click_Functionality() {
        try {
            driver.navigate().to("https://the-internet.herokuapp.com");
            //Click on A/B Testing

            if (driver.findElement(By.xpath("//a[text()='A/B Testing']")).isDisplayed()) {
                driver.findElement(By.xpath("//a[text()='A/B Testing']")).click();
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
                if (driver.findElement(By.xpath("//h3[text()='A/B Test Variation 1']")).isDisplayed()) {
                    logger.info("Click functionality is working fine for A/B Testing...");

                }
            }


        } catch (Exception e) {
            System.out.println(e);
            logger.info("Click functionality is not working fine for A/B Testing...");
        }

    }

    // Validate CheckBoxes in Selenium
    // Handle CheckBoxes in Selenium Java

    @Test
    public void validate_CheckBox_Functionality() {
        try {
            driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
            // First Validate Checkbox 1 is not checked and 2 is checked ...


            boolean chkb1 = !driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected();
            boolean chkb2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected();

            if (chkb1 & chkb2) {

                logger.pass("By default checkbox 1 is not Selected...");
                logger.pass("By default checkbox 2 is  Selected...");
            } else {
                logger.fail("Checkbox functionality is not working");
            }


            // Check and uncheck the Checkboxes .....


            driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).click();
            driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).click();
            Thread.sleep(2000);

            chkb1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected();
            chkb2 = !driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected();
            if (chkb1 & chkb2) {
                logger.pass("After clicking checkbox 1 is now selected ...");
                logger.pass("After clicking checkbox 2 is now Unchecked...");
            } else {
                logger.fail("Checkbox functionality is not working");
            }


        } catch (Exception e) {
            System.out.println(e);
            logger.info("CheckBox functionality is not working ...");
        }

    }

    // Validating JavaScript PopUp Handle in Selenium
    // Handle WebPopUp Using Selenium
    @Test
    public void validate_Alert_Functionality() {
        String popuptext = null;
        try {
            driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
            if (driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).isDisplayed()) {
                driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

                Alert alert1 = driver.switchTo().alert();
                popuptext = alert1.getText();
                System.out.println("The java Script popup text is .....>" + popuptext);
                alert1.accept();
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
                if (driver.findElement(By.xpath("//p[@id='result']")).isDisplayed()) {
                    logger.info(" Click for JS Alert functionality is working fine ...");

                }
            }

            if (driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).isDisplayed()) {
                driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

                Alert alert2 = driver.switchTo().alert();
                popuptext = alert2.getText();
                System.out.println("The java Script popup text is .....>" + popuptext);

                alert2.dismiss();

                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
                if (driver.findElement(By.xpath("//p[@id='result']")).isDisplayed()) {
                    logger.info("Cancel  Click for JS Confirm functionality is working fine ...");

                }
            }
            if (driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).isDisplayed()) {
                driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

                Alert alert3 = driver.switchTo().alert();
                alert3.sendKeys("Chaitanya");
                popuptext = alert3.getText();
                System.out.println("The java Script popup text is .....>" + popuptext);
                alert3.accept();
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
                if (driver.findElement(By.xpath("//p[@id='result']")).isDisplayed()) {
                    logger.info("Giving text for JS Prompt functionality is working fine ...");

                }
            }


        } catch (Exception e) {
            System.out.println(e);
            logger.info(" JS Alert Functionality not working");
        }
    }

    // Validating select functionality to select a dropdown

    @Test
    public void validate_Select_Functionality() {
        try {
            driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
            //Click on A/B Testing

            if (driver.findElement(By.xpath("//select[@id ='dropdown']")).isDisplayed()) {

                Select dropDown = new Select(driver.findElement(By.xpath("//select[@id ='dropdown']")));

                //Select dropdown by the text which is available in the options
                dropDown.selectByVisibleText("Option 2");
                Thread.sleep(3000);


                // selecting dropdown using Index
                dropDown.selectByIndex(1);
                Thread.sleep(3000);


                //Selecting dropdown by the

                dropDown.selectByValue("2");
                Thread.sleep(3000);


            }


        } catch (Exception e) {
            System.out.println(e);
            logger.info("Click functionality is not working fine for A/B Testing...");
        }

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush();
    }


}
