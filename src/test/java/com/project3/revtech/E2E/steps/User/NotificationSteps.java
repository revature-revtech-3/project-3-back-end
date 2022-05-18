package com.project3.revtech.E2E.steps.User;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.project3.revtech.E2E.runner.TestRunner;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotificationSteps {

	@When("The user clicks on notification bell")
	public void The_user_clicks_on_notification_bell() {
		TestRunner.notificationPOM.notificationBell.click();
		
	}
	@Then("The user is taken to the notification page")
	public void The_user_is_taken_to_the_notification_page() {
		TestRunner.driver.navigate().to("http://localhost:4200/notification");

		
//  TestRunner.implicitWait.until(ExpectedConditions.urlContains("http://localhost:4200/notification"));
        

	}
}
