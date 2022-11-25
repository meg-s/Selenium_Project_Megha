package day5;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumGridDemo {
	
	WebDriver driver;
	 @BeforeMethod
	 public void setup() {
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 
		 capabilities.setCapability("browserName", "IE");
		 capabilities.setCapability("browserVersion", "10.0");

		 URL url = null;
		 try {
			 url = new URL("https://meghasreejith_A0SvyZ:ixVfFbW4h15PRRKwxbXa@hub-cloud.browserstack.com/wd/hub");
		 }catch(MalformedURLException e) {
			 e.printStackTrace();
		 }
		 driver = new RemoteWebDriver(url, capabilities);

	 }
	 @AfterMethod 
	 public void tearDown(){
		 driver.quit();
	 }
	 
	 @Test
	 public void gridTest() {
		 driver.get("https://www.google.co.in");
		 Assert.assertTrue(driver.getTitle().contains("Google"));
	 }
	
	

}
