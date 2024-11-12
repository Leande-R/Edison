package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TopUpPrepaidCreditStepDefinitions {
    private Customer customer;

    @Given("I have an account")
    public void iHaveAnAccount() {

    }

    @And("I want to top up my credit by {int}€")
    public void iWantToTopUpMyCreditBy€(int arg0) {
        this.customer = new Customer();
        this.customer.setCredit(arg0);
    }

    @When("I enter the top-up amount {int}€")
    public void iEnterTheTopUpAmount€(int arg0) {
        this.customer.setCredit(this.customer.getCredit() + arg0);
    }

    @Then("my prepaid account is topped up by {int}€")
    public void myPrepaidAccountIsToppedUpBy€(int arg0) {
        assert this.customer.getCredit() == arg0;
    }
}
