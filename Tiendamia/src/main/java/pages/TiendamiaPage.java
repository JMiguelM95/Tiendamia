package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TiendamiaPage {
	
	public static String Country = System.getProperty("Country");
	public static String Store = System.getProperty("Store");
	public static String StoreOnResult = System.getProperty("StoreOnResult");
	public static String Product = System.getProperty("Product");
	
	public static WebElement tiendamiaLogo() {
		return $(By.id("tiendamia-logo"));
	}
	public static WebElement countryStore() {
		return $(By.linkText(Country));
	}
	public static WebElement signUpPopUp() {
		return $(By.id("banner-newsletter"));
	}
	public static WebElement closeSignUpPopUp() {
		return $(By.xpath("//div[@id='registration-home-popup3']/div[2]/button"));
	}
	public static WebElement googlePopUp() {
		return $(By.id("picker-header"));
	}
	public static WebElement closeGooglePopUp() {
		return $(By.xpath("//div[@id='close']/div"));
	}
	public static WebElement cookiesPopUp() {
		return $(By.id("cookie_compliance"));
	}
	public static WebElement closeCookiesPopUp() {
		return $(By.xpath("//div[@id='cookie_compliance']/div/span"));
	}
	public static WebElement searchProductTxt() {
		return $(By.name("amz"));
	}
	public static WebElement storeCategoryList() {
		return $(By.xpath("//div[@id='resultado_amz_categorias']/div/div"));
	}
	public static WebElement storeOption() {
		return $(By.xpath("//li[@id='"+Store+"']/span[2]"));
	}
	public static WebElement magnifyingGlass() {
		return $(By.id("search-lupa"));
	}
	public static WebElement storePopUp() {
		return $(By.xpath("//div[@id='tippy-3']/div"));
	}
	public static WebElement closeStorePopUp() {
		return $(By.xpath("//div[@id='tippy-3']/div/div/div"));
	}
	public static WebElement changeStoreOnResult() {
		return $(By.id(StoreOnResult+"-tab"));
	}
	public static WebElement resultProduct(String Product) {
		return $(By.xpath("//img[@alt='"+Product+"']"));
	}
	
	
	
}
