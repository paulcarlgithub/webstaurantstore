package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.base.BasePage;


public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By searchProductTextbox = By.id("searchval");
    private final By searchButton = By.cssSelector("button[value='Search']");

    public MainPage searchProduct(String productName){
        WebElement e = getElement(searchProductTextbox);
        e.clear();
        e.sendKeys(productName);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return this;
    }

    public MainPage load(){
        load("/");
        return this;
    }
}
