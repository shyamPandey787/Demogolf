package TESTCASE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.Test;

public class P3 {
	@Test
	public void main() throws InterruptedException, Exception {
	
		   WebDriver driver = new ChromeDriver();

	        try {
	            // Open URL
	            driver.get("https://demo.automationtesting.in/Register.html");
	            driver.manage().window().maximize();

	            // Fill Registration Form
	            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Shyam");
	            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Pandey");
	            driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("Surat, Gujarat");
	            driver.findElement(By.xpath("//input[@type='email']")).sendKeys("shyam@test.com");
	            driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9876543210");

	            // Gender
	            driver.findElement(By.xpath("//input[@value='Male']")).click();

	            // Hobbies
	            driver.findElement(By.id("checkbox1")).click(); // Cricket
	            driver.findElement(By.id("checkbox2")).click(); // Movies

	            // Skills Dropdown
	            driver.findElement(By.id("Skills")).sendKeys("Java");

	            // Country
	            driver.findElement(By.id("countries")).sendKeys("India");

	            // Password
	            driver.findElement(By.id("firstpassword")).sendKeys("Test@123");
	            driver.findElement(By.id("secondpassword")).sendKeys("Test@123");

	            // Click Submit
	            driver.findElement(By.id("submitbtn")).click();

	            Thread.sleep(3000);

	            System.out.println("Registration Test Completed!");

	        } finally {
	            driver.quit();
		
	
		
	        }}}
	


