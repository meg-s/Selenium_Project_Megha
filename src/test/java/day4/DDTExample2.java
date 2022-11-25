package day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTExample2 {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		//System.out.println("Running before method");
		driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();	
	}
	
	@Test(dataProvider = "testdata")
	public void myTest(String username, String password) {
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys(password);
		driver.findElement(By.className("submit-btn")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Sign out']")).isDisplayed());
	}
	
	@DataProvider(name = "testdata")
	public Object[][] testDataGeneration() {
		Object[][] arr = null;
		
		try{
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File("./testData/SapientTestData.xlsx")));
			int rows = wb.getSheet("LoginData").getPhysicalNumberOfRows();
			int column = wb.getSheet("LoginData").getRow(0).getPhysicalNumberOfCells();
			arr = new Object[rows][column];
			for (int i=0; i<rows; i++) {
				for(int j=0; j<column; j++) {
					arr[i][j]= wb.getSheet("LoginData").getRow(i).getCell(j).getStringCellValue();
				}
			}wb.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return arr;
	}
}
