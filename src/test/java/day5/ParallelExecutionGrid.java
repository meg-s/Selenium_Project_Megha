package day5;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.TestNGException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParallelExecutionGrid {

	WebDriver driver;
	DesiredCapabilities capabilities;

	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	
	@BeforeMethod
	public void setup(String os, String osVersion, String browser, String  browserVersion){

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("os", os);
		capabilities.setCapability("osVersion", osVersion);
		capabilities.setCapability("browser", browser);
		capabilities.setCapability("browserVersion", browserVersion);

		URL url = null;
		try {
			url = new URL("https://meghasreejith_A0SvyZ:ixVfFbW4h15PRRKwxbXa@hub-cloud.browserstack.com/wd/hub");
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		driver = new RemoteWebDriver(url, capabilities);
	}
	
	@Test
	public void gridTest() {
		driver.get("https://www.google.co.in");
		Assert.assertTrue(driver.getTitle().contains("Google"));
	}
	
	@AfterMethod 
	public void tearDown(){
		driver.quit();
	}
}

/*
 * chrome windows: https://automate.browserstack.com/builds/3b3ff92ac916a2eb1dad38d0951ea67eea33fc0a/sessions/49cb4d6e3bab35e02bd6626d6b5b846b18196c9b?auth_token=46ff64829938634a3e664c097ffdd53a6f3b7cefcc8aa2f551582db6a833a4fd
 * firefox windows: https://automate.browserstack.com/builds/3b3ff92ac916a2eb1dad38d0951ea67eea33fc0a/sessions/387c3c1bf41a3657415861389560ea3ae1b10ea1?auth_token=5f180f0beaf4478f166e730c20ca67358f4e5ea0c64ef2b615613552fd318594
 * edge windows: https://automate.browserstack.com/builds/3b3ff92ac916a2eb1dad38d0951ea67eea33fc0a/sessions/5398f5bb038908393971e1464b8f00b58a2bb0d2?auth_token=450ebea78de0bfff471138c941f6484460c23d20d173e3fdfa30e5a2d3899618
 * chrome mac: https://automate.browserstack.com/builds/3b3ff92ac916a2eb1dad38d0951ea67eea33fc0a/sessions/e10d401b95cb35b56db637e95d1854ac4103a254?auth_token=d08dc2bf1ef559ce07ccf148dcacdea0ecfa2c8a7f8c227f1feabf8904357a83
 * firefox mac: https://automate.browserstack.com/builds/3b3ff92ac916a2eb1dad38d0951ea67eea33fc0a/sessions/d41429adfd818e8954eebdeaf4424fe16139a03c?auth_token=db5d84eb320e1e0a8c305f5c86f4e992c61c346ec40f85185fb67a5f12fb5587
 * 
 */


