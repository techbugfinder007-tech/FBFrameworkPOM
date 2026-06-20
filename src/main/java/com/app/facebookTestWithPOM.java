package com.app;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.pageobject.ForgotPasswordPage;
import com.app.pageobject.LoginPage;
import com.app.pageobject.RegistrationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class facebookTestWithPOM {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2F");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("Rajesh", "Shahu");

		RegistrationPage regPage = loginPage.clickOnCreateAccount();

		regPage.enterRegistrationDetails("ROHIT", "SHARMA", "18", "APRIL", "2002", "Male", "98989898989", "6768399");
		regPage.clickOnSubmitBtn();
		boolean value = regPage.getErrorMessageForMobileNumber();
		System.out.println(value);
		Thread.sleep(2000);
		regPage.clickOnAlreadyhaveAccountBtn();

		ForgotPasswordPage forgotPassPageObj = loginPage.clickForgotPassword();
		forgotPassPageObj.enterEmailOrPhone("7788889999");

		forgotPassPageObj.clickOnContinueBtn();

		boolean value1 = forgotPassPageObj.isErrorMessageDisplayed();
		System.out.println(value1);

		
	}
}