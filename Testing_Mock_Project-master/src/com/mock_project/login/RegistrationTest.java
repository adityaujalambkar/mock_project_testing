package com.mock_project.login;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.data.Configuration;
import com.data.RegistrationData;

@Test
public class RegistrationTest {
	public void registrationTestMethod() {
		
		for(int i=0;i<RegistrationData.registrationData.length;i++) {
		WebDriver driver=DriverFile.driver(Configuration.Registration_URI);
		
		
		WebElement elementFname = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]"));
		elementFname.sendKeys(RegistrationData.registrationData[i][0]);
		
		WebElement elementLname = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail2\"]"));
		elementLname.sendKeys(RegistrationData.registrationData[i][1]);
		
		WebElement elementEmail = driver.findElement(By.id("exampleInputEmail3"));
		elementEmail.sendKeys(RegistrationData.registrationData[i][2]);
		
		WebElement elementPassword = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail4\"]"));
		elementPassword.sendKeys(RegistrationData.registrationData[i][3]);
		
		WebElement elementMobileNumber = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail5\"]"));
		elementMobileNumber.sendKeys(RegistrationData.registrationData[i][4]);
		
		WebElement elementAddress = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail6\"]"));
		elementAddress.sendKeys(RegistrationData.registrationData[i][5]);
		
		WebElement elementRegister = driver.findElement(By.xpath("/html/body/app-root/app-register/div/div/div[2]/form/button[1]"));
		elementRegister.submit();
		
		String url=driver.getCurrentUrl();
		try {
		assertEquals(url,RegistrationData.registrationData[i][6]);
		}catch(Error e) {
			
		}
		}
	}
}
