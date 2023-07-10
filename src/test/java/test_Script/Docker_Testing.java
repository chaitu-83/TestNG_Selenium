package test_Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import PageObject.Docker_Home;

public class Docker_Testing {

    public WebDriver driver;
    public Docker_Home home;

    @BeforeClass
    @Parameters({"url"})
    public void setup(String url) {
        home = new Docker_Home();
        //Instantiate a ChromeDriver Class.
        driver = new ChromeDriver();

        // Launch Website
        driver.get(url);

        // Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Parameters({"username","password"})
    public void docker_logo_validation(String username,String password) {
        // Validate Google Logo
        if (driver.findElement(home.Logo()).isDisplayed()) {
            System.out.println("Docker Logo is  Displayed ===== Pass");
        }

        if (driver.findElement(home.signIn_Link()).isDisplayed()) {
            System.out.println("Docker Sign In is  Displayed ===== Pass");
           // driver.findElement(By.xpath("(//a[text()='Sign In'])[1]"));
        }
        System.out.println("username is ===> "+username);
        System.out.println("password is ===> "+password);

        // If anything goes wrong in the Xpath gives Exception "No such element"

    }
    @Test
    public void docker_SignIn_validation() {
        // Validate Sign In Logo
        if (driver.findElement(home.signIn_Link()).isDisplayed()) {
            System.out.println("Docker Sign In is  Displayed ===== Pass");
        }
        // If anything goes wrong in the Xpath gives Exception "No such element"

    }


    @Test
    public void navigateToDockerPage() {
        // Do mouse over on Products Header menu link
        try {
            WebElement products = driver.findElement(By.xpath("(//a[text()='Products'])[1]"));
            // creating object of an action class
            Actions act = new Actions(driver);
            act.moveToElement(products).perform();
            // wait for 3 secs
            Thread.sleep(3000);

            // Clicking on Docker pro link
            driver.findElement(By.xpath("(//a[text()='Docker Pro'])[1]")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Validate Docker Pro Header

            if (driver.findElement(By.xpath("//h1[text()='Docker Pro']")).isDisplayed())
            {
                System.out.println("User Successfully navigated to Docker pro page");
            }

        } catch (Exception e) {

            System.out.println(e);


        }


    }




    @AfterClass
    public void tearDown()
    {
        driver.quit();

    }
}


