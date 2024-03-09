package com.cochrane.medex;

import java.util.ArrayList;
import java.util.HashMap;
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
	
//	private Generic collectOthers(Generic generic, String url) {
//		driver = ScrapUtil.loadUrl(url);
//		List<WebElement> list = driver.findElements(By.xpath(""));
//		String bodyXpath = "//body/main[1]/div[1]/section[1]/div[1]/div[1]/div[3]/div[2]/div/div[@class='ac-body']";
//		//body/main[1]/div[1]/section[1]/div[1]/div[1]/div[3]/div[2]/div/div[@id='indications']
//		return generic;
//	}

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

	@Override
	public Generic scrapDetails(Generic generic, String url) {
		
		
		String genericItemUrl = url+"/"+generic.getId()+"/"+generic.getSlug();

		
		Map<String, String> map = new HashMap<>();
		String xPath = "//body/main[1]/div[1]/section[1]/div[1]/div[1]/div[3]/div[2]/div";
		
		ScrapUtil scrap = new ScrapUtil(genericItemUrl);
		List<WebElement> listDiv = scrap.driverInstance().findElements(By.xpath(xPath));

		int i = 1;

		for (WebElement div : listDiv) {
			String str = scrap.findValue(xPath + "[" + i + "]").strip();


			if (str.isBlank() || str.isEmpty()) {

			} else {


				String temp = str.toLowerCase();

				if (temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z') {
					String header = div.findElement(By.xpath(xPath + "[" + i + "]" + "/div/h4[@class='ac-header']"))
							.getText();
					String body = div.findElement(By.xpath(xPath + "[" + i + "]" + "/div[@class='ac-body']")).getAttribute("innerHTML");
					String headTemp = header.strip().toLowerCase().split(" ")[0];
					switch (headTemp) {
					case "indications":
						map.put("indication", body);
						generic.setIndication_details(body);
						break;
					case "composition":
						map.put("composition", body);
						generic.setComposition(body);
						break;
					case "pharmacology":
						generic.setMode_of_action(body);
						map.put("pharmacology", body);
						break;
					case "dosage":
						generic.setDosage(body);
						map.put("dosage", body);
						break;
					case "administration":
						generic.setAdministration(body);
						map.put("administration", body);
						break;
					case "interaction":
						generic.setInteraction(body);
						map.put("interaction", body);
						break;
					case "contraindications":
						generic.setContraindications(body);
						map.put("contraindications", body);
						break;
					case "side":
						generic.setSide_effects(body);
						map.put("side_effects", body);
						break;
					case "pregnancy":
						generic.setPregnancy_cat(body);
						map.put("pregnancy_lactation", body);
						break;
					case "precautions":
						generic.setPrecautions(body);
						map.put("precautions_warnings", body);
						break;
					case "use":
						generic.setPediatric_uses(body);
						map.put("pediatric_uses", body);
						break;
					case "storage":
						generic.setStorage_conditions(body);
						map.put("storage_conditions", body);
						break;
					case "therapeutic":
//						generic.setT(body);
						map.put("therapeutic_class", body);
						break;
					case "overdose":
						generic.setOverdose_effects(body);
						map.put("overdose_effects", body);
						break;
					}

				}

			}
			i++;
		}

		
		System.out.println(generic.toString());
		return generic;
	}
	
	

}
