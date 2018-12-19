/**
 * 
 */
package com.linkedin.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author RatheeshNair
 *
 */
public class Base {

	public static WebDriver driver;
	public Properties prop;
	public Logger log =LogManager.getLogger(getClass());
	
	public WebDriver initilaizeDriver() throws IOException {
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("src/test/resources/com/linkedin/properties/config.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "src/test/resources/com/linkedin/executables/chromedriver.exe");
			driver=new ChromeDriver();
			log.info("Chrome Browser value assigned to Driver");
			
			
		}
		
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/com/linkedin/executables/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/com/linkedin/executables/geckodriver.exe");
			driver=new InternetExplorerDriver();
			
		}
		
		
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		log.info("Browser Maximised");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#dismiss-alert")).click();
		log.info("Cache winodow closed");
		return driver;
		
	}
	
	public void getScreenshot(String result) throws IOException 
	
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		FileUtils.copyFile(src,new File(System.getProperty("user.dir")+ "\\target\\surefire-reports\\html\\" + result+screenshotName));
		
	}
		
	
}
