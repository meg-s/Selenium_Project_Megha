package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testInHeadMode {
	
	public void testing() {
	ChromeDriver driver = new ChromeDriver();		
	driver.get("https://ineuron-courses.vercel.app/login");		
	WebElement username = driver.findElement(By.name("email1"));
	username.sendKeys("SapientTraining@gmail.com");
	driver.findElement(By.id("password1")).sendKeys("Abcd@1234");
	driver.findElement(By.className("submit-btn")).click();
	
	JavascriptExecutor js=(JavascriptExecutor)driver;

	//js.executeScript("alert('Party')");

	js.executeScript("arguments[0].value=arguments[1]", username,"admin");

	js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[contains(@class,'login')]")));

	//scroll till webelement into view
	js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("")));
}
}
