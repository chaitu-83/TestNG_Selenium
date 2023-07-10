package test_Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions.*;
import org.openqa.selenium.interactions.Action.*;
import org.testng.asserts.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public  class Google_TC001  {

    private static WebDriver driver;


    // Validating Google Page
    @Test
    public void validate_Google_Page() {

        //Instantiate a ChromeDriver Class.
        driver = new ChromeDriver();

        // Launch Website
        driver.get("https://google.com");

        // Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Validate Google Logo
        if (driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed()) {
            System.out.println("Google Logo is  Displayed ===== Pass");
        }
        // If anything goes wrong gives Exception "No such element"



      // closing Window
        driver.quit();
    }




    // Validating Difference Between driver.close() and driver.quit() methods

    @Test
    public void  Validating_Diff_Btn_Close_and_Quit()
    {
        driver = new ChromeDriver();
        driver.get("https://docker.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Returns the parent window name as a String
        String mainWindow = driver.getWindowHandle();
        // Returns number of  windows opened by WebDriver and will return Set of Strings
        Set<String> set = driver.getWindowHandles();
        // Using Iterator to iterate with in windows
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String childWindow = itr.next();
            // Compare whether the main windows is not equal to child window. If not equal, we will close.
            if (!mainWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                // Below code will print Child Window URL
                System.out.println(driver.switchTo().window(childWindow).getCurrentUrl());
                driver.close(); // Closing child TAB
                System.out.println("Close Method Performed");
            }
        }
        // Back to Parent Window
       // driver.switchTo().window(mainWindow);


        driver.quit(); // Closing Window including all TABs
        System.out.println("Quit Method Performed");
    }



    // Navigate Specific URL in Same TAB

    @Test
    public void Navigate_From_Google_To_Facebook()
    {
        driver = new ChromeDriver();
        driver.get("https://google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // now navigating from google to facebook

        driver.navigate().to("https://www.facebook.com");
        System.out.println("Navigation From Google To Facebook Performed");



        driver.quit();

    }

    // Count All Images Present In A Home Page

    @Test
    public void Count_All_Images_Present_In_Google()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Count number of links....

        int numberofImages = driver.findElements(By.xpath("//img")).size();
        System.out.println("Number Of images In  a Google Home page ...>"+ numberofImages);

        for(int x = 1;x<=numberofImages;x++) {

            System.out.println(driver.findElement(By.xpath("(//img)["+x+"]")).getText());
        }

        driver.quit();
    }

    @Test
    public void Count_All_Links_In_JavaTPoint()
    {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        int numberofLinks = driver.findElements(By.xpath("//a")).size();
        System.out.println("Number Of Links In  a Google Home page ...>"+numberofLinks);

        for(int x = 1;x<=numberofLinks;) {

           x++;

        }

        driver.quit();




    }
    }




