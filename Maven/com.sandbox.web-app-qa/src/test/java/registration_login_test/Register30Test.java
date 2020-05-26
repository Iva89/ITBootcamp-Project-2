package registration_login_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import for_suite.BeforeAfterAnnotations;
import registration_login.HomePage;
import registration_login.SignUpPage;
import utility.Register30;

public class Register30Test extends BeforeAfterAnnotations{
	
	@BeforeTest
	public void BeforeTest() {
		SignUpPage.clickSignUp(wd);
	}

	@Test
	public void register30Users() {
	Register30.findExcelSheet();
	for(int i = 1; i<Register30.getRowNumber(); i++) {
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		SignUpPage.inputUserName(wd, Register30.getUserName(i));
		SignUpPage.inputEMail(wd, Register30.getEMail(i));
		SignUpPage.inputPassword(wd, Register30.getPassword(i));
		SignUpPage.inputConfirmPassword(wd, Register30.getPassword(i));
		SignUpPage.selectOption5(wd);
		SignUpPage.clickSubmit(wd);
		WebDriverWait wait = new WebDriverWait(wd, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-avatar")));
		HomePage.userData(wd);
		WebElement e = wd.findElement(By.id(HomePage.getLoggedUsenameId()));
		Assert.assertEquals(e.getText(), Register30.getUserName(i));
		HomePage.clickLogOut(wd);
		SignUpPage.clickSignUp(wd);
		
	}
}
}
