package com.TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBasae {
	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://amazon.com/");

	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
