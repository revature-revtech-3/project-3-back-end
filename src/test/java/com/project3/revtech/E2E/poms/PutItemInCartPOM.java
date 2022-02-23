package com.project3.revtech.E2E.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PutItemInCartPOM {

    private WebDriver webDriver;

    public PutItemInCartPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//button[contains(text(), \"View Details\")]")
    public WebElement viewDetailsButton;

    @FindBy(xpath = "/html/body/app-root/app-product-page/section/div/article[1]/div/div/main/article/div[5]/div/span[2]")
    public WebElement plusIcon;

    @FindBy(xpath = "/html/body/app-root/app-product-page/section/div/article[1]/div/div/main/article/div[5]/button")
    public WebElement goToCartButton;


}
