package com.cochrane.medex;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrapUtil {
	
	private String url;
	private static WebDriver driver;

	public ScrapUtil(String url)
	{
		this.url = url;
		WebDriverManager.chromedriver().setup();
		if(driver == null) {
			driver = new ChromeDriver();			
		}
	}
	public ScrapUtil()
	{
		WebDriverManager.chromedriver().setup();
		if(driver == null) {
			driver = new ChromeDriver();			
		}
	}
	
	public WebDriver driverInstance() {
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver loadUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void closeInstance() {
		driver.close();
	}
	
	public String findValue(String xPath)
	{
		return driver.findElement(By.xpath(xPath)).getText();
//		return driver.findElement(By.xpath(xPath));
	}
	
	public static List<WebElement> findElements(String xPath){
		return driver.findElements(By.xpath(xPath));
	}
	
	
	
	public List<Generic> getAllTopic(String xPath){
		List<WebElement> elements = findElements(xPath);
		List<Generic> generics = new ArrayList<>();
		for(WebElement element : elements) {
//			generics.add(new Generic(element.getText(), element.getAttribute("href")));
			String href = element.getAttribute("href");
			String text = findValue(xPath+"/div/div[1]");
			
			System.out.println(href+" <=> "+text);
		}
		return generics;
	}
	
	
	
}
