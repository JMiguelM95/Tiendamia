package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BuyProductPage {
	public static String Size = System.getProperty("Size");

	public static WebElement quantityTxt() {
		return $(By.id("quantity-input"));
	}
	public static WebElement addToCart() {
		return $(By.id("add-to-cart"));
	}
	public static WebElement buyBtn() {
		return $(By.id("add-to-cart-redirect"));
	}
	public static WebElement detailsOfProduct() {
		return $(By.xpath("//div[3]/h3"));
	}
	public static WebElement sizeList() {
		return $(By.xpath("//select"));
	}
	public static WebElement listValue() {
		return $(By.xpath("//option[@value='"+Size+"']"));
	}
	public static WebElement productIsUnavailable() {
		return $(By.xpath("//div[2]/div[3]/div/div/div/span"));
	}
	public static WebElement summary() {
		return $(By.xpath("//div[2]/div/h3"));
	}
	public static WebElement continueBuying() {
		return $(By.linkText("Continúa comprando"));
	}
	public static WebElement deleteProduct() {
		return $(By.xpath("//div[2]/div[3]/span"));
	}
	public static WebElement checkout() {
		return $(By.xpath("//div[2]/div/button/span/span"));
	}
	public static WebElement continueBuying2() {
		return $(By.linkText("Continúa comprando y ahorra en tu envío"));
	}
	public static WebElement checkout2() {
		return $(By.xpath("//a/p"));
	}
	
	
	
		
}
