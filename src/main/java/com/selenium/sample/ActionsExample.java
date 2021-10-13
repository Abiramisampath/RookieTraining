package com.selenium.sample;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsExample {
	
	public static WebDriver driver;
		
		@BeforeTest
		public void setup() {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
			
		}
	
		@Test
		public void sampleAction() {
	
			String baseUrl = "http://www.facebook.com/"; 
						
			driver.get(baseUrl);
			WebElement txtUsername = driver.findElement(By.id("email"));
			
			Actions builder = new Actions(driver);
			Action seriesOfActions = builder
				.moveToElement(txtUsername)
				.click()
				.keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "hello")
				.keyUp(txtUsername, Keys.SHIFT)
				.doubleClick(txtUsername)
				.contextClick()
				.build();
				
			seriesOfActions.perform() ;
		
		}
		
		@AfterTest
		public void tearDown() {
			driver.close();
		}
		
	}


