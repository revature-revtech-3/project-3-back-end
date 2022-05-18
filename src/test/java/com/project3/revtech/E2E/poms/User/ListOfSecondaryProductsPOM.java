package com.project3.revtech.E2E.poms.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfSecondaryProductsPOM {
	private WebDriver webDriver;
	
	public ListOfSecondaryProductsPOM(WebDriver webDriver) {
		this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
	}
	
    @FindBy(xpath = "//body/app-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-product-page[1]/section[1]/div[1]/mat-card[2]/div[1]/div[1]/div[1]/button[1]")
    public WebElement secondaryProducts;
}
