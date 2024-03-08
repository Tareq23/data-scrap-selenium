package com.thread.multitasking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cochrane.review.App;
import com.cochrane.review.Topic;

public class ScrapThread extends Thread {
	private Topic topic;

	public ScrapThread(Topic topic, String threadName) {
		super(threadName);
		this.topic = topic;
	}

	public void run() {
		List<String> list = new ArrayList<String>();
		Document doc;
		try {
			doc = Jsoup.connect(this.topic.getTopicUrl()).get();
			Elements elements = doc.select("li.pagination-page-list-item>a");
			for (Element e : elements) {
				list.add(e.attr("href"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		App.urlList.addAll(list);
//		System.out.println("Inside " + Thread.currentThread().getName() + " , listOfTopicPage: " + list.size());
//		list.stream().forEach(System.out::println);
	}

}
