package hris_testing.TATOC_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class cookieGeneration {

	WebDriver driver;
	
	public cookieGeneration(WebDriver driver)
	{
		this.driver = driver;
	}
	public void cookieGenerationProcessChecking()
	{
		driver.findElement(By.linkText("Generate Token")).click(); 
        String Token = driver.findElement(By.id("token")).getText();
        String substring1=Token.substring(7);
        Cookie name = new Cookie("Token", substring1);
		  driver.manage().addCookie(name);
		  driver.findElement(By.linkText("Proceed")).click(); 
		  String expectedUrl = "http://10.0.1.86/tatoc/end";
	        Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
	}
}
