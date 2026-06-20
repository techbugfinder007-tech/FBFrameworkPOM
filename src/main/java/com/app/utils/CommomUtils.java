package com.app.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommomUtils { //Generic  Class 

	public WebDriver driver;
	
	public CommomUtils(WebDriver driver) {
		this.driver=driver;
	}

	//waits methods
	//waitfor Element Visible
	//wait for ElementForClickable
	//waitforTitle
	//selectbyVisibleText
	//Alert
	//Javascript.
	//windows Switching 
	//ScreenShot 
	
	
	public void waitForWebElementToAppear(List<WebElement> webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
		
	}
	
	public void handledropdown(String givenValue, List<WebElement> listOfEles ) {
		waitForWebElementToAppear(listOfEles);
	
	for (WebElement day : listOfEles) {
		try {
			if (day.getText().equalsIgnoreCase(givenValue)) {
				day.click();
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Retrying... "+givenValue);
		}
	}
	
}
	
	
}
