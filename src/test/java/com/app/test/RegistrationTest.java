package com.app.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.pageobject.RegistrationPage;
import com.app.testcomponent.BaseTest;

public class RegistrationTest  extends BaseTest  {
	RegistrationPage regPage;

	@Test(priority = 1)//groups = {"Regression"})
    public void registerWithValidData() {
    	 regPage = loginPage.clickOnCreateAccount();
		regPage.enterRegistrationDetails("ROHIT", "SHARMA", "18", "APRIL", "2023", "Male", "9898989898", "6768399");
		regPage.clickOnSubmitBtn();
		Assert.assertTrue(false);
    }

    @Test(priority = 2)
    public void registerWithEmptyFields() {
    	//driver.navigate().refresh();
    	 regPage = loginPage.clickOnCreateAccount();
    	regPage.enterRegistrationDetails("", "","","","","","","");
    	regPage.clickOnSubmitBtn();
    	//regPage.enterRegistrationDetails("ROHIT", "SHARMA", "18", "APRIL", "2002", "Male", "98989898989", "6768399");
    	Assert.assertFalse(regPage.getErrorMassage());
    }

    @Test(priority = 3)
    public void registerWithInvalidEmail() {
    	regPage = loginPage.clickOnCreateAccount();
    	driver.navigate().refresh();
    	regPage.enterRegistrationDetails("ROHIT", "SHARMA", "18", "APRIL", "2002", "Male", "98989898989", "6768399");
    	regPage.clickOnSubmitBtn();
    	
    	Assert.assertTrue(regPage.getErrorMassage());
    }

    @Test(priority = 4)
    public void registerWithWeakPassword() {
    	regPage = loginPage.clickOnCreateAccount();
    	driver.navigate().refresh();
    	regPage.enterRegistrationDetails("ROHIT", "SHARMA", "18", "APRIL", "2002", "Male", "98989898989", "6768399");
    	regPage.clickOnSubmitBtn();
    	
    	Assert.assertTrue(regPage.getErrorMassage());
       
    }

    @Test(priority = 5)
    public void registerWithoutFirstName() {
    	regPage = loginPage.clickOnCreateAccount();
    	driver.navigate().refresh();
    	regPage.enterRegistrationDetails("", "SHARMA", "18", "APRIL", "2002", "Male", "98989898989", "6768399");
    	regPage.clickOnSubmitBtn();
    	
    	Assert.assertTrue(regPage.getErrorMassage());
    }

    public void registerWithoutLastName() {
    }

    public void registerWithoutDOB() {
    }

    public void registerWithExistingUser() {
    }
	
	
}
