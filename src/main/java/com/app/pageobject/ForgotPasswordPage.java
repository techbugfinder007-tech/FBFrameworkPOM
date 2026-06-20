package com.app.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utils.CommomUtils;

public class ForgotPasswordPage extends CommomUtils {

	public WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);//initialize web elements
		
	}
	//web elements
	@FindBy(xpath = "//input[@id='_r_2_']")
	WebElement enterMobileOrEmail;

	@FindBy(xpath = "//span[text()='Continue']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//div[@class='x9f619 x1ja2u2z x78zum5 x2lah0s x1n2onr6 x1nhvcw1 x6s0dn4 xyri2b x1c1uobl x18d9i69 xyamay9 xd9ej83 x162z183 x1oo3vh0 xwya9rg x1q0g3np x1a02dak']/div/span/div")
	List<WebElement> languages;
	
	@FindBy(xpath = "//span[text()='Find Your Account']")
	WebElement textElement;
	
	
	@FindBy(xpath = "//span[text()='Choose a way to log in']")
	WebElement nextPageText;
	
	@FindBy(xpath = "//span[text()='No account found. Check your mobile number or email address and try again.']")
	WebElement wrongMobNumber;
	
	@FindBy(xpath = "//div[@id='_r_1_']")
	WebElement errorMsgEmptyField;
	//action 

    public void enterEmailOrPhone(String value) {
       enterMobileOrEmail.clear();
       enterMobileOrEmail.sendKeys(value);
       
    }

    public boolean isErrorMessageDisplayed() {
    	String errorMsg = wrongMobNumber.getText();
    	System.out.println("ErrorMsg  :-  "+errorMsg);
        return  errorMsg.length() > 0;
    }
    
    public void clickOnContinueBtn() {
    	continueBtn.click();
    }

	public boolean isErrorMessageForEmptyField() {
		// TODO Auto-generated method stub
		return errorMsgEmptyField.getText().length() >0 ;
	}
	

}
