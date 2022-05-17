package com.project3.revtech.E2E.poms.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestSellerPOM {

	private WebDriver driver;
	
	public BestSellerPOM(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(tagName="span")
	public WebElement filterButton;
	
	@FindBy(tagName="button")
	public WebElement okButton;
}
