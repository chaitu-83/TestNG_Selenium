package test_Script;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.time.Duration;

public class Screenshot_Learning {

    private WebDriver driver;
    String screenshotpath = "C://Users//cjamm//IdeaProjects//selenium2_testING//Screenshot";


    @BeforeClass
    public void setup() {
        System.out.println("......Starting Chrome Browser..........");
        //Instantiate a ChromeDriver Class.
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Launch Website
        driver.get("https://docker.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    public void capture_Screenshot_during_fail() {
        try {

            driver.findElement(By.xpath("//abcd")).click();

        } catch (Exception e) {
            capture_Screenshot("Docker_Logo");

           // System.out.println(e);
        }
    }

    public void capture_Screenshot(String screenshotname) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(screenshotpath + "/" + screenshotname + ".png"));


        } catch (Exception e) {
            System.out.println(e);
        }

    }


}


