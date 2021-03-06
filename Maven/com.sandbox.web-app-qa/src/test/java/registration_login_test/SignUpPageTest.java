package registration_login_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import for_suite.BeforeAfterAnnotations;
import registration_login.HomePage;
import registration_login.SignUpPage;

public class SignUpPageTest extends BeforeAfterAnnotations{

	@Test
	public void registration2_FormOneUser() {
		 SignUpPage.clickSignUp(wd);
		 WebDriverWait wait = new WebDriverWait(wd, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SignUpPage.getUsernameXpath())));
		 SignUpPage.inputUserName(wd, "gugigili");
		 SignUpPage.inputEMail(wd, "gugigi@gmail.com");
		 SignUpPage.inputPassword(wd, "Gigi1234");
		 SignUpPage.inputConfirmPassword(wd, "Gigi1234");
		 SignUpPage.selectOption5(wd);
		 SignUpPage.clickSubmit(wd);
		 Assert.assertEquals(wd.getCurrentUrl(), HomePage.getHomeUrl());
	}

	@Test
	public void registration1_WithoutOneField() {
		SignUpPage.clickSignUp(wd);

		List<WebElement> regElements = wd.findElements(By.className(SignUpPage.getFormName()));
		for (int i = 2; i < regElements.size(); i++) {
			SignUpPage.inputUserName(wd, "rugili");
			SignUpPage.inputEMail(wd, "rigigi@gmail.com");
			SignUpPage.inputPassword(wd, "Gigi1234");
			SignUpPage.inputConfirmPassword(wd, "Gigi1234");
			SignUpPage.selectOption5(wd);

			Actions act = new Actions(wd);
			act.click(regElements.get(i)).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.BACK_SPACE).build().perform();

			SignUpPage.clickSubmit(wd);
			wd.findElement(By.xpath(SignUpPage.getUsernameXpath())).clear();
			wd.findElement(By.xpath(SignUpPage.getEmailXpath())).clear();
			wd.findElement(By.xpath(SignUpPage.getPasswordXpath())).clear();
			wd.findElement(By.xpath(SignUpPage.getConfirmPassXpath())).clear();
			SignUpPage.selectOption0(wd);

			Assert.assertEquals(wd.getCurrentUrl(), SignUpPage.getSignUpUrl());
			// if it stays on the same page test is passed
		}
	}
}
