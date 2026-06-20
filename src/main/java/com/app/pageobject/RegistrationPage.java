package com.app.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utils.CommomUtils;

public class RegistrationPage extends CommomUtils { //inheritance 
	//This is Page Object class
		public WebDriver driver1;

		public RegistrationPage(WebDriver driver){
			super(driver);
			this.driver1=driver;
			PageFactory.initElements(driver, this);//initialize web elements
		}
		
		//web elements
		@FindBy(xpath = "//input[@id='_R_1cl2p4jikacppb6amH1_']")
		WebElement userName;

		@FindBy(xpath = "//input[@id='_R_1kl2p4jikacppb6amH1_']")
		WebElement surname;
		
		@FindBy(xpath = "//div[@class='x78zum5 xdt5ytf xh8yej3']//div[@id='_r_3_']")
		WebElement day;
		
		@FindBy(xpath = "//span[text()='Day']/ancestor::div[@aria-label='Select day']/following::div[@class='x78zum5 xdt5ytf x1iyjqo2 x1n2onr6']/div")
		List<WebElement> dayList ;
		
		@FindBy(xpath = "//div[@aria-label='Select month']")
		WebElement month;
		
		@FindBy(xpath = "//span[text()='Month']/ancestor::div[@aria-label='Select month']/following::div[@class='x78zum5 xdt5ytf x1iyjqo2 x1n2onr6']/div")
		List<WebElement> monthList ;
		
		@FindBy(xpath = "//div[@aria-label='Select year']")
		WebElement year;
		
		@FindBy(xpath = "//span[text()='Year']/ancestor::div[@aria-label='Select year']/following::div[@class='x78zum5 xdt5ytf x1iyjqo2 x1n2onr6']/div")
		List<WebElement> yearList ;

		
		@FindBy(xpath = "//div[@id='_R_mad6p4jikacppb6amH2_']")
		WebElement gender;

		@FindBy(xpath = "//div[@class='x78zum5 xdt5ytf x1iyjqo2 x1n2onr6']/div[@aria-selected='false']")
		List<WebElement> genderList ;
		
		@FindBy(xpath = "//input[@id='_R_6ad8p4jikacppb6amH1_']")
		WebElement mobileNumber;
		
		
		@FindBy(xpath = "//input[@id='_R_clap4jikacppb6amH1_']" )
		WebElement passwordEle;
		
		
		@FindBy(xpath ="//div[@class='x1ja2u2z x78zum5 x2lah0s x1n2onr6 xl56j7k x6s0dn4 xozqiw3 x1q0g3np x972fbf x10w94by x1qhh985 x14e42zd x9f619 xtvsq51 xqbgfmv xbe3n85 x7a1id4 x1d9i5bo x1xila8y x1bumbmr xc8cyl1']")
		WebElement submitBtn;
		
		@FindBy(xpath ="//span[text()='Could not validate your mobile number. Please check the number and try again.']")
				//"//div[@id='_R_6ad8p4jikacppb6am_']")
		WebElement errorMessageForMobileNumber;
		
		
		@FindBy(xpath = "//div[@class='x9f619 x1ja2u2z x78zum5 x2lah0s x1n2onr6 x1nhvcw1 x6s0dn4 xyri2b x1c1uobl x18d9i69 xyamay9 xd9ej83 x162z183 x1oo3vh0 xwya9rg x1q0g3np x1a02dak']/div//a" )
		List<WebElement> langList;
		//actions
		
		@FindBy(xpath = "//span[text()='I already have an account']")
		WebElement alreadyHaveAccBtn;
		
		public void enterUsernameAndSurname(String name, String sur_name) {
			userName.clear();
			userName.sendKeys(name);
			
			surname.clear();
			surname.sendKeys(sur_name);
			
		}
		
		public void selectDay(String givenDay){
			day.click();
			handledropdown(givenDay, dayList);
		}
		
		public void selectMonth(String givenMonth){
			month.click();
			handledropdown(givenMonth, monthList);
		}
		
		public void selectYear(String givenyear){
			year.click();
			handledropdown(givenyear, yearList);
		}
		
		public void selectGender(String givenGender){
			gender.click();
			handledropdown(givenGender, genderList);
		}
		
		public void enterMobileNumberAndPassword(String mobile,String password) {
			mobileNumber.clear();
			mobileNumber.sendKeys(mobile);
			
			passwordEle.clear();
			passwordEle.sendKeys(password);
			
		}
		public void clickOnSubmitBtn() {
			submitBtn.click();
		}
		
		public void enterRegistrationDetails(String firstName,String surname,String day, String month,String year,
				String gender, String mobileNum, String password
				) {
			enterUsernameAndSurname(firstName, surname);
			selectDay(day);
			selectMonth(month);
			selectYear(year);
			selectGender(gender);
			enterMobileNumberAndPassword(mobileNum, password);
		}
		
		public boolean getErrorMessageForMobileNumber() {
			String erroMsg = errorMessageForMobileNumber.getText();
			System.out.println(erroMsg);
			return erroMsg.length() > 0; //true false
		}

		public void clickOnAlreadyhaveAccountBtn() {
			alreadyHaveAccBtn.click();
			
		}

		public boolean getErrorMassage() {
			return errorMessageForMobileNumber.getText().length() > 0;
		}
		
		
		
		
		
		
		
		
		
		
		
		
}
