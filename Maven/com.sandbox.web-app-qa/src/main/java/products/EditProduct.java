package products;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProduct {
	private static String EDIT_BUTTON;
	private static String SAVE_PROD_CHANGES;
	private static String SUCCESSFULLY_EDITED;
	
	public static void setEditButton(String editButtonXpath) {
		EDIT_BUTTON = editButtonXpath;
	}
	public static void setProductChangesEditForm(String saveEditedChangesXpath) {
		SAVE_PROD_CHANGES = saveEditedChangesXpath;
	}
	public static void setSuccessfullyEdited(String successfullyEditedMessageXpath) {
		SUCCESSFULLY_EDITED = successfullyEditedMessageXpath;
	}
	
	public static void clickEditButton(WebDriver wd) {
		wd.findElement(By.xpath(EDIT_BUTTON)).click();
	}
	public static void clickSaveEditedChanges(WebDriver wd) {
		wd.findElement(By.xpath(SAVE_PROD_CHANGES)).click();
	}
	
	public static String getSuccessfullyEditedXpath(){
		return SUCCESSFULLY_EDITED;
	}
	
	public static ArrayList<Double> increaseProductPrice(WebDriver wd) {
		clickEditButton(wd);
		List<WebElement> priceElements = wd.findElements(By.xpath("//*[contains(@name, 'price')]"));
		ArrayList<Double> prices1 = new ArrayList<Double>();
		for(int i =0;i<priceElements.size(); i++) {
			Double p = Double.valueOf(priceElements.get(i).getAttribute("value"));
			prices1.add(p);
			double price = p.doubleValue();
			price+=100.00;
			priceElements.get(i).clear();
			priceElements.get(i).sendKeys(String.valueOf(price));
		}
		clickSaveEditedChanges(wd);
		return prices1;
	}
}
