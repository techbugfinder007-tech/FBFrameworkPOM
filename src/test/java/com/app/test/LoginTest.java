package com.app.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.testcomponent.BaseTest;
import com.app.testcomponent.Retry;

public class LoginTest extends BaseTest  {

	//positive tes
	@Test(dataProvider = "getLoginData" ,groups = {"Reg"})
	//public void loginWithValidCredentials(String email , String pass) {
	public void loginWithValidCredentials(HashMap<String , String> map) {
	loginPage.login(map.get("email"), map.get("password"));//retriving value from hashMap
		Assert.assertTrue(false);
		
	}
	
	//negative test
	@Test(retryAnalyzer = Retry.class)
	public void loginWithInValidCredentials() {
		loginPage.login("wrongUserName", "Wrong pass");
		Assert.assertTrue(false);
	}
	
/*	@DataProvider
	public Object[][] getLoginData() {
	return new Object [][]  {
		{"email1@gmail.com" ,"password1"},
		{"email2@gmail.com" ,"password2"},
		{"email3@gmail.com" ,"password3"},
		{"","password4"},
	};
 }
	*/
	
/*	@DataProvider
	public Object[][] getLoginData() {
		HashMap<String , String> map1 = new HashMap<>();
		map1.put("email","hashMail-1@gmail.com");
		map1.put("password", "pass1");
		
		HashMap<String , String> map2 = new HashMap<>();
		map2.put("email","hashmail2@gmail.com");
		map2.put("password", "pass2");

		return new Object[][] {
			{map1},
			{map2}
		};
	
 }*/
	
	@DataProvider
	public Object[][] getLoginData() throws IOException {
		
		List<HashMap<String, String>> data =  getJsonDataToMap();
		
		return new Object[][] {
			{data.get(0)},//object of hashmap which is present at index 0
			{data.get(1)},//object of hashmap which is present at index 1
		};
		
	}
	
	
}

