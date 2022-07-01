package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.base.BaseTest;
import pom.pages.AddToCartComponent;
import pom.pages.MainPage;
import pom.pages.ResultsPage;
import pom.pages.ViewCartPage;

public class CartTest extends BaseTest {

    @Test
    public void verifyEmptyCart(){
        MainPage mainPage = new MainPage(driver)
                .load()
                .searchProduct("stainless work table");
        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.assertProductName("Table");

        String lastProduct = resultsPage.getProductName(60);
        resultsPage.addToCartLastItem();

        AddToCartComponent addToCartComponent = new AddToCartComponent(driver);
        addToCartComponent.clickViewCart();

        ViewCartPage viewCartPage = new ViewCartPage(driver);
        viewCartPage.removeItemInCart(lastProduct);
        Assert.assertEquals(viewCartPage.getEmptyCartHeaderText(), "Your cart is empty.");
    }

}
