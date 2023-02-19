package com.TestNg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListeners.class)
public class Tests extends TestBasae {
	@Test
	public void verifySearchElements() {
		System.setProperty("webdriver.chrome.driver", "F:\\Larkspur22A\\jars\\chromedriver(1).exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//select[@title=\"Search in\"]")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//select[@title=\"Search in\"]//child::option"));
		for (WebElement element : elements) {
			String elementNames = element.getText();
			Assert.assertTrue(!elementNames.isEmpty());
			driver.close();
		}
	}
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void verifySlectedElement() throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\Larkspur22A\\jars\\chromedriver(1).exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://amazon.com/");

		WebElement we = driver.findElement(By.xpath(
				"//select[@class=\"nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown\"]"));
		Select select = new Select(we);
		select.selectByVisibleText("Baby");
		driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
		List<WebElement> products = driver.findElements(By.xpath("//select[@title=\"Search in\"]//child::option"));
		for (WebElement product : products) {
			String productNames = product.getText();
			Assert.assertTrue(!productNames.isEmpty());
			driver.close();
		}
	}

}
