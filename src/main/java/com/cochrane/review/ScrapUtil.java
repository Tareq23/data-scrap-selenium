package com.cochrane.review;

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
	
	public WebDriver driverInstance() {
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public String findValue(String xPath)
	{
		return driver.findElement(By.xpath(xPath)).getText();
//		return driver.findElement(By.xpath(xPath));
	}
	
	private List<WebElement> findElements(String xPath){
		return driver.findElements(By.xpath(xPath));
	}
	
	//
	public List<Topic> getAllTopic(String xPath){
		List<WebElement> elements = findElements(xPath);
		List<Topic> topics = new ArrayList<>();
		for(WebElement element : elements) {
			topics.add(new Topic(element.getText(), element.getAttribute("href")));
		}
		return topics;
	}
	
	
	
}
