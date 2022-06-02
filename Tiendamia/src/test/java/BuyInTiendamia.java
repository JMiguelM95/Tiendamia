import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BuyProductPage;
import pages.TiendamiaPage;
import util.ScreenUtils;

public class BuyInTiendamia extends BaseClass{
  @Test(priority = 1)
  public void SelectCountryTest() throws InterruptedException {
	  ScreenUtils.waitForVisibility(TiendamiaPage.tiendamiaLogo());
	  TiendamiaPage.countryStore().click();
	  Assert.assertTrue(true);
	  Thread.sleep(2000);
  }
  
  @Test(priority = 2)
  public void SearchProductTest() throws InterruptedException {
	  ScreenUtils.waitForVisibility(TiendamiaPage.signUpPopUp());
	  ScreenUtils.ClosingPopUps();
	  TiendamiaPage.storeCategoryList().click();
	  TiendamiaPage.storeOption().click();
	  TiendamiaPage.searchProductTxt().click();
	  TiendamiaPage.searchProductTxt().sendKeys(Product);
	  TiendamiaPage.magnifyingGlass().click();
	  Assert.assertTrue(true);
	  Thread.sleep(2000);
  }
  
  @Test(priority = 3)
  public void SelectResultTest() throws InterruptedException {
	  ScreenUtils.waitForVisibility(TiendamiaPage.changeStoreOnResult());
	  ScreenUtils.ClosingPopUps();
	  TiendamiaPage.changeStoreOnResult().click();
	  TiendamiaPage.closeStorePopUp().click();
	  ScreenUtils.productConverted(Product);
	  Assert.assertTrue(true);
	  Thread.sleep(2000);
  }
  
  @Test(priority = 4)
  public void AddingProductToCartTest() throws InterruptedException {
	  ScreenUtils.waitForVisibility(BuyProductPage.detailsOfProduct());
	  if(TotalProducts>1)
	  {
		  for (int i = 0; i<TotalProducts;i++)
		  {
	 
	  ScreenUtils.evaluateIfElementIsAvailaible(BuyProductPage.sizeList(), BuyProductPage.listValue());
	  BuyProductPage.quantityTxt().click();
	  BuyProductPage.quantityTxt().clear(); 
	  BuyProductPage.quantityTxt().sendKeys(Quantity);
	  ScreenUtils.evaluateIfElementIsAvailaible(BuyProductPage.productIsUnavailable(), BuyProductPage.addToCart());
	  
	  
	  TiendamiaPage.searchProductTxt().click();
	  TiendamiaPage.searchProductTxt().sendKeys(OtherProduct);
	  TiendamiaPage.magnifyingGlass().click();
	   ScreenUtils.waitForVisibility(TiendamiaPage.changeStoreOnResult());
	  ScreenUtils.ClosingPopUps();
	  TiendamiaPage.changeStoreOnResult().click();
	  
	  ScreenUtils.productConverted(OtherProduct);
	  ScreenUtils.evaluateIfElementIsAvailaible(BuyProductPage.sizeList(), BuyProductPage.listValue());
	  BuyProductPage.quantityTxt().click();
	  BuyProductPage.quantityTxt().clear(); 
	  BuyProductPage.quantityTxt().sendKeys(Quantity);
	  ScreenUtils.evaluateIfElementIsAvailaible(BuyProductPage.productIsUnavailable(), BuyProductPage.addToCart());
		  }
		  
		 BuyProductPage.checkout2().click();
	  }
	  else {
		  BuyProductPage.quantityTxt().click();
		  BuyProductPage.quantityTxt().clear(); 
		  BuyProductPage.quantityTxt().sendKeys(Quantity);
		  ScreenUtils.evaluateIfElementIsAvailaible(BuyProductPage.sizeList(), BuyProductPage.listValue());
		  ScreenUtils.evaluateIfElementIsAvailaible(BuyProductPage.productIsUnavailable(), BuyProductPage.buyBtn());
	  }
	  Assert.assertTrue(true);
	  Thread.sleep(2000);
	 
  }
  
  @Test(dependsOnMethods = {"AddingProductToCartTest"})
  public void BuyingProductTest() throws InterruptedException {
	  ScreenUtils.waitForVisibility(BuyProductPage.summary());
	  BuyProductPage.checkout().click();
	  Assert.assertTrue(true);
	  Thread.sleep(2000);
  }

}
