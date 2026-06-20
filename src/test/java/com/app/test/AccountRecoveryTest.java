package com.app.test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.app.pageobject.ForgotPasswordPage;
import com.app.testcomponent.BaseTest;

public class AccountRecoveryTest extends BaseTest {

	ForgotPasswordPage forgotPasswordPage;

	@Test(priority = 1)
	public void recoverAccountWithValidEmail() {
		forgotPasswordPage = loginPage.clickForgotPassword();
		forgotPasswordPage.enterEmailOrPhone("bihadep@gmail.com");
		forgotPasswordPage.clickOnContinueBtn();
		AssertJUnit.assertTrue(true);
	}
	
	@Test(priority = 2)
	public void recoverAccountWithInvalidEmail() {
		//driver.navigate().refresh();
		forgotPasswordPage = loginPage.clickForgotPassword();
		forgotPasswordPage.enterEmailOrPhone("XXXX889999");
		forgotPasswordPage.clickOnContinueBtn();
		AssertJUnit.assertTrue(forgotPasswordPage.isErrorMessageDisplayed());
	}

	@Test(priority = 3)
	public void recoverAccountWithEmptyField() {
		//driver.navigate().refresh();
		forgotPasswordPage = loginPage.clickForgotPassword();
		forgotPasswordPage.enterEmailOrPhone("");
		forgotPasswordPage.clickOnContinueBtn();
		AssertJUnit.assertTrue(forgotPasswordPage.isErrorMessageForEmptyField());
	}

	@Test(priority = 4)
	public void recoverAccountWithInvalidPhone() {
		//driver.navigate().refresh();
		forgotPasswordPage = loginPage.clickForgotPassword();
		forgotPasswordPage.enterEmailOrPhone("9090909kk");
		forgotPasswordPage.clickOnContinueBtn();
		AssertJUnit.assertTrue(forgotPasswordPage.isErrorMessageDisplayed());
	}

}
