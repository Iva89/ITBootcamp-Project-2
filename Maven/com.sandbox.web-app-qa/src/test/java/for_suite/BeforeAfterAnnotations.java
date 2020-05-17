package for_suite;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import registration_login.SignUpPage;
import utility.ReadTextFile;


public class BeforeAfterAnnotations {
	public static WebDriver wd;
	
	
	@BeforeSuite
	public void BeforeSuite() {
		HashMap<String, String> mapa = ReadTextFile.getPathsMap();
		ReadTextFile.readMap(mapa);	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		wd = new ChromeDriver();
		wd.get(SignUpPage.URL_START);
		wd.manage().window().maximize();
	}
	
	
	//@BeforeTest
	//public void BeforeTest() {
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//wd = new ChromeDriver();
	//}

	//@BeforeClass
	//public void BeforeMethod() {
		//wd.get(SignUpPage.URL_START);
		//wd.manage().window().maximize();
	//}
	
	@AfterSuite
	public void AfterSuite() {
		wd.close();
	}
}
