package products_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import for_suite.BeforeAfterAnnotations;
import products.EditProduct;
import registration_login.HomePage;
import registration_login.LogIn;

public class EditProductTest extends BeforeAfterAnnotations{

	@Test
	public void increaseProductPriceTest() {
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LogIn.inputUserName(wd, "jjosling1");
		LogIn.inputPass(wd, "QNo54LQb4wv");
		LogIn.clickLogIn(wd);
		HomePage.navigateToProductsPage(wd);
		ArrayList<Double> originalPrices = EditProduct.increaseProductPrice(wd);
		List<WebElement> newPricesWebE = wd.findElements(By.xpath("//*[contains(@name, 'price')]"));
		if (wd.findElement(By.xpath(EditProduct.SUCCESSFULLY_EDITED)).isDisplayed()) {
			SoftAssert sa = new SoftAssert();
			for (int i = 0; i < originalPrices.size(); i++) {
				double actual = Double.valueOf(newPricesWebE.get(i).getAttribute("value")).doubleValue();
				double expected = (originalPrices.get(i)).doubleValue() + 100.00;
				sa.assertEquals(actual, expected);
			}
			sa.assertAll();
			// if edited prices read from the web site are equal to previously saved prices
			// increased by 100, test will pass
		}
		WebDriverWait wait = new WebDriverWait(wd, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-avatar")));
		HomePage.userData(wd);
		HomePage.clickLogOut(wd);
	}
}
