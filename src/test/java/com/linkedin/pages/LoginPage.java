/**
 * 
 */
package com.linkedin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author RatheeshNair
 *
 */
public class LoginPage {

	public WebDriver driver;
	By emailSign = By.cssSelector("#login-email");
	By passwordSign = By.cssSelector("#login-password");
	By signIn = By.cssSelector(".submit-button");
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	

	public void typeEmail(String email) {

		driver.findElement(emailSign).sendKeys(email);
	}

	public void typePassword(String password) {

		driver.findElement(passwordSign).sendKeys(password);
	}
	
	public void clickSignIn()
	
	{
		driver.findElement(signIn).click();
		
	}

}
