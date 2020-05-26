package registration_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn {

	private static String USERNAME_LOGIN;
	private static String PASS_LOGIN;
	private static String LOGIN;
	private static String LOGIN_ERROR;
	
	public static void setUsernameLogin(String usernameLogin) {
		USERNAME_LOGIN = usernameLogin;
	}
	public static void setPassLogin(String passLogin) {
		PASS_LOGIN = passLogin;
	}
	
	public static void setLogIn(String loginClassLocator) {
		LOGIN = loginClassLocator;
	}
	
	public static void setLogInError(String loginError) {
		LOGIN_ERROR = loginError;
	}
	
	public static String getUserNameLoginXpath() {
		return USERNAME_LOGIN;
	}
	
	public static String getLogInErrorXpath() {
		return LOGIN_ERROR;
	}
	
	public static String getLoginXpath() {
		return LOGIN;
	}
	
	public static void inputUserName(WebDriver wd, String username) {
		wd.findElement(By.xpath(USERNAME_LOGIN)).sendKeys(username);
	}
	
	public static void inputPass(WebDriver wd, String password) {
		wd.findElement(By.xpath(PASS_LOGIN)).sendKeys(password);
	}
	
	 public static void clickLogIn(WebDriver wd) {
		 wd.findElement(By.xpath(LOGIN)).click();
	 }
	 
}
