package com.synchronisization.Waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitTImeOut {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");

		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		WebElement searchbutton = driver.findElement(By.id("nav-search-submit-button"));
		searchbox.sendKeys("vivo phone with 50000 rupees");
		searchbutton.click();
		
		
//		implicitly timeout apply only for web elements
//		it is a global wait it applicable for all web elements
//		implicitly time out not applicable for windows,title.alearts,URL.....etc

	}

}
