package com.crowdar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private By homeTittle = By.xpath("//div[@class='app_logo']");
    private By addCartBrn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartbtn = By.xpath("//span[@class=\"shopping_cart_badge\"]");

    private By itemCart = By.id("item_4_title_link");

    private By removeCartBrn = By.id("remove-sauce-labs-backpack");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getHomeTittle() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(homeTittle).isDisplayed();
    }

    public void clickAddCartBrn() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(addCartBrn).click();
    }

    public void clickRemoveCartBrn() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(removeCartBrn).click();
    }

    public void clickCartBrn() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(cartbtn).click();
    }

    public boolean getItemCart() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> elements = driver.findElements(itemCart);
        return elements.size() != 0;
    }
}