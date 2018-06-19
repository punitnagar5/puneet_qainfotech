import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import org.openqa.selenium.interactions.Actions;


public class tatocSolution
{
	WebDriver driver = new ChromeDriver();
	
	public static void main(String args[]) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		
		greenBox(driver);
		frame_Dungeon(driver);
		Drag_Around(driver);
		Pop_window(driver);
		Generate_Cookie(driver);
		
	}
	
	
	public static void greenBox(WebDriver driver)
	{
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.className("greenbox")).click();
	}
	
	
	
	public static void frame_Dungeon(WebDriver driver)
	{
		WebElement frame1= driver.findElement(By.id("main"));
		driver.switchTo().frame(frame1);
		String Box1= driver.findElement(By.id("answer")).getAttribute("class");
		WebElement frame2 =driver.findElement(By.id("child"));
		driver.switchTo().frame(frame2);
		String Box2 = driver.findElement(By.id("answer")).getAttribute("class");
		driver.switchTo().defaultContent();
		while(Box1.equals(Box2) != true)
		{
			driver.switchTo().frame(frame1);
			driver.findElement(By.linkText("Repaint Box 2")).click();
			driver.switchTo().frame(frame2);
			Box2 = driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().defaultContent();

		}
			driver.switchTo().frame(frame1);
			driver.findElement(By.linkText("Proceed")).click();

	}
	public static void Drag_Around(WebDriver driver)
	{
		Actions act = new Actions(driver);
		WebElement drag= driver.findElement(By.id("dragbox"));
		WebElement drop = driver.findElement(By.id("dropbox"));
		act.dragAndDrop(drag, drop).build().perform();
		driver.findElement(By.linkText("Proceed")).click();

	}
	public static void Pop_window(WebDriver driver)
	{
		driver.findElement(By.linkText("Launch Popup Window")).click();
		ArrayList windowsList=new ArrayList(driver.getWindowHandles());
        String windows1= ((String)windowsList.get(1));
        driver.switchTo().window(windows1);
        driver.findElement(By.id("name")).sendKeys("Puneet");
        driver.findElement(By.id("submit")).click();
        String windows2=(String)(windowsList.get(0));
        driver.switchTo().window(windows2);
        driver.findElement(By.linkText("Proceed")).click();
	}
	public static void Generate_Cookie(WebDriver driver)
	{
		driver.findElement(By.linkText("Generate Token")).click(); 
        String Token = driver.findElement(By.id("token")).getText();
        String substring1=Token.substring(7);
        Cookie name = new Cookie("Token", substring1);
		  driver.manage().addCookie(name);
		  
		driver.findElement(By.linkText("Proceed")).click(); 
        
	}
	
				
}