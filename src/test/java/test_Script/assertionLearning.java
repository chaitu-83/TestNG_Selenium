package test_Script;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;


public class assertionLearning {
    WebDriver driver;
    @Test
    public void Example_AssertTrue()
    {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed());
        Assert.assertEquals(driver.getTitle(),"Google");


        driver.quit();
        System.out.println("Google Application Closed Successfully");
    }
}



