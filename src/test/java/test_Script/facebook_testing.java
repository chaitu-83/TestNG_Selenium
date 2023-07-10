package test_Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class facebook_testing {
    public static void main(String args[]) throws Exception
    {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id ='email']")).sendKeys("xxx.gmail.com");
        driver.findElement(By.xpath("//input[@id ='pass']")).sendKeys("aah");
       // driver.findElement(By.xpath("//button[@name='login']")).click();
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //driver.navigate().forward();
        driver.findElement(By.xpath("//div[text()='Sign Up']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='First name']")).sendKeys("xxxx");

       // Select sel1 = new Select(driver.findElement(By.xpath("//select[@id='month']")));
       // sel1.selectByIndex(4);
      //  Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='day']")));
      //  sel2.selectByValue("5");
      //  Select sel3 = new Select(driver.findElement(By.xpath("//select[@id='year']")));
      //  sel2.selectByVisibleText("2000");
      //  driver.findElement(By.xpath("(//input[@name='sex'])[2]")).click();
        driver.findElement(By.xpath("(//button[text()='Sign Up'])[1]")).click();
        driver.navigate().back();



      //  driver.quit();
    }


}
