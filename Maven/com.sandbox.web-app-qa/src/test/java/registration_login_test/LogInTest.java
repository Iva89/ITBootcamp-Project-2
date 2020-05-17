package registration_login_test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import for_suite.BeforeAfterAnnotations;
import registration_login.HomePage;
import registration_login.LogIn;


public class LogInTest extends BeforeAfterAnnotations{
	
	@Test
	public void logIn1_WithoutReg() {
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LogIn.inputUserName(wd, "dididi");
		LogIn.inputPass(wd, "Dididi111");
		WebDriverWait wait = new WebDriverWait(wd, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LogIn.LOGIN)));
		LogIn.clickLogIn(wd);
		Assert.assertTrue(wd.findElement(By.xpath(LogIn.LOGIN_ERROR)).isDisplayed());
		//test will pass if error message is displayed
	}

	@Test
	public void logIn2_RegisteredUser() {

		WebDriverWait wait = new WebDriverWait(wd, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LogIn.USERNAME_LOGIN)));
		LogIn.inputUserName(wd, "jjosling1");
		LogIn.inputPass(wd, "QNo54LQb4wv");
		LogIn.clickLogIn(wd);
		Assert.assertEquals(wd.getCurrentUrl(), HomePage.URL_HOME);
		//if user is logged in, website will navigate to home page
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-avatar")));
		HomePage.userData(wd);
		HomePage.clickLogOut(wd);
	}
}
