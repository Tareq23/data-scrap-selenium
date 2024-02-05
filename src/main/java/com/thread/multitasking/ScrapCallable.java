package com.thread.multitasking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cochrane.review.App;
import com.cochrane.review.Topic;

public class ScrapCallable implements Callable<List<String>> {
	private Topic topic;
	List<String> list;
//	public ScrapCallable(Topic topic, String threadName) {
//		super(threadName);
//		this.topic = topic;
//	}
	
	public ScrapCallable(Topic topic)
	{
		 list = new ArrayList<String>();
		 this.topic = topic;
	}

	@Override
	public List<String> call()
	{
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
		return list;
	}

}
