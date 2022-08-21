package com.itview.login.selenium_test;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathTest {

	public static void main(String[] args) throws Exception {

  
	//	interfaceName instance=new implementationClassName(); 
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver w=new ChromeDriver(); 
		
		w.get("https://demo.testfire.net/login.jsp"); 	
		
		w.findElement(By.xpath("//*[@id=\"LinkHeader2\"]")).click(); // Used Relative xpath
		
		Thread.sleep(2000);
		
		w.get("https://demo.testfire.net/login.jsp"); 	
		
		w.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[2]/div/a")).click();// Used Absolute xpath
	

	}

}
