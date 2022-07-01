package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pom.base.BasePage;

import java.util.List;

public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.cssSelector("div[id='product_listing'] div[id='details'] a[data-testid='itemDescription']");


    public ResultsPage assertProductName(String searchQuery){
        List<WebElement> productList = driver.findElements(productName);
        for (WebElement currentProductName: productList)
        {
            String a = currentProductName.getText();
            Assert.assertTrue(a.contains(searchQuery),"To check if all the results contains the " +
                    "word "+searchQuery+":" +a);
        }
        return this;
    }


    public String getProductName(int index){
        List<WebElement> productList = driver.findElements(productName);
        return productList.get(index-1).getText();
    }

    private By getAddtoCartButton(String productName){
        return  By.xpath("//a[contains(text(),'"+productName+"')]/following::input[@name='addToCartButton']");
    }

    public ResultsPage addToCartSpecificItem(String productName){
        By addToCartButton = getAddtoCartButton(productName);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        return this;
    }

    public void addToCartLastItem(){
        addToCartSpecificItem(getProductName(60));
   }


}
