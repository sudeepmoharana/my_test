package com.sudeeptest.redbuspages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

	private WebDriver driver;
	private long defaultTimeout;

	@FindBy(className = "i210")
	private List<WebElement> searchResults;

	public SearchResultsPage(WebDriver driver, long defaultTimeout) {
		this.driver = driver;
		this.defaultTimeout = defaultTimeout;
		PageFactory.initElements(this.driver, this);
		this.driver.manage().timeouts()
				.implicitlyWait(this.defaultTimeout, TimeUnit.SECONDS);
	}

	public boolean areSearchResultsDisplayed() {
		return searchResults.size() > 0;
	}

}
