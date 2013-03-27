package com.sudeeptest.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
	public WebDriver getChrome(){
		return new ChromeDriver();
	}
}
