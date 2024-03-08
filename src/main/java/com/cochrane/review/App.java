package com.cochrane.review;

import java.util.List;

public class App 
{
	private static String url = "https://www.cochranelibrary.com/cdsr/reviews/topics";
	
	public static void main(String[] args){
		
		ScrapUtil scrap = new ScrapUtil(url);
		
		scrap.driverInstance();
		
		List<Topic> topics = scrap.getAllTopic("//div[2]/div[1]/div/dl/dd/ul/li/a");
		System.out.println(topics);
		
		for(Topic topic : topics) {
			
		}
	}
}
