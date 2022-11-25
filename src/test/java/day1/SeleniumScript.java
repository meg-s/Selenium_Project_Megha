package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumScript {
	
	@Test
	public void Test1() {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Megha Sreejith");

		String title = driver.getTitle();
		System.out.println("Title is " + title);
		String url = driver.getCurrentUrl();
		System.out.println("URL is "+ url);
		driver.quit();
		Assert.assertTrue(true);
	}

}
