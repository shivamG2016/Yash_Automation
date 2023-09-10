package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.OrangeHRM_HomePage;

public class Test003_login_LogoutTest extends BaseClass {

   @Test
   public void login(){


       logger.info("****Starting TC*****");
       LoginPage lp = new LoginPage(driver);
       logger.info("Page Lp Object create successfully");
       lp.setUserName("Admin");
       logger.info("user name added");
       lp.setPassword("admin123");
       logger.info("password entered");
       lp.clickOnContinueButton();
       logger.info("click on login button");
       logger.info("click on login button");
       // Assertion to check if user has been logged in successfully into the application

       OrangeHRM_HomePage orp = new OrangeHRM_HomePage(driver);
       String actualUserName =orp.getUserName();
       String expectedUserName ="Paul Collings";

       Assert.assertEquals(actualUserName,expectedUserName);
   }


    @Test(dependsOnMethods = "login")
  public void logout()
    {



    }





}
