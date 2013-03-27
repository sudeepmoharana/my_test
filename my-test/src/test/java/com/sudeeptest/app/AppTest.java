package com.sudeeptest.app;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sudeeptest.configuration.Chrome;
import com.sudeeptest.configuration.Firefox;

public class AppTest {
	private WebDriver driver;
	
	public void setBrowserType(String browser) {
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new Chrome().getChrome();
		}
		if(browser.equals("Firefox")) {
			driver = new Firefox().getFirefox();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Parameters({"browser"})
	@Test
	public void testApp(String browser) {
		setBrowserType(browser);
		driver.get("http://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("btnG")).click();
		Assert.assertTrue(driver.findElements(By.partialLinkText("Selenium")).size() > 0);
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}
