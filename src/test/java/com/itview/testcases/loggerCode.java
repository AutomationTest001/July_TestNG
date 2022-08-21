package com.itview.testcases;

import org.apache.logging.log4j.*;

public class loggerCode {

	public static void main(String[] args) {


		Logger log=LogManager.getLogger("loggerCode");
		
		log.info("Hello World !!");
		log.info("Hello Java !!");
		log.info("Hello Selenium !!");
		log.error("testing");
		
		
	

	}

}
