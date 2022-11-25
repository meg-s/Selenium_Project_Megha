package day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleDynamicAlert {
		@Test
		public void Test7() throws InterruptedException {
			// TODO Auto-generated method stub
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
			driver.findElement(By.xpath("//button[text()='Try it']")).click();
			Thread.sleep(10000);
			Alert alt=driver.switchTo().alert();
			alt.accept();
			Assert.assertTrue(driver.getCurrentUrl().contains("selenium"));

		}
}

