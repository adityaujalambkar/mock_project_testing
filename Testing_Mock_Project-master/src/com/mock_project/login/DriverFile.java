package com.mock_project.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFile {
	
	public static WebDriver driver = null; 
	public static WebDriver driver(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\Driver100\\chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.setHeadless(true);
	    
		driver =new ChromeDriver(options);
		driver.get(url);
		return driver;
	}
}
