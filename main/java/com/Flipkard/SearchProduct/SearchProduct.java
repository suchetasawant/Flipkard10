package com.Flipkard.SearchProduct;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Flipkard.Constant.Constant;
import com.Flipkard.Keyword.Keyword;


public class SearchProduct extends Keyword{
	
	@Test
	public void searchProd() throws InterruptedException {

		Keyword.openBrowser("chrome");
		launchUrl("https:www.flipkart.com");
		implicitWait(3);
		maximize();

		// it will close pop-up
		closePopup("popup");

		// it will check search box and enter product & click on search button
		searchProduct("search", "Shoes");
		performClick("searchBox");

		// now we are clicking on login button,entering email or mob no then
		//entering password & finally click on log-in button to LogIn user successfully
		click("logIn");
		enterText("email/mob", "7030809206");
		enterText("password", "such12@");
		performClick("logInButton");
		
		
		explicitWait(8);
	//	mouseHoverOnly(Sampada);
		explicitWait(5);
		click("MyProfile");
		explicitWait(3);
		
		
	
	}

	
	
}