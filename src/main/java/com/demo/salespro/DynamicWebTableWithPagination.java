package com.demo.salespro;

import java.io.File;
import java.io.FileWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		scrap();
//		FileWriter writer = createFile("");
//		addTextCheck(writer);
	}
	
	public static FileWriter createFile(String data) throws Exception{
		// Define the file path within the resources directory
        String filePath = "src/main/resources/example.txt";

        // Content to write to the file
        String content = "This is a text file created in the resources directory.";
        // Create a File object for the directory
        File directory = new File("src/main/resources/");

        // Create the directory if it doesn't exist
        if (!directory.exists()) {
            directory.mkdirs(); // Create parent directories if necessary
        }

        // Create a FileWriter object
        FileWriter writer = new FileWriter(filePath);

        // Write content to the file
        writer.write("");
        writer.append(data);
        // Close the FileWriter
        // writer.close();

        System.out.println("Text file created successfully.");

        return writer;
	}
	
	static  FileWriter cleanFile(FileWriter writer) throws Exception{
		writer.write("");
		return writer;
	}
	
	static  void addTextCheck(FileWriter writer) throws Exception{
		writer.write("");
		
		for(int i = 1; i <= 10; i++)
		{
			writer.append("Hello text: "+i+"\n");
		}
		writer.close();
	}
	
	public static void scrap() throws Exception{

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
		
		String mainUrl = "https://salepropos.com/demo/login";
		driver.get(mainUrl);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(mainUrl));
		driver.manage().window().maximize();
		
		sleep();
		
//		defaultWaitForSecureConnection(driver.getCurrentUrl());
		// Login
		
		WebElement username = driver.findElement(By.id("login-username"));
		username.clear();
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.id("login-password"));
		password.clear();
		password.sendKeys("admin");
		
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//body[1]/nav[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sale List')]")).click();
		sleep();
		int recordPerPage = Integer.parseInt(driver.findElement(By.xpath("//body/div[2]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/label[1]/div[1]/button[1]/span[1]")).getText());
		
//		defaultWaitForSecureConnection(driver.getCurrentUrl());
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement paginationLocation = driver.findElement(By.xpath("//div[@id='sale-table_paginate']"));
		
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", paginationLocation);
		
		
		System.out.println(recordPerPage);
		String tableInfo = driver.findElement(By.xpath("//div[@id='sale-table_info']")).getText();
//		int totalRecord = Integer.parseInt(tableInfo.substring(tableInfo.indexOf('(')+1,tableInfo.indexOf(')')));
//		System.out.println(totalRecord);
		
//		int page = (totalRecord / recordPerPage) * recordPerPage == totalRecord ? (totalRecord / recordPerPage) : (totalRecord / recordPerPage) + 1;
		
		int page = driver.findElements(By.xpath("//body[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[4]/ul[1]/li")).size();
		List<SalesItem> salesList = new ArrayList<>();
		for(int i = 3; i <= page; i++) {
			int pageItems = driver.findElements(By.xpath("//body[1]/div[2]/div[1]/section[1]/div[2]/div[1]/table[1]/tbody[1]/tr")).size();
			
			for(int j = 1; j < pageItems; j++)
			{
				SalesItem sale = new SalesItem();
				String date = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+j+"]/td[2]")).getText();
				sale.setReference(driver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+j+"]/td[3]")).getText());
				sale.setCustomer(driver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+j+"]/td[5]")).getText());
				sale.setBiller(driver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+j+"]/td[4]")).getText());
				sale.setDate(date);
				sale.setGrandTotal(Float.parseFloat(driver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+j+"]/td[9]")).getText().replace(",", "")));
//				sale.setPaid(Float.parseFloat(driver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+j+"]/td[11]")).getText()));
//				sale.setDue(Float.parseFloat(driver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+j+"]/td[12]")).getText()));
				salesList.add(sale);
				Thread.sleep(1000);
			}
			
			System.out.println("page item: "+pageItems);
			driver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[4]/ul[1]/li["+i+"]")).click();
			sleep();
		}
		
		System.out.println("Total sales item: "+salesList.size());
		
		FileWriter writer = createFile("");
		
		for(SalesItem item : salesList) {
			
			writer.append(item.toString());
				
		}
		writer.close();
	}

}
