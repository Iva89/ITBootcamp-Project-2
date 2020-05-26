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
		wd.get(SignUpPage.getStartUrl());
		wd.manage().window().maximize();
	}
	
	@AfterSuite
	public void AfterSuite() {
		wd.close();
	}
}
