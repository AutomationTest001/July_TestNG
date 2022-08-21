package com.itview.login.selenium_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
	   FileInputStream fi=new FileInputStream(".\\test.properties");
	   
	   Properties p=new Properties();
	   
	   p.load(fi);
	   
	   String read_id=p.getProperty("id");
	   
	   String read_password=p.getProperty("password");

	   System.out.println(read_id+"  "+read_password);
	   
	   
	   fi.close();
	   
	   

	}

}
