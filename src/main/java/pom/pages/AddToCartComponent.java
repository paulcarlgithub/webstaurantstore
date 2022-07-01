package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.base.BasePage;

public class AddToCartComponent extends BasePage {

    public AddToCartComponent(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.cssSelector("div[class='notification__description']");
    private final By viewCart = By.xpath("//a[contains(text(),'View Cart')]");
    private final By checkoutCart = By.xpath("//a[contains(text(),'Checkout')]");

    public void clickViewCart(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
    }
}
