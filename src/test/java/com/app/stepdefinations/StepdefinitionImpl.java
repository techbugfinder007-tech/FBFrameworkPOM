package com.app.stepdefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.app.pageobject.LoginPage;
import com.app.pageobject.RegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepdefinitionImpl {

    WebDriver driver;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @Given("user is on Facebook login page")
    public void user_is_on_facebook_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        loginPage = new LoginPage(driver);
    }

    @When("user enters valid email and password")
    public void user_enters_valid_email_and_password() {
        loginPage.enterEmail("abc@gmail.com");
        loginPage.enterPass("pwd123");
    }
    @When("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLoginBtn();
    	//driver.close();
    }
    
    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
    	System.out.println("login successfully");
    }
    

    @When("user enters invalid email and password")
    public void user_enters_invalid_email_and_password() {
        loginPage.enterEmail("wrong@gmail.com");
        loginPage.enterPass("wrong123");
    }

    @Then("{string} message is displayed")
    public void message_is_displayed(String msg) {
       System.out.println(msg  );
       
       //assert
    }
    
    @When("user clicks on Create New Account")
    public void user_clicks_on_create_new_account() {
    	registrationPage = loginPage.clickOnCreateAccount();
    }
    
    @When("user enters valid registration details")
    public void user_enters_valid_registration_details() {
    	registrationPage.enterRegistrationDetails("ROHIT", "SHARMA", "18", "APRIL", "2024", "Male", "98989898989", "6768399");
    }

    @When("clicks on Sign Up button")
    public void clicks_on_sign_up_button() {
    	registrationPage.clickOnSubmitBtn();
    }
    
    @Then("user account should be created successfully")
    public void user_account_should_be_created_successfully() {
    	System.out.println("account created successfully ");
    	//driver.close();
    }
    @When("user clicks on Sign Up without entering data")
    public void user_clicks_on_sign_up_without_entering_data() {
    	registrationPage.enterRegistrationDetails("","","","","","","","");
    	registrationPage.clickOnSubmitBtn();
    }
    @Then("user should see validation errors")
    public void user_should_see_validation_errors() {
    	boolean value =  registrationPage.getErrorMassage();
    	Assert.assertTrue(value);
    }
   
    
    
    
}