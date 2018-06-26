package hris_testing.TATOC_maven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tatoc_frontpage{
	WebDriver driver;
	public Tatoc_frontpage(WebDriver driver)
	{
    	System.setProperty("webdriver.chrome.driver", "/home/qainfotech/eclipse-workspace/HRIS_maven/src/chromedriver");
		this.driver = driver;
	}
	 public void appLaunch(String urlofapp)
	 {
		 driver.get(urlofapp);
		 System.out.println("typed url by user" + "urlofapp");
	 }
	 public void basicCourse()
	 {
		 WebElement course1 = driver.findElement(By.linkText("Basic Course"));
		 Assert.assertTrue(course1.isDisplayed());
		 System.out.println("Basic Course is available on page");
	 }
	 	 public void advancedCourse()
	 {
		 WebElement course2 = driver.findElement(By.linkText("Advanced Course"));
		 Assert.assertTrue(course2.isDisplayed());
		 System.out.println("Advanced Course is available on page");

	 }
	 
	 
}
