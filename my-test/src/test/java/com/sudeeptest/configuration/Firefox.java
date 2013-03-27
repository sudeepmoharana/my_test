package com.sudeeptest.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {
	public WebDriver getFirefox(){
		return new FirefoxDriver();
	}
}
