package products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProduct {

	public static String ADD_NEW;
	public static String PROD_NAME;
	public static String PROD_ID;
	public static String PROD_DESC;
	public static String PROD_PRICE;
	public static String SAVE_CHANGES;
	public static String UPDATE_SUCCESSFUL;
	public static String VIEW_BUTTON;
	
	
	public static void setAddNew(String addNewLinkText) {
		ADD_NEW = addNewLinkText;
	}
	public static void setProdName(String prodNameXpath) {
		PROD_NAME =prodNameXpath;
	}
	public static void setProdId(String prodIdXpath) {
		PROD_ID =prodIdXpath;
	}
	public static void setProdDesc(String prodDescXpath) {
		PROD_DESC =prodDescXpath;
	}
	public static void setProdPrice(String prodPriceXpath) {
		PROD_PRICE =prodPriceXpath;
	}
	public static void setSaveChanges(String saveChangesXpath) {
		SAVE_CHANGES =saveChangesXpath;
	}
	public static void setUpdateSuccesful(String updateSuccessfullXpath) {
		UPDATE_SUCCESSFUL = updateSuccessfullXpath;
	}
	public static void setViewButton(String viewButtonXpath) {
		VIEW_BUTTON = viewButtonXpath;
	}
	
	
	public static void clickAddNew(WebDriver wd) {
		wd.findElement(By.linkText(ADD_NEW)).click();
	}
	public static void inputProdName(WebDriver wd, String name) {
		wd.findElement(By.xpath(PROD_NAME)).sendKeys(name);
	}
	public static void inputProdId(WebDriver wd, String id) {
		wd.findElement(By.xpath(PROD_ID)).sendKeys(id);
	}
	public static void inputProdDescription(WebDriver wd, String shortDescription) {
		wd.findElement(By.xpath(PROD_DESC)).sendKeys(shortDescription);
	}
	public static void inputPrice(WebDriver wd, String price) {
		wd.findElement(By.xpath(PROD_PRICE)).sendKeys(price);
	}
	public static void clickSaveChanges(WebDriver wd) {
		wd.findElement(By.xpath(SAVE_CHANGES)).click();
	}
	public static void clickViewButton(WebDriver wd) {
		wd.findElement(By.xpath(VIEW_BUTTON)).click();
	}
	
}
