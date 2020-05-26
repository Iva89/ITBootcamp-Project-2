package registration_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

	private static String USERNAME;
	private static String EMAIL;
	private static String PASS;
	private static String CONFIRM_PASS;
	private static String SELECTBOX;
	private static String SUBMIT;
	private static String FORM_NAME;
	
	private static final String URL_START = "https://sandbox.2checkout.com/sandbox/home/dashboard";
	private static final String URL_SIGNUP ="https://sandbox.2checkout.com/sandbox/signup";
	
	public static void setUserName(String username) {
		USERNAME = username;
	}
	public static void setEmail(String email) {
		EMAIL = email;
	}
	public static void setPassword(String password) {
		PASS = password;;
	}
	public static void setConfirmPassword(String confirmPass) {
		CONFIRM_PASS = confirmPass;
	}
	public static void setSelectBox(String selectBox) {
		SELECTBOX = selectBox;
	}
	public static void setSubmit(String submit) {
		SUBMIT = submit;
	}
	public static void setFormName(String formName) {
		FORM_NAME = formName;
	}
	
	public static String getStartUrl() {
		return URL_START;
	}
	
	public static String getSignUpUrl() {
		return URL_SIGNUP;
	}
	
	public static String getUsernameXpath() {
		return USERNAME;
	}
	
	public static String getEmailXpath() {
		return EMAIL;
	}
	
	public static String getPasswordXpath() {
		return PASS;
	}
	
	public static String getConfirmPassXpath() {
		return CONFIRM_PASS;
	}
	
	public static String getFormName() {
		return FORM_NAME;
	}
	public static void inputUserName(WebDriver wd, String username) {//inputs username
		wd.findElement(By.name(USERNAME)).sendKeys(username);
	}
	
	public static void inputEMail(WebDriver wd, String email) {//inputs email
		wd.findElement(By.xpath(EMAIL)).sendKeys(email);
	}
	
	public static void inputPassword(WebDriver wd, String password) {//inputs password
		wd.findElement(By.xpath(PASS)).sendKeys(password);
	}
	
	public static void inputConfirmPassword(WebDriver wd, String confirmPassword) {//inputs password
		wd.findElement(By.xpath(CONFIRM_PASS)).sendKeys(confirmPassword);
	}
	
	 public static void selectOption5(WebDriver wd) {
		 Select option = new Select(wd.findElement(By.xpath(SELECTBOX)));
		 wd.findElement(By.xpath(SELECTBOX)).click();
		 option.selectByVisibleText("I just want to play in the sandbox");	
	 }
	 
	 public static void selectOption0(WebDriver wd) {
		 Select option = new Select(wd.findElement(By.xpath(SELECTBOX)));
		 wd.findElement(By.xpath(SELECTBOX)).click();
		 option.selectByVisibleText("- Tell us about yourself -");	
	 }
	 public static void clickSubmit(WebDriver wd) {
		 wd.findElement(By.xpath(SUBMIT)).click();
	 }
	 
	 public static void clickSignUp(WebDriver wd) {
		 wd.findElement(By.linkText("Sign up")).click();
	 }
	 
	
	
}
