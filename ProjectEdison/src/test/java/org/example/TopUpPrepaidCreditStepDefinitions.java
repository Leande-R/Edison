package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TopUpPrepaidCreditStepDefinitions {
    @Given("I have an account")
    public void iHaveAnAccount() {
    }

    @And("I want to top up my credit by {int}€")
    public void iWantToTopUpMyCreditBy€(int arg0) {
    }

    @When("I enter the top-up amount {int}€")
    public void iEnterTheTopUpAmount€(int arg0) {
    }

    @Then("my prepaid account is topped up by {int}€")
    public void myPrepaidAccountIsToppedUpBy€(int arg0) {
    }
}
