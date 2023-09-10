package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {


    @Test
    public void test_account_Registration() {


        try {
            // we need to access the HomePage related actions and elements so we have to create the Object of home page first
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();

            hp.clickRegister();

            // we Need to use Registration page related actions and elements so we have to create Object of Registration Page object first


            AccountRegistrationPage arp = new AccountRegistrationPage(driver);
            arp.setFirstName(randomString().toUpperCase() + "123");
            arp.setLastName(randomString() + "123");
            arp.setEmailId(randomString() + "12345" + "@gmail.com");
            arp.setPassword("Winter@1008");
            arp.clickChkPolicy();
            arp.clickContinueButton();

            String confirmationMessage = arp.getConfirmationMessage();
            Assert.assertEquals(confirmationMessage, "Your Account Has Been Created!");


        } finally {

        }


    }
}
