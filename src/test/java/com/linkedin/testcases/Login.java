/**
 * 
 */
package com.linkedin.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.linkedin.pages.HomePage;
import com.linkedin.pages.LoginPage;
import com.linkedin.utilities.Base;
import com.linkedin.utilities.ExcelDataDriven;


/**
 * @author RatheeshNair
 *
 */
public class Login extends Base {
	public WebDriver driver;
	@Test(dataProvider = "getdata")

	public void verifyHomePage(String username, String password) throws IOException {
		System.out.println(System.getProperty("user.dir"));

		driver = initilaizeDriver();
		LoginPage lp = new LoginPage(driver);
		lp.typeEmail("ratheeshsm@gmail.com");
		log.info("Email address is Entered");
		lp.typePassword("@11July2012");
/*		log.info("Password is updated");
		lp.clickSignIn();
		HomePage hp=new HomePage(driver);
		hp.signOut();*/

	}

	@DataProvider

	public Object[][] getdata() throws IOException {

		Object[][] data = new Object[1][2];
		
		
		ExcelDataDriven exceldatadriven=new ExcelDataDriven();
		ArrayList<String> excelData=exceldatadriven.getdata("verifyHomePage");
		data[0][0]=excelData.get(1);
		data[0][1]=excelData.get(2);
		return data;

	}

}
