package com.cochrane.medex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericImp implements GenericService{

	private ScrapUtil scrap = new ScrapUtil();
	private WebDriver driver;
	private Map<String, String> xPaths;
	public GenericImp(Map<String, String> paths) {
		this.xPaths = paths;
	}
	
	@Override
	public Generic modify(Generic generic, String data) {
//		 TODO Auto-generated method stub
		return null;
	}
	
//	private WebElement
	
	private Generic collectOthers(Generic generic, String url) {
		driver = ScrapUtil.loadUrl(url);
		List<WebElement> list = driver.findElements(By.xpath(""));
		String bodyXpath = "//body/main[1]/div[1]/section[1]/div[1]/div[1]/div[3]/div[2]/div/div[@class='ac-body']";
		//body/main[1]/div[1]/section[1]/div[1]/div[1]/div[3]/div[2]/div/div[@id='indications']
		return generic;
	}

	@Override
	public List<Generic> collectList(List<WebElement> elements) {
		int i = 1;
		List<Generic> generics = new ArrayList<>();
		
		for(WebElement element : elements) {
//			element.
			Generic generic = new Generic();
			String url = element.findElement(By.xpath(xPaths.get("href")+"["+i+"]")).getAttribute("href");
			String[] href = url.split("/");
			String id  = href[href.length-2];
			String slug = href[href.length-1];
			String name = element.findElement(By.xpath(xPaths.get("href")+"["+i+"]/div/div[1]")).getText();
			generic.setId(id);
			generic.setSlug(slug);
			generic.setName(name);
			generics.add(generic);
			i++;
			
		}
		return generics;
	}

	@Override
	public WebDriver loadUrl(String url) {
		
		return scrap.loadUrl(url);
	}

	@Override
	public void write(List<Generic> generics) {

		
	}

}
