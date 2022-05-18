package com.project3.revtech.E2E.steps.User;

import com.project3.revtech.E2E.runner.TestRunner;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BestSellerSteps {

	 @When("The user clicks on the Filter button")
	    public void the_user_clicks_on_the_Filter_button() {
	        TestRunner.bestSellerPOM.filterButton.click();
	    }
	 
	 @Then("The user clicks on the Best Sellers button")
	 public void the_user_clicks_on_the_Best_Sellers_button() {
		 TestRunner.bestSellerPOM.okButton.click();
	 }
}
