package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.base.BasePage;

public class ViewCartPage extends BasePage {
    public ViewCartPage(WebDriver driver) {
        super(driver);
    }


    private final By emptyCartHeader = By.xpath("//p[@class='header-1']");


    private By deleteItemInCart(String productName){
        return  By.xpath("//button[contains(@title,'"+productName+"')]");
    }

    public void removeItemInCart(String productName){
        By addToCartButton = deleteItemInCart(productName);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public String getEmptyCartHeaderText(){
        return getElement(emptyCartHeader).getText();
    }

}
