package test_Script;
import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import support.Support;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import support.Support;

import java.time.Duration;

public class amazon_printlinks {
    public WebDriver driver;
    public Support obj;



    @BeforeClass
    public void setup() throws Exception
    {
        obj = new Support();
        //Instantiate a ChromeDriver Class.
        driver = new ChromeDriver();

        // Launch Website
        driver.get(obj.read_properties_file("amazon_url"));

        // Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test


    public void print_all_links() {

        try {
            int link_count= driver.findElements(By.xpath("//a")).size();
            for(int i=1;i<link_count;i++)
            {


                String link=driver.findElement(By.xpath("(//a)["+i+"]")).getText();
               // System.out.println("The Link Name is======>"+ link);
                  String href=driver.findElement(By.xpath("(//a)["+i+"]")).getAttribute("href");
               // System.out.println("The Link Name Is=====>"+ href);
                String innerHTML=driver.findElement(By.xpath("(//a)["+i+"]")).getAttribute("innerHTML");
                 System.out.println("The link name is==>"+innerHTML);
            }
        } catch (Exception e)
        {
            System.out.println(e);
        }




    }


    @AfterClass
    public void quit_session()
    {
        driver.quit();
    }

}



