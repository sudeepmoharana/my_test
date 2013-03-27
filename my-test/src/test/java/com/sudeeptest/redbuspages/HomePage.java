package com.sudeeptest.redbuspages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	private long defaultTimeout;

	@FindBy(id = "DDLSource")
	private WebElement sourceTextBox;
	@FindBy(id = "DDLDestination")
	private WebElement destinationTextBox;
	@FindBy(xpath = "//*[@id=\"routeSearchMain\"]/div[2]/div[1]/img")
	private WebElement onwardJourneyCalendar;
	@FindBy(id = "searchBtn")
	private WebElement searchButton;

	public HomePage(WebDriver driver, long defaultTimeout) {
		this.driver = driver;
		this.defaultTimeout = defaultTimeout;
		PageFactory.initElements(this.driver, this);
		this.driver.manage().timeouts()
				.implicitlyWait(this.defaultTimeout, TimeUnit.SECONDS);
	}

	public void enterSourceDestinationPair(String source, String destination) {
		this.sourceTextBox.clear();
		this.sourceTextBox.sendKeys(source);
		this.destinationTextBox.clear();
		this.destinationTextBox.sendKeys(destination);
	}

	public void chooseDate(String date) {
		this.onwardJourneyCalendar.click();
		driver.findElement(By.linkText(date)).click();
	}

	public SearchResultsPage doFormSubmit() {
		this.searchButton.click();
		return new SearchResultsPage(this.driver, this.defaultTimeout);
	}
}
