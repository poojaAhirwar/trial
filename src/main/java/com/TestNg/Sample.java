package com.TestNg;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Sample {
	@BeforeSuite
	public void setUP() throws Exception {
		System.out.println("Before suite");
	}

	@Test
	public void verifyTitleOfHomePage() {
		String ExpectedTitle = "Amazon.com. Spend less. Smile more.";
		System.setProperty("webdriver.chrome.driver", "E:\\Larkspur22A\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

}
