package com.sudeeptest.app;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sudeeptest.redbuspages.HomePage;
import com.sudeeptest.redbuspages.SearchResultsPage;

public class RedBusSearchTest {
	
	private WebDriver driver;
	private long defaultTimeout = 30;
	private String baseUrl = "http://www.redbus.in/";
	
	@BeforeTest(alwaysRun = true)
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test()
	public void testSearch(){
		HomePage homePage = new HomePage(driver, defaultTimeout);
		homePage.enterSourceDestinationPair("Bangalore", "Hyderabad");
		homePage.chooseDate("30");
		SearchResultsPage searchResultsPage = homePage.doFormSubmit();
		Assert.assertTrue(searchResultsPage.areSearchResultsDisplayed());
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
}
