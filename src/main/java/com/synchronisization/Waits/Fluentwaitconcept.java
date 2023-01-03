package com.synchronisization.Waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.hc.client5.http.async.methods.IgnoreCompleteExceptonFutureCallback;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fluentwaitconcept {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://demoqa.com/text-box");
		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.findElement(By.id("userName")).sendKeys("testing");
		 driver.findElement(By.id("userEmail")).sendKeys("testing@gmail.com");
		 driver.findElement(By.id("currentAddress")).sendKeys("chittoor");
		 driver.findElement(By.id("permanentAddress")).sendKeys("AP");
		WebElement submit = driver.findElement(By.id("submit"));
		fluentwait(submit, 20, 3);
//		submit.click();
		 
	}
	static  void fluentwait(WebElement element ,int time,int polligtime) {
		Wait<WebDriver>wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofSeconds(polligtime)).ignoring(StaleElementReferenceException.class);
	}

}
