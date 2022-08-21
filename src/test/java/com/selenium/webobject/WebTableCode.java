package com.selenium.webobject;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableCode {

	public static void main(String[] args) throws Exception{
		
		int responseCode,count=0;

		WebDriverManager.chromedriver().setup();
		WebDriver w= new ChromeDriver();
		w.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		w.manage().window().maximize();
		w.get("http://hospitalnew.bdtask.com/demo6/login");	
		
		w.findElement(By.xpath("/html/body/div/div/div/div[3]/table/tbody/tr[1]/td[1]")).click();
		
		w.findElement(By.xpath("//*[@id=\"loginForm\"]/div[4]/button")).click();
		
		w.findElement(By.linkText("Department")).click();
		
		w.findElement(By.linkText("Department List")).click();
		
		List<WebElement> li=w.findElements(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div[2]/div/div[2]/ul/li"));
		
		System.out.println(li.size());
		
		int flag=0;

		for(int i=0;i<li.size();i++) {
			
			
			if(!(li.get(i).getText().equals("Previous"))) {
				Thread.sleep(4000);
				System.out.println(li.get(i).getText());
				w.findElement(By.xpath("//*[@id=\"DataTables_Table_0_paginate\"]/ul/li["+i+"]/a")).click();
				
				List<WebElement> rows=w.findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr"));
				List<WebElement> columns=w.findElements(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div[2]/div/table/tbody/tr["+i+"]/td"));

				
				for(int a=1;a<rows.size();a++) {
					

					for(int b=1;b<columns.size();b++) {
						
                   
						String textToFind=w.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div[2]/div/table/tbody/tr["+a+"]/td["+b+"]")).getText();

						if(textToFind.equals("Pharmacy")) {
							flag=1;
						}
						
						
					}
					
				}
			}
			
			
		}
		if(flag==1)
		System.out.println("Found");
		
	}

}
