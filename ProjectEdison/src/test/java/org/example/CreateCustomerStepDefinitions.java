package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateCustomerStepDefinitions {
    private String name;

    @Given("I want to create a new Account")
    public void iWantToCreateANewAccount() {
    }

    @And("my name is {string}")
    public void myNameIs(String name) {
        // Implementation for setting the name
        this.name = name;
    }

    @When("I enter the name {string}")
    public void iEnterTheName(String name) {
        // Implementation for entering the name
        this.name = name;
    }

    @Then("a new Customer is created")
    public void aNewCustomerIsCreated() {
        // Implementation for verifying the customer creation
    }

    @And("the Customer name is {string}")
    public void theCustomerNameIs(String name) {
        // Implementation for verifying the customer name
        this.name = name;
    }

    @And("the Credit is {double}€")
    public void theCreditIs(double credit) {
        assertEquals(0.00, credit);
    }
}