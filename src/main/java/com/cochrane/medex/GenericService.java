package com.cochrane.medex;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface GenericService {
	
	
	WebDriver loadUrl(String url);
	
	// extract field and data from string data and store it and return;
	Generic modify(Generic generic, String data);
	
	// collect generic list
	List<Generic> collectList(List<WebElement> element);
	
	
	void write(List<Generic> generics);
	
	Generic scrapDetails(Generic generic, String url);
	
}
