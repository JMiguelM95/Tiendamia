package util;

import static driver.DriverManager.DRIVER;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TiendamiaPage;

public interface ScreenUtils {

	// Properties
	public static String Product = System.getProperty("Product");
	public static final long WAIT = 60;

	static void waitForVisibility(WebElement webElement) {

		WebDriverWait wait = new WebDriverWait(DRIVER.getDriver(), ScreenUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	static void waitForInvisibility(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(DRIVER.getDriver(), ScreenUtils.WAIT);
		wait.until(ExpectedConditions.invisibilityOf(webElement));

	}

	static int getRowsDynamicTable() {
		List<WebElement> rowsNumber = DRIVER.getDriver().findElements(By.xpath("//*[@class='result']"));
		int rowCount = rowsNumber.size();
		return rowCount;
	}

	static void ScrollDown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DRIVER.getDriver();
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);

	}

	static void ClosingPopUps() {
		try {
			if (TiendamiaPage.signUpPopUp().isDisplayed()) {
				TiendamiaPage.closeSignUpPopUp().click();
			}
			if (TiendamiaPage.googlePopUp().isDisplayed()) {
				TiendamiaPage.closeGooglePopUp().click();
			}
			if (TiendamiaPage.cookiesPopUp().isDisplayed()) {
				TiendamiaPage.closeCookiesPopUp().click();
			}
		} catch (Exception e) {
			// System.out.println(e);
		}
	}

	static void evaluateIfElementIsAvailaible(WebElement webElement, WebElement webElement2) {
		try {
			Thread.sleep(3000);
			if (!webElement.isDisplayed()) {
				// Do Something
			} else {
				webElement2.click();
			}
		} catch (Exception e) {
			System.out.println("Producto no esta disponible para su compra");
		}
	}

	static String replaceCharacters(String Products) {
		String a = Products.replace(";", ",");
		String b = a.replace("'", "&apos;");
		String c = b.replace(",", "&comma;");
		String d = c.replace("/", "&sol;");
		String e = d.replace("(", "&lpar;");
		String f = e.replace(")", "&rpar;");
		String g = f.replace(":", "&colon;");
		String h = g.replace("|", "&vert;");
		String ia = h.replace("+", "&plus;");
		String j = ia.replace("=", "&equals;");
		String k = j.replace("!", "&excl;");
		String l = k.replace("?", "&quest;");
		String m = l.replace("#", "&num;");
		return m;
	}

	static void productConverted(String Products) {
		try {
			String variableString = replaceCharacters(Products);
			for (int i = 0; i <= 25; i++) {
				if (!TiendamiaPage.resultProduct(variableString).isDisplayed()) {
					ScrollDown();
				} else {
					TiendamiaPage.resultProduct(variableString).click();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
