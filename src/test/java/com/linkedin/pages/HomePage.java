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
public class HomePage {

	public WebDriver driver;

	By ME = By.cssSelector(".nav-item__profile-member-photo");
	By SIGN_OUT = By.linkText("Sign out");

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	public void signOut() {

		driver.findElement(ME).click();
		driver.findElement(SIGN_OUT).click();
	}

}
