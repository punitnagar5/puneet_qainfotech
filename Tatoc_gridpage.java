package hris_testing.TATOC_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tatoc_gridpage {
	
	WebDriver driver;
	public Tatoc_gridpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void selectBasicCourse()
	 {
		driver.findElement(By.linkText("Basic Course")).click();
		String expectedUrl = "http://10.0.1.86/tatoc/basic/grid/gate";
		String currentUrl = driver.getCurrentUrl();
		if(expectedUrl.equals(currentUrl))
		{
			System.out.println("we moved in Basic Course");
		}
		else 
		{
			System.out.println("not moved");
		}
	 }
	public void redBoxIsClickedSoMoveToErrorPage()
	{
		driver.findElement(By.className("redbox")).click();
		String expectedurl = "http://10.0.1.86/tatoc/error";
		String currentUrl = driver.getCurrentUrl();
		if(expectedurl.equals(currentUrl))
		{
			System.out.println("you clicked red box so you are on error page");
		}
		else
		{
			System.out.println("you are not on error page");
		}
		driver.navigate().back();
	}
	
	public void greenBoxIsClickedSoMoveToFrameDungeonPage()
	{
		driver.findElement(By.className("greenbox")).click();
		String expectedurl = "http://10.0.1.86/tatoc/basic/frame/dungeon";
		String currentUrl = driver.getCurrentUrl();
		if(expectedurl.equals(currentUrl))
		{
			System.out.println("you clicked green box then Frame Dungeon page will open");
		}
		else
		{
			System.out.println("you are on error page");
		}
	}
	
	

}
