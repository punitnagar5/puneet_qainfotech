package hris_testing.TATOC_maven;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCasesOfTATOC {
	WebDriver driver;
	Tatoc_frontpage mainpage;
	Tatoc_gridpage secondpage;
	Frame_dungeon thirdpage;
	draganddrop forthpage;
	launchPopup fifthpage;
	cookieGeneration sixthpage;
	
	
	public TestCasesOfTATOC()
	{
		driver = new ChromeDriver();
		mainpage = new Tatoc_frontpage(driver);
		secondpage = new Tatoc_gridpage(driver);
		thirdpage = new Frame_dungeon(driver);
		forthpage = new draganddrop(driver);
		fifthpage = new launchPopup(driver);
		sixthpage = new cookieGeneration(driver);
	}
	
	@Test
	public void testHomePage()
	{
		mainpage.appLaunch("http://10.0.1.86/tatoc");
		mainpage.basicCourse();
		mainpage.advancedCourse();
		

		
	}
	
	@Test (dependsOnMethods= "testHomePage")
	public void testgridpage()
	{
		secondpage.selectBasicCourse();
		secondpage.redBoxIsClickedSoMoveToErrorPage();
		secondpage.greenBoxIsClickedSoMoveToFrameDungeonPage();
	}
	
	@Test (dependsOnMethods = "testgridpage")
	public void TestFrameWhenColorIsMatched()
	{
		thirdpage.clickWhenColorOfBoxesAreSame();
	
	}
	
	@Test (dependsOnMethods = "TestFrameWhenColorIsMatched")
	public void TestTheBoxIsPlacedInField()
	{
		forthpage.placeTheBoxInsideTheField();
	}
	
	@Test (dependsOnMethods = "TestTheBoxIsPlacedInField")
	public void testThatpopupWindowIsLaunched()
	{
		fifthpage.popupWindowIsLaunched();
	}
	
	@Test (dependsOnMethods = "testThatpopupWindowIsLaunched")
	public void testTheCookieGeneration()
	{
		sixthpage.cookieGenerationProcessChecking();
	}
		}
