package test_Script;
import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import support.Support;


import java.time.Duration;

public class ford_testing {
    public WebDriver driver;
    public Support obj;

    @BeforeClass
    public void setup() throws Exception {
        obj = new Support();
        //Instantiate a ChromeDriver Class.
        driver = new ChromeDriver();

        // Launch Website
        driver.get(obj.read_properties_file("url"));

        // Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void ford_logo_validation() {
        if (driver.findElement(By.xpath("(//span[@class='brand-logo'])[1]")).isDisplayed()) {
            System.out.println("Ford logo is displayed=====> PASS");
        }

    }

    @Test
    @Parameters({"user","password"})

    public void fordsigninValidation(String user, String password) {
        try {

            if (driver.findElement(By.xpath("(//span[@class='user-menu-icon fgx-icon icon-account-outline fgx-icon--20'])[2]")).isDisplayed()) {
                System.out.println("Ford signin is displayed=====> PASS");

                driver.findElement(By.xpath("(//span[@class='user-menu-icon fgx-icon icon-account-outline fgx-icon--20'])[2]")).click();
                driver.findElement(By.xpath("(//li[@data-fgx-item-template='Sign In'])[2]")).click();
                Thread.sleep(5000);

                driver.findElement(By.id("username")).sendKeys("user");
                driver.findElement(By.id("password")).sendKeys("password");
                driver.findElement(By.id("submit-btn")).click();
                Thread.sleep(5000);

            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @AfterClass
   public void quit_session()
    {
        driver.quit();
    }
}
