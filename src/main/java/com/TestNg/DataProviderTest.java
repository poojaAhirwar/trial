package com.TestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviderTest {
// this will take data from dataprovider which we created
@Test(dataProvider="testdata")
public void TestChrome(String uname,String password){
System.setProperty("webdriver.chrome.driver", "E:\\Larkspur22A\\jars\\chromedriver(1).exe");
ChromeDriver driver = new ChromeDriver();

// Maximize browser
driver.manage().window().maximize();
// Load application
driver.get("https://twitter.com/login");
// Enter username
driver.findElement(By.xpath("//input[@autocomplete=\"username\"]")).sendKeys(uname);
driver.findElement(By.xpath("//div[@class=\"css-901oao r-1awozwy r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0\"]")).click();
// Enter password
driver.findElement(By.name("session[password]")).sendKeys(password);
}
@DataProvider(name="testdata")
public Object[][] TestDataFeed(){

// Create object array with 2 rows and 2 column- first parameter is row and second is //column
Object [][] twitterdata=new Object[2][2];

// Enter data to row 0 column 0
twitterdata[0][0]="username1@gmail.com";
// Enter data to row 0 column 1
twitterdata[0][1]="Password1";
// Enter data to row 1 column 0
twitterdata[1][0]="username2@gmail.com";
// Enter data to row 1 column 0
twitterdata[1][1]="Password2";
// return arrayobject to testscript
return twitterdata;
}
}