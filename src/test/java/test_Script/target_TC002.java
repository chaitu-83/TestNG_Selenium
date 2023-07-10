package test_Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class target_TC002 {

    public WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://target.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
   // @Test
    //public void walmart_logo_validation() {
     //   if (driver.findElement(By.xpath("(//div[@class='styles__SvgWrapper-sc-5okyqk-2 futvKe'])[4]")).isDisplayed()) {
      //      System.out.println("Ford logo is displayed=====> PASS");
     //   }


   // }

    @Test

    public void navigatetoCategoriespage() {
        try {
            WebElement deals = driver.findElement(By.xpath("//a[@aria-label='Deals']"));
            // creating object of an action class
            Actions act = new Actions(driver);
            act.moveToElement(deals).perform();

            // wait for 3 secs
            Thread.sleep(50);
            driver.findElement(By.xpath("//a[@aria-label='Deals']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


            driver.findElement(By.xpath("//span[text() = 'Top Deals']")).isDisplayed();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Clicking on Docker pro link
            driver.findElement(By.xpath("//span[text() = 'Top Deals']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Validate Docker Pro Header

            if (driver.findElement(By.xpath("//h1[text()='Top Deals']")).isDisplayed()); {
                System.out.println("User Successfully navigated to Docker pro page");
            }

        } catch(Exception e)
        {
            System.out.println(e);
        }
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();

    }



}
