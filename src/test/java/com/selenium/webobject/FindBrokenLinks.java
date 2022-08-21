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

public class FindBrokenLinks {

	public static void main(String[] args) throws Exception{
		
		int responseCode,count=0;

		WebDriverManager.chromedriver().setup();
		WebDriver w= new ChromeDriver();
		w.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		
		w.get("http://www.deadlinkcity.com/");	
		
		
		List<WebElement> links=w.findElements(By.tagName("a"));
		
		System.out.println("Total linsk :"+links.size());
		
		for(int i=0;i<links.size();i++) {
			
			String href=links.get(i).getAttribute("href");
			
			
			URL url=new URL(href);
			
			HttpURLConnection request=(HttpURLConnection) url.openConnection();
			request.setRequestMethod("HEAD");
			request.connect();
			
			responseCode=request.getResponseCode();
			
			if(responseCode>=400) {
				count++;
				System.out.println(url);
			}
		}
		
		
		System.out.println("Broken links : " +count);


	}

}
