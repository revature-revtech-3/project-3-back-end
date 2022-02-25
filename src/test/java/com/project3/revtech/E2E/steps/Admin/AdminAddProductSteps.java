package com.project3.revtech.E2E.steps.Admin;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminAddProductSteps {
    @When("the admin clicks the add product button")
    public void the_admin_clicks_the_add_product_button() {
        TestRunner.adminAddProductPOM.addProductButton.click();
    }

    @When("the admin enters a product name")
    public void the_admin_enters_a_product_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the admin enters a product category")
    public void the_admin_enters_a_product_category() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the admin enters a product cost")
    public void the_admin_enters_a_product_cost() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the admin enters a product quantity")
    public void the_admin_enters_a_product_quantity() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the admin selects an image file")
    public void the_admin_selects_an_image_file() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the admin enters a product description")
    public void the_admin_enters_a_product_description() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("a new product is added to the end of the table")
    public void a_new_product_is_added_to_the_end_of_the_table() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
}

}
