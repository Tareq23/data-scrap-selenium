package com.cochrane.medex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bouncycastle.pqc.jcajce.provider.lms.LMSSignatureSpi.generic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

/* xpath for generics: //body/main/div/section[@class='section']/div[@class='container']/div[@class='row']/div[@class='col-lg-7 col-md-12']/div[@class='generic-data-container en']/div
 * 
 * 
 */

public class App {
	private static String url = "https://medex.com.bd/generics";

	public static void main(String[] args) throws Exception {
		GenericController genericController = new GenericController();
		genericController.loadPages();
		genericController.collectAllGenericsInDetails();
	}

	
	public static void restOf() throws Exception {
		ScrapUtil scrap = new ScrapUtil(url);
//		
//		scrap.driverInstance();
//		body[1]/main[1]/div[1]/section[1]/div[1]/div[2]/div/a/div/div[1]
//		List<Generic> generics = scrap.getAllTopic("//body[1]/main[1]/div[1]/section[1]/div[1]/div[2]/div/a");
//		System.out.println(generics);
		scrap.driverInstance();

//		String genericsPageSource = scrap.loadUrl("https://medex.com.bd/generics/2105/17-v-estradiol").getPageSource();
		String dosageFormPageSource = scrap.loadUrl("https://medex.com.bd/dosage-forms/179/bolus-tablet")
				.getPageSource();
		System.out.println(dosageFormPageSource + "\n\n\n\n");

		for (int i = 1; i <= 0; i++) {
//			ScrapUtil scrap = new ScrapUtil(url+"?page="+i);
			scrap.loadUrl(url + "?page=" + i);
			List<Generic> generics = scrap.getAllTopic("//body[1]/main[1]/div[1]/section[1]/div[1]/div[2]/div/a");
			Thread.sleep(1000);
//			scrap.closeInstance();
		}

//		for(Generic generic : generics) {
//			
//		}
	}
}
