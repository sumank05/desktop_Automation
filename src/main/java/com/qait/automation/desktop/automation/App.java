package com.qait.automation.desktop.automation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class App 
{   WebDriver driver;


    public void launchBrowser( )
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\sumankumawat\\Downloads\\chromedrivernew\\chromedriver.exe");
    	this.driver = new ChromeDriver();
    	driver.get("http://www.guru99.com/become-an-instructor.html");
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
		
		//Implicit Wait
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    public void enterInformation() throws IOException
    {
    	//Switching to iFrame
    	System.out.println("info me : "+driver);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	driver.switchTo().frame("JotFormIFrame-82892910187466");
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	WebElement nextButton = driver.findElement(By.xpath("//button[@id ='jfCard-welcome-start']"));
    	wait.until(ExpectedConditions.visibilityOf(nextButton));
    	js.executeScript("arguments[0].scrollIntoView();", nextButton);
    	nextButton.click(); 
    	
    	//Entering the value in FirstName
    	driver.findElement(By.xpath("//input[@id = 'first_28']")).sendKeys("Suman");
    	//Entering the value in LastName
    	driver.findElement(By.xpath("//input[@id = 'last_28']")).sendKeys("Kumawat");
    	//Clicking on Next button
    	WebDriverWait wait1 = new WebDriverWait(driver,5);
    	WebElement nextButton2 = driver.findElement(By.xpath("//div[@id = 'cid_28']//child::button[@class = 'jfInput-button forNext u-right']"));
    	wait1.until(ExpectedConditions.visibilityOf(nextButton2));
    	wait1.until(ExpectedConditions.elementToBeClickable(nextButton2));
    	
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].click();", nextButton2);
//    	if(nextButton2.isDisplayed()){
//    		System.out.println("button is displaying");
//    		nextButton2.click();
//    	 }
//    	 else{
//    	     System.out.println("Not Enabled");
//    	 }
    	
    	//Entering Email_id
    	driver.findElement(By.xpath("//input[@id = 'input_12']")).sendKeys("sumankumawat3334@gmail.com");
    	//Clicking on next button
    	driver.findElement(By.xpath("//div[@id = 'cid_12']//child::button[@class = 'jfInput-button forNext u-right']")).click();
    	
    	//Clicking on Yes Button
    	driver.findElement(By.xpath("//div[@id ='cid_62']//child::span[contains(text(),'YES')]")).click();
    	
    	//Clicking on Browse Button
    	WebElement browseButton = driver.findElement(By.xpath("//div[@id ='cid_86']//child::input[@name ='file']"));
    	JavascriptExecutor executorNew = (JavascriptExecutor)driver;
    	executorNew.executeScript("arguments[0].click();", browseButton);
    	//Browsing a file
    	Runtime.getRuntime().exec("C:\\Users\\sumankumawat\\Downloads\\AutoItFile\\FileUpload.exe");
    }
}
