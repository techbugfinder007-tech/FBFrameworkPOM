package com.app.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utils.CommomUtils;

public class LoginPage extends CommomUtils {
	//This is Page Object class

	public WebDriver driver;
	//this is new comment
	
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);//initialize web elements
		
	}
	//web elements
	@FindBy(xpath = "//input[@name='email']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='pass']")
	WebElement password;
	
	@FindBy(xpath = "//span[text()='Log in']")
	WebElement logIn;
	
	@FindBy(xpath = "//span[text()='Forgotten password?']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//span[text()='Create new account']")
	WebElement createAccountLink;
	
	@FindBy(xpath = "//span[text()='Explore the things ']")
	WebElement textMessage;
	
	
	@FindBy(xpath = "//div[@id='_R_1h6kqsqppb6am_']")
	WebElement errorMessage;	
	
	//action methods 
	
	public void enterEmail(String email) {
		userName.clear();
		userName.sendKeys(email);
	}
	
	public void enterPass(String pass) {
		password.clear();
		password.sendKeys(pass);
	}
	public void clickLoginBtn() {
		logIn.click();
	}
	
	public ForgotPasswordPage clickForgotPassword() {
		forgotPasswordLink.click();
		
		ForgotPasswordPage page = new ForgotPasswordPage(driver);
		return page;
	}
	
	public RegistrationPage clickOnCreateAccount() {
		createAccountLink.click();
		RegistrationPage page = new RegistrationPage(driver);
		return page;
		
	}
	
	//combine methods - 
	public void login(String username , String password) {
		enterEmail(username);
		enterPass(password);
		clickLoginBtn();
	}
	
	//Validations methods
	public String isErrorMsgDisplayed() {
		return errorMessage.getText();
	}
	public String isDisplayMessage() {
		return textMessage.getText();
	}

	public void goToLoginPage() {
		driver.get("https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2F");
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
