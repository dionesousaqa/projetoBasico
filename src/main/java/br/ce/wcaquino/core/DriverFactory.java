package br.ce.wcaquino.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {}
		
	public static WebDriver getDriver() {
		if(driver == null) { 
			switch(Propriedades.browser) {
			
			case FIREFOX:WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();break;
			case CHROME : driver = new ChromeDriver();break;
			case EDGE: driver = new EdgeDriver();break;
				
			}
			
//			WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension(1200,765));
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null) {
		driver.close();
		driver = null ;
		}
		
	}
}
	


