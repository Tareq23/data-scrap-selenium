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
//		GenericController genericController = new GenericController();
//		genericController.loadPages();
		checkDiv();

	}

	public static void checkDiv() {
		Map<String, String> map = new HashMap<>();
		String xPath = "//body/main[1]/div[1]/section[1]/div[1]/div[1]/div[3]/div[2]/div";
//		String url = "https://medex.com.bd/generics/611/biphasic-insulin-aspart";
		String url = "https://medex.com.bd/generics/2060/aclidinium-bromide-formoterol-fumarate";
		ScrapUtil scrap = new ScrapUtil(url);
		List<WebElement> listDiv = scrap.driverInstance().findElements(By.xpath(xPath));
		System.out.println(listDiv.size());
		int i = 1, cnt = 0;
		for (WebElement div : listDiv) {
			String str = scrap.findValue(xPath + "[" + i + "]").strip();

//			String ss = div.findElement(By.xpath("/div/h4[@class='ac-header']")).getText();
			if (str.isBlank() || str.isEmpty()) {
//				System.out.println("str["+i+"]: "+str);
			} else {
//				System.out.println("str["+i+"]: "+str);

				String temp = str.toLowerCase();
//				if(temp.ch)
				if (temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z') {
					String header = div.findElement(By.xpath(xPath + "[" + i + "]" + "/div/h4[@class='ac-header']"))
							.getText();
					String body = div.findElement(By.xpath(xPath + "[" + i + "]" + "/div[@class='ac-body']")).getText();
					String headTemp = header.strip().toLowerCase().split(" ")[0];
					switch (headTemp) {
					case "indications":
						map.put("indication", body);
						break;
					case "composition":
						map.put("composition", body);
						break;
					case "pharmacology":
						map.put("pharmacology", body);
						break;
					case "dosage":
						map.put("dosage", body);
						break;
					case "administration":
						map.put("administration", body);
						break;
					case "interaction":
						map.put("interaction", body);
						break;
					case "contraindications":
						map.put("contraindications", body);
						break;
					case "side":
						map.put("side_effects", body);
						break;
					case "pregnancy":
						map.put("pregnancy_lactation", body);
						break;
					case "precautions":
						map.put("precautions_warnings", body);
						break;
					case "use":
						map.put("pediatric_uses", body);
						break;
					case "storage":
						map.put("storage_conditions", body);
						break;
					case "therapeutic":
						map.put("therapeutic_class", body);
						break;
					case "overdose":
						map.put("overdose_effects", body);
						break;

					}
					System.out.println("str[" + i + "]'s header: " + headTemp);
//					System.out.println("str["+i+"]'s body: "+body);
					cnt++;
				}
//				String body = div.findElement(By.xpath("/div/h4[@class='ac-header']")).getText();
			}
			i++;
		}
		System.out.println("total item founded: " + map.size());
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
