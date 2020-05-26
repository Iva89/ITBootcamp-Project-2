package products_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import for_suite.BeforeAfterAnnotations;
import products.AddProduct;
import registration_login.HomePage;
import registration_login.LogIn;
import utility.ProductsExcel;

public class AddProductTest extends BeforeAfterAnnotations{

	@Test
	public void uploadProduct() {
		LogIn.inputUserName(wd, "jjosling1");
		LogIn.inputPass(wd, "QNo54LQb4wv");
		LogIn.clickLogIn(wd);
		HomePage.navigateToProductsPage(wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AddProduct.clickAddNew(wd);
		AddProduct.inputProdName(wd, "something");
		AddProduct.inputProdId(wd, "123");
		AddProduct.inputProdDescription(wd, "about something");
		AddProduct.inputPrice(wd, "100.00");
		AddProduct.clickSaveChanges(wd);
		Assert.assertTrue(wd.findElement(By.xpath(AddProduct.getUpdateSuccessful())).isDisplayed());
		//if "update successful" message is displayed product is added
	}

	@Test
	public void uploadProductsFromExcel() {
		HomePage.navigateToProductsPage(wd);
		ProductsExcel.findExcelSheet();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

		for (int i = 1; i < ProductsExcel.getRowNumber(); i++) {
			AddProduct.clickAddNew(wd);
			AddProduct.inputProdName(wd, ProductsExcel.getProdName(i));
			AddProduct.inputProdId(wd, ProductsExcel.getProdId(i));
			AddProduct.inputProdDescription(wd, ProductsExcel.getProdDescription(i));
			AddProduct.inputPrice(wd, ProductsExcel.getProdPrice(i));
			AddProduct.clickSaveChanges(wd);
			Assert.assertTrue(wd.findElement(By.xpath(AddProduct.getUpdateSuccessful())).isDisplayed());
			//if "update successful" message is displayed product is added
			AddProduct.clickViewButton(wd);
		}
		WebDriverWait wait = new WebDriverWait(wd, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-avatar")));
		HomePage.userData(wd);
		HomePage.clickLogOut(wd);
	}
	

}
