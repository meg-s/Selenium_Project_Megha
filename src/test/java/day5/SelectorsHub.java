package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectorsHub {
	
	@Test
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.findElement(By.xpath("//input[@id='userId']")).sendKeys("abc");
	}
}
