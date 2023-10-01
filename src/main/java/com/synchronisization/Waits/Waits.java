package com.synchronisization.Waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	static WebDriver driver;

	public static void main(String[] args) {
	}

	static void fluentwait(WebElement element, int time, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(StaleElementReferenceException.class);
	}

	static void elementToBeClickable(By locater) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(locater)).click();
	}

	static WebElement waitForElementToVisible(By locater) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locater));

	}

	static void elementToVisible(WebDriver driver, WebElement element, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element)).click();
	}

	static WebDriverWait waitForElementToPresent(By locater, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(locater)).click();
		return wait;
	}

	static void clickOn(By locater, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);

		wait.until(ExpectedConditions.elementToBeClickable(locater)).click();

	}
}
