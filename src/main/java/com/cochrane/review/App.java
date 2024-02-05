package com.cochrane.review;


import org.apache.commons.io.IOUtils;
import org.apache.maven.shared.utils.io.IOUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.thread.multitasking.ScrapCallable;
import com.thread.multitasking.ScrapReviewThread;
import com.thread.multitasking.ScrapThread;

public class App 
{
	private static int counter = 0;
	public static List<String> urlList  = new ArrayList<>();
    public static void main( String[] args ) throws IOException, InterruptedException
    {
//    	createTextFiles();
//    	numberChecker();
    	scrapFirst();
    }
    
    
    
    public static void createTextFiles() throws IOException
    {
    	// Specify the resource directory path (relative to project root)
        String resourceDirectory = "src/main/resources";

        // Get all files from the directory
        File directory = new File(resourceDirectory);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // Process each file (e.g., read content)
                System.out.println("File name: " + file.getName());
            }
        }
    }
    public static void createTextFile() throws IOException
    {
//    	List<String> classpathElements = null;
//    	System.out.println(App.class.getClassLoader().getResourceAsStream("META-INF"));

    	ClassLoader loader = ClassLoader.getSystemClassLoader();
	

//      System.out.println(loader+"\n"+loader.getResources("com/cochrane/review/App.class"));
    	
        
        
     // Specify the resource directory path
        String resourceDirectory = "com";

        // Get the ClassLoader
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        URL classLoader = ClassLoader.getSystemResource(resourceDirectory);
        

        // Get all resources from the directory
        try {
            Enumeration<URL> resources = classLoader.getResources(resourceDirectory);
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                try (InputStream inputStream = resource.openStream()) {
                    // Process the input stream (e.g., read content)
                    // For example, you can use BufferedReader to read text files line by line
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
//        try (InputStream is = App.class.getClassLoader().getResourceAsStream("META-INF/maven/dependencies.txt")) {
//            classpathElements =  IOUtils.readLines(is);
//        }
//
//        if (classpathElements != null) {
//            for (String element : classpathElements) {
//                System.out.println("Classpath Element: " + element);
//            }
//        }

    }
    
    
    public static void numberChecker()
    {
    	  int[] numbers = {2, 5, 8, 11, 14};

	        for (int number : numbers) {
	        	OddEvenCheck checker = new OddEvenCheck(number);
	            checker.start();
	            System.out.println(number +" : "+checker.getSquareValue());
	        }
    }
    
    public static void scrapFirst() throws InterruptedException
    {

//        List<Topic> topicList = scrapAllTopics();
    	
    	Topic topic = scrapSingleTopic();
//    	System.out.println(topic.toString());
    	scrapTable(topic);
        
//        int numThreads = topicList.size(); // Number of threads
        /**
        CountDownLatch latch = new CountDownLatch(numThreads);
        
        for(Topic topic : topicList)
        {
        	Thread thread = new ScrapThread(topic, topic.getTopicName());
        	thread.start();
        	thread.join();
        }
        
        **/
        
//        executive(topicList);
        
//        System.out.println("waiting for all thread to finish.............");
//        latch.await(); // wait for all threads to finish
//        System.out.println("app static List size: "+App.urlList.size());
//        System.out.println("size of topics: "+topicList.size());
    }
    
    
    
    
    public static void scrapTable(Topic topic)
    {
    	List<String> list = new ArrayList<>();
    	Document doc;
		try {
			doc = Jsoup.connect(topic.getTopicUrl()).get();
			Elements elements = doc.select("li.pagination-page-list-item>a");
			for (Element e : elements) {
				list.add(e.attr("href"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String item : list) {
			Thread thread = new ScrapReviewThread(item);
			thread.start();
		}
		System.out.println("finishing.................");
    }
    
    
    public static void executive(List<Topic> topicList)
    {
    	ExecutorService executor = Executors.newFixedThreadPool(topicList.size());
    	
    	System.out.println("number of topics: "+topicList.size());
    	List<List<String>> lists = new ArrayList<>();
    	for(int i = 0; i < topicList.size(); i++)
    	{
    		lists.add(new ArrayList<String>());
    	}
    	for(int i = 0; i < topicList.size(); i++)
    	{
//    		lists.set(i,  ) ;
    	}
    	
    	executor.shutdown();
    	
    	System.out.println("Executor service shutdown.............");
    }
    
    
    
    
    
    public static void scrapDetails(String url)
    {
    	List<String> list = new ArrayList<String>();
    	Document doc;
		try {
			doc = Jsoup.connect(url).get();
			
//			Elements elements = doc.select("h3.result-title > a");
			Elements elements = doc.select("li.pagination-page-list-item");
			
			for(Element e : elements)
			{
				list.add(e.attr("href"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println((++counter)+" => "+url+": "+list.size());
    }
    
    public static Topic scrapSingleTopic()
    {
    	Document doc;
		try {
			doc = Jsoup.connect("https://www.cochranelibrary.com/cdsr/reviews/topics").get();
			Element element = doc.getElementsByClass("browse-by-list-item").first();
			return new Topic(element.selectFirst("button.btn-link").text(),element.getElementsByAttribute("href").attr("href"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    	
    }
    
     public static List<Topic> scrapAllTopics()
    {
    	List<Topic> list = new ArrayList<Topic>();
    	Document doc;
		try {
			doc = Jsoup.connect("https://www.cochranelibrary.com/cdsr/reviews/topics").get();
			
			Elements elements = doc.getElementsByClass("browse-by-list-item");
			
			for(Element e : elements)
			{
//				System.out.println(e.selectFirst("button.btn-link").text());
				list.add( new Topic(e.selectFirst("button.btn-link").text(),e.getElementsByAttribute("href").attr("href")));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return list;
    	
    }
}
