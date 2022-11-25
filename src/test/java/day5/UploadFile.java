package day5;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UploadFile {
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("file-upload"))).click().perform();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("\"C:\\Users\\megsreej\\Desktop\\autoitTest.exe\"");
		driver.findElement(By.id("file-submit")).click();
	}
}
