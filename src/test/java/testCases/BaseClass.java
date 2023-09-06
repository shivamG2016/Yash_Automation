package testCases;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

public class BaseClass {
public  static WebDriver driver ;
public Logger logger ;

public ResourceBundle rb ;

    @BeforeTest
    @Parameters("browser")
   public void setUp(String br)
    {

        rb =ResourceBundle.getBundle("config");

        logger = (Logger) LogManager.getLogger(this.getClass());
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
        if(br.equalsIgnoreCase("chrome"))
        {
            driver=new ChromeDriver();
        }
        else if(br.equalsIgnoreCase("edge"))
        {
            driver=new EdgeDriver();
        }
        else
        {
            driver=new FirefoxDriver();
        }
     driver.manage().deleteAllCookies();
     driver.get(rb.getString("appUrl"));
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown()
    {

     driver.quit();

    }

    public String randomString(){
        return  RandomStringUtils.randomAlphabetic(10);
    }

    public String randomString2(){
        return  RandomStringUtils.randomNumeric(5);
    }


    public String randomAlphaNumeric()

    {
        String randomAlphaNumeric= RandomStringUtils.randomAlphabetic(5) ;
        String randomNUmber=RandomStringUtils.randomNumeric(10);
        return randomAlphaNumeric+randomNUmber;
    }
    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;

    }

}
