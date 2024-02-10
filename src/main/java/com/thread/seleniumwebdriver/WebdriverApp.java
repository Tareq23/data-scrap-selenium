package com.thread.seleniumwebdriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cochrane.review.Topic;

public class WebdriverApp {

	public static void main(String[] args) {
		
		String rootUrl = "http://www.cochranelibrary.com/home/topic-and-review-group-list.html?page=topic";
		mozillaDriver(rootUrl);
		
	}
	
	public static void chromeDriver(String url)
	{
		System.setProperty("webdriver.chrome.driver",
				"D:/Soft/selenium-webdriver/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		System.out.println(driver.getTitle());
	}
	
	public static void mozillaDriver(String url)
	{
		System.setProperty("webdriver.gecko.driver",
				"D:\\Soft\\selenium-webdriver\\geckodriver-v0.34.0-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		System.out.println(driver.hashCode());
//		driver.get(url);
		
		singleLinkScrap(driver);
		
//		List<WebElement> row = driver.findElements(By.xpath("//ul[@class='browse-by-term-list']/li/a/button"));
//		List<WebElement> row = driver.findElements(By.xpath("//ul[@class='browse-by-term-list']/li/a"));
		
//		System.out.println("Size of elements: "+row.size());
//		List<Topic> topicList = new ArrayList<>();
//		for(WebElement element : row)
//		{
//			System.out.println(element.getAttribute("href"));
//			System.out.println(element.getText());
//			topicList.add(new Topic(element.getText(), element.getAttribute("href")));
//		}
//		
//		
//		Thread[] threads = new Thread[topicList.size()];
//        for (int i = 0; i < topicList.size(); i++) {
//            WebDriver drivers = new ChromeDriver(); // Initialize WebDriver for each thread
//            threads[i] = new Thread(new ScrapingTask(drivers, urls[i]));
//            threads[i].start(); // Start the thread
//        }
//		
		
		driver.quit();
		
		
	}
	
	
	public static void singleLinkScrap(WebDriver driver)
	{
		System.out.println(driver.hashCode());
		String url = "https://www.cochranelibrary.com/en/search?p_p_id=scolarissearchresultsportlet_WAR_scolarissearchresults&p_p_liAllergy+%26+intolerfecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_scolarissearchresultsportlet_WAR_scolarissearchresults_displayText=Allergy+%26+intolerance&_scolarissearchresultsportlet_WAR_scolarissearchresults_searchText=Allergy+%26+intolerance&_scolarissearchresultsportlet_WAR_scolarissearchresults_searchType=basic&_scolarissearchresultsportlet_WAR_scolarissearchresults_facetQueryField=topic_id&_scolarissearchresultsportlet_WAR_scolarissearchresults_searchBy=13&_scolarissearchresultsportlet_WAR_scolarissearchresults_orderBy=displayDate-true&_scolarissearchresultsportlet_WAR_scolarissearchresults_facetDisplayName=Allergy+%26+intolerance&_scolarissearchresultsportlet_WAR_scolarissearchresults_facetQueryTerm=z1506030924307755598196034641807&_scolarissearchresultsportlet_WAR_scolarissearchresults_facetCategory=Topics";
//		String url = "https://www.cochranelibrary.com/en/search?min_year=&max_year=&custom_min_year=&custom_max_year=&searchBy=13&searchText=Allergy+%26+intolerance&selectedType=review&isWordVariations=&resultPerPage=25&searchType=basic&orderBy=displayDate-true&publishDateTo=&publishDateFrom=&publishYearTo=&publishYearFrom=&displayText=Allergy+%26+intolerance&forceTypeSelection=true&facetDisplayName=Allergy+%26+intolerance&facetQueryTerm=z1506030924307755598196034641807&facetQueryField=topic_id&facetCategory=Topics&p_p_id=scolarissearchresultsportlet_WAR_scolarissearchresults&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&cur=3";
		driver.get(url);
		String xpath = "//ul[@class='pagination-page-list']/li";
		String cssSelector = ".pagination-page-list > li > a";
		
		
//		
//		List<WebElement> linkList = driver.findElements(By.cssSelector(cssSelector));
//		
//		for(WebElement e : linkList) {
//			e.click();
////			String link = e.getAttribute("href");
////			WebDriver driver = 
//			System.out.println(e.getAttribute("href"));
//			
//		}
//		System.out.println("size: "+linkList.size());
//		
		
		int pageSize = driver.findElements(By.cssSelector(cssSelector)).size();
		
		System.out.println("page size: "+pageSize);
		
		
		
		
		for(int i = 1; i <= pageSize; i++) {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			String xPath = "(//ul[@class='pagination-page-list']/li/a)["+i+"]";
			String paginationSelector = ".pagination-page-list > li > a:nth-child("+2+")";
//			try {Thread.sleep(500);}catch(Exception e) {}
//			WebElement webElement = driver.findElement(By.cssSelector(paginationSelector));
			WebElement webElement = driver.findElement(By.xpath(xPath));
			
			System.out.println("webElement");
			JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".spinner-container")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);

//			webElement.click();
			
			System.out.println("text: "+webElement.getText());
			
		}
		
		
		System.out.println("singlelink scrap done");
	}
	
	
	

}
