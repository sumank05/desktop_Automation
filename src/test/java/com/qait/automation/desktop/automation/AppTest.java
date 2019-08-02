package com.qait.automation.desktop.automation;

import java.io.IOException;

import org.testng.annotations.Test;


public class AppTest 
{
    App obj  = new App();

   @Test
   public void launchingWebsite()
   {
	   obj.launchBrowser();
   }
   
   @Test (dependsOnMethods = "launchingWebsite")
   public void enterUserInfo() throws IOException
   {
	   obj.enterInformation(); 
   }
}
