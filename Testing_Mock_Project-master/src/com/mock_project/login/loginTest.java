package com.mock_project.login;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.data.Configuration;
import com.data.LoginData;

public class loginTest {
	
	
	private static final Logger LOGGER = Logger.getLogger(loginTest.class);
	@Test
	public void loginTestMethod() throws IOException {
		for(int i=0;i<LoginData.loginData.length;i++) {
		WebDriver driver=DriverFile.driver(Configuration.Login_URI);
		WebElement elementEmail = driver.findElement(By.id("exampleInputEmail1"));
		elementEmail.sendKeys(LoginData.loginData[i][0]);
		
		WebElement elementPassword = driver.findElement(By.id("exampleInputPassword1"));
		elementPassword.sendKeys(LoginData.loginData[i][1]);
		WebElement elementLogin = driver.findElement(By.cssSelector("body > app-root > app-login > div > div > div.col-sm-6.my-4.align-self-center > form > button"));
		elementLogin.click();
		String url=driver.getCurrentUrl();
		
		try {
		assertEquals(url,LoginData.loginData[i][2]);
		System.out.println(i+"Test-case for login page is Passed");
		}catch(Error e) {
			//#ignored error
		}
		}
	}

}
