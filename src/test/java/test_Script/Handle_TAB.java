package test_Script;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_TAB {

    public static WebDriver driver = null;
    public static void main(String args[]) throws Exception {

       //System.setProperty("webdriver.chrome.driver", "/Users/rm/Downloads/chromedriver2");
        driver = new ChromeDriver();
        driver.get("https://google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        ((JavascriptExecutor) driver).executeScript("window.open()"); // Creating a new TAB
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Switching to child window by Index
        driver.navigate().to("https://www.facebook.com"); // Closing child window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("opened child window Facebook Page");
        driver.switchTo().window(tabs.get(0)); // Switching back to parent window by index
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Switch Back to Parent Window Google Page");
        driver.quit();
    }
}
