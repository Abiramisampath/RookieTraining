package com.selenium.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {

	public static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); 
		
	}
	
	@Test
	public void testLogin() throws InterruptedException {
		
		             
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("txtPassword"));
        password.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.name("Submit"));
        loginButton.click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("welcome")).click();
        //driver.findElement(By.id("welcome-menu")).click();
        driver.findElement(By.linkText("Logout")).click();
        
		
	}
	
	/*
	 * @Test public void takeSnapShot(WebDriver driver, String filePath) throws
	 * IOException { TakesScreenshot scrShot = ((TakesScreenshot)driver); File
	 * srcFile=scrShot.getScreenshotAs(OutputType.FILE); File destFile=new
	 * File(filePath); FileUtils.copyFile(srcFile, destFile);
	 * 
	 * }
	 */ 
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	

}
