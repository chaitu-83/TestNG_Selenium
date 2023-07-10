package test_Script;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import java.time.Duration;

public class Linkedin_href_testing {

    private  static  WebDriver driver;

    // Validating Sign Up href value in Linkedin Page

    @Test
    public void Validating_Linkedin_Href_Value() {
        driver = new ChromeDriver();
        driver.get("https://linkedin.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String hrefVal = driver.findElement(By.xpath("//a[contains(.,'Sign Up')]")).getAttribute("href");
        System.out.println("The href Value of Sign Up Link Is ===>" +hrefVal);

        driver.quit();
    }

    // Validating Scroll an Element

    @Test
    public void Validating_Scroll_Element()
    {
        driver = new ChromeDriver();

        driver.get("https://linkedin.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.xpath("//a[contains(.,'Sign Up')]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        System.out.println("the element is Scrolled");
        driver.quit();

    }



    }


