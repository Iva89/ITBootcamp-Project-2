package registration_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	
	private static String LOG_OUT;
	private static String LOGGED_USERNAME;
	private static String USER_DATA;
	private static String PRODUCTS;
	
	private static final String URL_HOME = "https://sandbox.2checkout.com/sandbox/home/dashboard";
	
	public static void setLogOut(String logout) {
		LOG_OUT = logout;
	}
	
	public static void setLoggedUserName(String username) {
		LOGGED_USERNAME = username;
	}
	
	public static void clickLogOut(WebDriver wd) {
		wd.findElement(By.id(LOG_OUT)).click();
	}
	
	public static void setUserData(String user) {
		USER_DATA = user;
	}
	
	public static void setProducts(String productsLinkText) {
		PRODUCTS = productsLinkText;
	}
	
	public static void userData(WebDriver wd) {
		Actions act = new Actions(wd);
		WebElement e = wd.findElement(By.id("account-avatar"));
		act.moveToElement(e).click().build().perform();
	}
	
	public static String getLoggedUsername(WebDriver wd) {
		userData(wd);
		WebElement e = wd.findElement(By.id(HomePage.LOGGED_USERNAME));
		return e.getText();
	}
	
	public static void navigateToProductsPage(WebDriver wd) {
		wd.findElement(By.linkText(PRODUCTS)).click();
	}
	
	public static String getHomeUrl() {
		return URL_HOME;
	}
	
	public static String getUserData() {
		return USER_DATA;
	}
	
	public static String getLoggedUsenameId() {
		return LOGGED_USERNAME;
	}
}
