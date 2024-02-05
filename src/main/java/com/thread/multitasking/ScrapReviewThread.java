package com.thread.multitasking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cochrane.review.Topic;

public class ScrapReviewThread extends Thread{
	private String url;
	private Document doc;
	
	public ScrapReviewThread(String url){
		this.url = url;
//		System.out.println("Url : "+this.url);
	}
	
	public void run() {
		
		try {
			doc = Jsoup.connect(this.url).get();
			Elements elements = doc.select("div.search-results-item-body>h3>a");
			System.out.println(""+this.url);
			System.out.println("elements size: "+elements.size());
			for(Element e : elements)
			{
				System.out.println("review thread: "+e);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
