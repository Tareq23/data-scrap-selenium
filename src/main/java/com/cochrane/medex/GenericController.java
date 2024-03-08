package com.cochrane.medex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class GenericController {

	private String url = "https://medex.com.bd/generics";
	private int totalPage;
	private WebDriver driver;
	private String xPathLeft;
	private String xPathRight;
	
	private GenericImp genImp;
	
	private List<Generic> list ;
	
	public GenericController()
	{
		list = new ArrayList<>();
		xPathLeft = "//body[1]/main[1]/div[1]/section[1]/div[1]/div[2]/div[1]/a";
		xPathRight = "//body[1]/main[1]/div[1]/section[1]/div[1]/div[2]/div[2]/a";
		genImp = new GenericImp(allXPath());
		totalPage = 81;
	}
	
	private Map<String, String> allXPath() {
		Map<String, String> paths = new HashMap<>();
		paths.put("href", "//body[1]/main[1]/div[1]/section[1]/div[1]/div[2]/div/a");
		paths.put("name", "//body[1]/main[1]/div[1]/section[1]/div[1]/div[2]/div/a/div/div[1]");
		return paths;
	}

	public void loadPages() throws Exception{
		
		for(int i = 1; i <= totalPage; i++)
		{
			driver = ScrapUtil.loadUrl(url+"?page="+i);
			list.addAll(genImp.collectList(ScrapUtil.findElements(xPathLeft)));
			list.addAll(genImp.collectList(ScrapUtil.findElements(xPathRight)));
		}
		
		System.out.println("generics length: "+list.size());
		
	}
	
}
