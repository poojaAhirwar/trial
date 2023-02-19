package com.TestNg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class A {
	@Test
	public void takeScreenshoot() throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\Larkspur22A\\jars\\chromedriver(1).exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
	    LocalDateTime now = LocalDateTime.now();
	    String date = dtf.format(now);

		AShot ashot = new AShot();
		Screenshot sc = ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
		BufferedImage img = sc.getImage();
		try {
			ImageIO.write(img, "jpg", new File("E:\\Testing\\TestNGdemo\\screenshoots\\sc"+date+".jpg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

	
	 /* public static String currentDateTime() { DateFormat dateFormat = new
	  SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); Calendar cal =
	  Calendar.getInstance(); String call = dateFormat.format(cal.getTime());
	  return call;
	  
	  }*/
	 

}
