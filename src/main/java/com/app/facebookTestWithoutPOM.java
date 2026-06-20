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

import io.github.bonigarcia.wdm.WebDriverManager;

public class facebookTestWithoutPOM {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2F");

		WebElement userName = driver.findElement(By.xpath("//input[@name='email']"));
		userName.sendKeys("Admin1233");

		WebElement password = driver.findElement(By.xpath("//input[@name='pass']"));
		password.sendKeys("password1");

		WebElement logIn = driver.findElement(By.xpath("//span[text()='Log in']"));
		logIn.click();
		
		/*String daysListXpath = "//span[text()='Day']/ancestor::div[@aria-label='Select day']/following::div[@class='x78zum5 xdt5ytf x1iyjqo2 x1n2onr6']/div";

		String monthsListXpath = "//span[text()='Month']/ancestor::div[@aria-label='Select month']/following::div[@class='x78zum5 xdt5ytf x1iyjqo2 x1n2onr6']/div";

		String yearsListXpath = "//span[text()='Year']/ancestor::div[@aria-label='Select year']/following::div[@class='x78zum5 xdt5ytf x1iyjqo2 x1n2onr6']/div";

		String genderListXpath = "//div[@class='x78zum5 xdt5ytf x1iyjqo2 x1n2onr6']/div[@aria-selected='false']";
		
		String languagesXpath = "//div[@class='x9f619 x1ja2u2z x78zum5 x2lah0s x1n2onr6 x1nhvcw1 x6s0dn4 xyri2b x1c1uobl x18d9i69 xyamay9 xd9ej83 x162z183 x1oo3vh0 xwya9rg x1q0g3np x1a02dak']/div//a";

		WebElement createAcc = driver.findElement(By.xpath("//span[text()='Create new account']"));
		createAcc.click();
		Thread.sleep(2000);

		WebElement firstName = driver.findElement(By.xpath("//input[@id='_R_1cl2p4jikacppb6amH1_']"));
		firstName.sendKeys("Rajesh");

		WebElement SurName = driver.findElement(By.xpath("//input[@id='_R_1kl2p4jikacppb6amH1_']"));
		SurName.sendKeys("Sharma");

		WebElement day1 = driver.findElement(By.xpath("//div[@class='x78zum5 xdt5ytf xh8yej3']//div[@id='_r_3_']"));
		day1.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		By dayLocator = By.xpath(daysListXpath);
		List<WebElement> days = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dayLocator));

		for (WebElement day : days) {
			try {
				if (day.getText().equalsIgnoreCase("8")) {
					day.click();
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Retrying...Day ");
			}
		}

		WebElement month1 = driver.findElement(By.xpath("//div[@aria-label='Select month']"));
		month1.click();

		By monthsLocator = By.xpath(monthsListXpath);
		List<WebElement> months = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(monthsLocator));
		for (WebElement monEle : months) {
			try {
				if (monEle.getText().equalsIgnoreCase("November")) {
					monEle.click();
				}

			} catch (StaleElementReferenceException e) {
				System.out.println("Retrying...month ");
			}
		}

		WebElement year1 = driver.findElement(By.xpath("//div[@aria-label='Select year']"));
		year1.click();

		By yearsLocator = By.xpath(yearsListXpath);
		List<WebElement> years = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(yearsLocator));
		for (WebElement yearEle : years) {
			try {
				if (yearEle.getText().equalsIgnoreCase("2005")) {
					yearEle.click();
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Retrying...year");
			}
		}

		WebElement gender1 = driver.findElement(By.xpath("//div[@id='_R_mad6p4jikacppb6amH2_']"));
		gender1.click();

		By gendersLocator = By.xpath(genderListXpath);
		List<WebElement> gendersList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(gendersLocator));
		for (WebElement genderEle : gendersList) {
			try {
				if (genderEle.getText().equalsIgnoreCase("Male")) {
					genderEle.click();
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Retrying...gender");
			}
		}
		WebElement mobileNumber = driver.findElement(By.xpath("//input[@id='_R_6ad8p4jikacppb6amH1_']"));
		mobileNumber.sendKeys("1234567890");
		
		WebElement password2 = driver.findElement(By.xpath("//input[@id='_R_clap4jikacppb6amH1_']"));
		password2.sendKeys("mypassword");
		
		By languagesLocator = By.xpath(languagesXpath);
		
		List<WebElement> languageList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(languagesLocator));
		
		for (WebElement languageEle : languageList) {
			try {
				System.out.print("   "+languageEle.getText());
				}
			 catch (StaleElementReferenceException e) {
				System.out.println("Retrying...gender");
			}
		}
		
		By submitBtn = By.xpath("//div[@class='x1ja2u2z x78zum5 x2lah0s x1n2onr6 xl56j7k x6s0dn4 xozqiw3 x1q0g3np x972fbf x10w94by x1qhh985 x14e42zd x9f619 xtvsq51 xqbgfmv xbe3n85 x7a1id4 x1d9i5bo x1xila8y x1bumbmr xc8cyl1']");
		driver.findElement(submitBtn).click();
		
		By errorMsg = By.xpath("//div[@id='_R_clap4jikacppb6am_']");
		
		String actualMsg = driver.findElement(errorMsg).getText();
		System.out.println("actual message");
		
		System.out.println(actualMsg);*/
	}
}