package hris_testing.TATOC_maven;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class launchPopup {

	WebDriver driver;
	
	public launchPopup(WebDriver driver)
	{
		this.driver = driver;
	}
	public void popupWindowIsLaunched()
	{
		driver.findElement(By.linkText("Launch Popup Window")).click();
		ArrayList<String> windowsList=new ArrayList(driver.getWindowHandles());
        String windows1=  (windowsList.get(1));
        driver.switchTo().window(windows1);
        driver.findElement(By.id("name")).sendKeys("Puneet Nagar");
        driver.findElement(By.id("submit")).click();
        String windows2=(windowsList.get(0));
        driver.switchTo().window(windows2);
        driver.findElement(By.linkText("Proceed")).click();
        String expectedUrl = "http://10.0.1.86/tatoc/basic/cookie";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
	}
}
