package com.selenium.sample;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;




public class WebTableExample {
	

	public static WebDriver driver;
	String max;
    double m=0,r=0;
		
		@BeforeTest
		public void setup() {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
			
		}
	
		@Test
		public void getMaxValue() throws ParseException {
			
			driver.get("http://demo.guru99.com/test/web-table-element.php"); 
			 //No. of Columns
		        List  col = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
		        System.out.println("Total No of columns are : " +col.size());
		        //No.of rows
		        List  rows = driver.findElements(By.xpath (".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		        System.out.println("Total No of rows are : " + rows.size());
		        for (int i =1;i<rows.size();i++)
		        {    
		            max= driver.findElement(By.xpath("//tbody/tr[\"+(i+1)+\"]/td[4]")).getText();
		            NumberFormat f =NumberFormat.getNumberInstance(); 
		            Number num = f.parse(max);
		            max = num.toString();
		            m = Double.parseDouble(max);
		            if(m>r)
		             {    
		                r=m;
		             }
		        }
		        System.out.println("Maximum current price is : "+ r);
		}
	
		@AfterTest
		public void tearDown() {
			driver.close();
		}

}
