
package org.example;


import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TopUpPrepaidCreditStepDefinitions {


    private Customer customer;

    @Given("I want to top up my prepaid credit")
    public void iWantToTopUpMyPrepaidCredit() {
        customer = new Customer();
    }


    @When("I enter the top-up amount {int} Euros")
    public void iEnterTheTopUpAmountEuros(int ammount) {
        customer.topUpCredit(ammount);
    }

    @Then("my prepaid account is topped up with {int} Euros")
    public void myPrepaidAccountIsToppedUpWithEuros(int ammount) {
        assertEquals(ammount, customer.getCredit());
    }

}
