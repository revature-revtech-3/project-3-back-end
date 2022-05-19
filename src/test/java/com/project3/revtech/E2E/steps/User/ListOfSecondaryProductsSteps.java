package com.project3.revtech.E2E.steps.User;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.project3.revtech.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ListOfSecondaryProductsSteps {
	@Given("The user is on the product-page")
	public void the_user_is_on_the_product_page() {
	    // Write code here that turns the phrase above into concrete actions
		TestRunner.secondaryProductsPOM.viewDetails.click();
	}
	
	@Then("The user should see a list of secondary product")
	public void the_user_should_see_a_list_of_secondary_product() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		//TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.secondaryProductsPOM.secondaryProducts));
		TestRunner.secondaryProductsPOM.secondaryProducts.click();
	}
}
