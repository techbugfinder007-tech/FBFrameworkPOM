package com.app.testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.app.pageobject.LoginPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest { //common reusable code for Test classes
	
	public WebDriver driver;
	public LoginPage loginPage;
	
	public WebDriver initializeWebdriver() throws IOException {
		String path = System.getProperty("user.dir")+"//src//main//resources//config//globalConfig.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		
		//ternary opertor
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		
		//String browserName = prop.getProperty("browserName");
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();//use to customize the bropwser behaviour
			WebDriverManager.chromedriver().setup();//setting up chromeDriver
			if (browserName.contains("headless")) {//chromeheadless
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);//initialize driver
			 driver.manage().window().setSize(new Dimension(1440, 900));//full screen
			 
		}else if (browserName.contains("firefox")) {
			//initialize firefox
			System.setProperty("webdriver.gecko.driver",
					"//opt//homebrew//bin/geckodriver");
			driver = new FirefoxDriver();
			
		}else if (browserName.contains("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	
	//reading the json file 
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		//Path of Json file
		String path = System.getProperty("user.dir")+"//src//main//resources//config//loginData.json";
		String jsonContent = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
		
		//convert this json data into HashMap
		ObjectMapper  mapper =new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;//return list
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destfile = new File(System.getProperty("user.dir")+"//reports//screenshot//"+testCaseName+".png");
		FileUtils.copyFile(source, destfile);
		return System.getProperty("user.dir")+"//reports//screenshot//"+testCaseName+".png";
	}
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage launchAppliaction() throws IOException {
		driver = initializeWebdriver();
		 loginPage = new LoginPage(driver);
		loginPage.goToLoginPage();//landing on the login page 
		return loginPage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		driver.close();
	}

}
