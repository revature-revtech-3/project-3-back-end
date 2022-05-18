package com.project3.revtech.E2E.poms.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailNotificationsPOM {
	
    private WebDriver webDriver;

    public EmailNotificationsPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(tagName = "button")
    public WebElement viewDetails;
    
    @FindBy(tagName = "button")
    public WebElement buyNow;
    
    @FindBy(tagName = "button")
    public WebElement proceedToCheckout;
}


