package com.itview.login.selenium_test;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) throws Exception {

  
	//	interfaceName instance=new implementationClassName(); 
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver w=new ChromeDriver(); // open a blank chrome browser
		
		w.get("https://demo.testfire.net/login.jsp"); //Step 1 : Open application with url
		
		w.findElement(By.id("uid")).sendKeys("admin"); // Step 2 : Enter username
		
		w.findElement(By.id("passw")).sendKeys("admin"); // Step 3 : Enter password
		
		w.findElement(By.name("btnSubmit")).click(); // Step 4: Click login		

        Thread.sleep(3000); // 3000 millisec = 3 sec
          
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click(); //Step 5: Click Logout
		
		w.quit(); // Step 6 : Close
		
		System.out.println("Admin has succefully Logged-In : Passed");

	}

}
