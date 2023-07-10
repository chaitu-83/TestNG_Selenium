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

public class walmart_getAttributes {
    public WebDriver driver;
    public Support obj;



    @BeforeClass
    public void setup() throws Exception
    {
        obj = new Support();
        //Instantiate a ChromeDriver Class.
        driver = new ChromeDriver();

        // Launch Website
        driver.get(obj.read_properties_file("walmart_url"));

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

               //getting Text from Link
                String link = driver.findElement(By.xpath("(//a)["+i+"]")).getText();
                 System.out.println("The Link Name is======>"+ link);

                // getting href Attribute from the link
                String href=driver.findElement(By.xpath("(//a)["+i+"]")).getAttribute("href");
                 System.out.println("The href Name Is=====>"+ href);

                // getting innerHTML Attribute from the link
                String innerHTML=driver.findElement(By.xpath("(//a)["+i+"]")).getAttribute("innerHTML");
                 System.out.println("The innerText name is==>"+innerHTML);

                // getting src Attribute from the link
                String src =driver.findElement(By.xpath("(//img)["+i+"]")).getAttribute("src");
                System.out.println("The src name is==>"+src);
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




