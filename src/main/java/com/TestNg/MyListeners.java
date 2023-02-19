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

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class MyListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
	    LocalDateTime now = LocalDateTime.now();
	    String date = dtf.format(now);

		AShot ashot = new AShot();
		Screenshot sc = ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(TestBasae.driver);
		BufferedImage img = sc.getImage();
		try {
			ImageIO.write(img, "jpg", new File("E:\\Testing\\TestNGdemo\\screenshoots\\sc"+date+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
