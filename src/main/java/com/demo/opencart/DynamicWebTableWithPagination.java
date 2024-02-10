package com.demo.opencart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableWithPagination {
	
	/* tutorial link: https://www.youtube.com/watch?v=55ZxPTqscxI
	 * */
	
	private static WebDriver driver;
//	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	private static WebDriverWait wait ;
	public static void sleep() throws Exception{
		Thread.sleep(2000);
	}
	
	public static void defaultWaitForSecureConnection(String url) {
		System.out.println("current Url: "+driver.getCurrentUrl());
		wait.until(ExpectedConditions.urlToBe(url));
	}
	
	public static void main(String[] args) throws Exception{
		
		
//		WebDriverManager.firefoxdriver().setup();
//		FirefoOptions option = new ChromeOptions();
//		option.setAcceptInsecureCerts(true);
//		WebDriver driver = new FirefoxDriver();
		
		
		WebDriverManager.chromedriver().setup();
//		ChromeOptions option = new ChromeOptions();
//		option.setAcceptInsecureCerts(true);
//		option.setCapability("ignore-certificate-errors", true);
//		driver = new ChromeDriver(option);
		driver = new ChromeDriver();
//		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String mainUrl = "https://demo.opencart.com/admin/index.php";
		driver.get(mainUrl);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(mainUrl));
		driver.manage().window().maximize();
		
		sleep();
		
//		defaultWaitForSecureConnection(driver.getCurrentUrl());
		// Login
		
		WebElement username = driver.findElement(By.id("input-username"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password = driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		Thread.sleep(3000);
		
		String modalXpath = "//div[@class='modal-header']//button[@type='button']";
		driver.findElement(By.xpath(modalXpath)).click();
		sleep();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
		driver.findElement(By.xpath("//a[contains(text(),'Sales')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();
		System.out.println("url: "+driver.getCurrentUrl());
		
		
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.urlToBe(mainUrl));
		
//		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
//		System.out.println("text: "+text);
	}

}
