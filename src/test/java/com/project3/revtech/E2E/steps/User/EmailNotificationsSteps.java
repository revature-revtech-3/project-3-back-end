package com.project3.revtech.E2E.steps.User;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.project3.revtech.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmailNotificationsSteps {
	
	@Given("The user is on the product page")
	public void the_user_is_on_the_product_page() {
	    // Write code here that turns the phrase above into concrete actions
		TestRunner.driver.get("http://localhost:4200/product");
	}

	@When("The user clicks the view details button")
	public void the_user_clicks_the_view_details_button() {
	    // Write code here that turns the phrase above into concrete actions
	     TestRunner.emailNotificationsPOM.viewDetails.click();
	}

	@When("The user clicks the buy now button")
	public void the_user_clicks_the_buy_now_button() {
	    // Write code here that turns the phrase above into concrete actions
		TestRunner.emailNotificationsPOM.buyNow.click();
	}

	@When("The user clicks the proceed to checkout button")
	public void the_user_clicks_the_proceed_to_checkout_button() {
	    // Write code here that turns the phrase above into concrete actions
		TestRunner.emailNotificationsPOM.proceedToCheckout.click();
	}

	@When("The user should see a purchase confirmation")
	public void the_user_should_see_a_purchase_confirmation() {
		WebElement element = TestRunner.driver.findElement(By.tagName("div"));
        JavascriptExecutor js = (JavascriptExecutor) TestRunner.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        TestRunner.explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("div"),1));
	}

	@Then("The user should recieve an email")
	public void the_user_should_recieve_an_email() {
		
	}

}
