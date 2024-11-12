package org.example;



import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CreateCustomerStepDefinitions {


    Customer customer;


    @Given("I want to create a new customer")
    public void iWantToCreateANewCustomer() {
        customer = new Customer();


    }


    @When("I enter the first name {string}")
    public void iEnterTheFirstName(String firstName) {
        customer.setFirstName(firstName);
    }


    @And("I enter the last name {string}")
    public void iEnterTheLastName(String lastName) {
        customer.setLastName(lastName);

    }

    @And("I enter the ID of the Customer  {int}")
    public void iEnterTheIDOfTheCustomer(int ID) {
        customer.setId(ID);
    }


    @And("I enter the email {string}")
    public void iEnterTheEmail(String mail) {
        customer.setMail(mail);
    }



    @Then("a new customer with the first name {string}, last name {string}, ID {int} and email {string} is created")
    public void aNewCustomerWithTheFirstNameLastNameIDAndEmailIsCreated(String firstName, String lastName, int ID, String mail) {
        assertEquals(firstName, customer.getFirstName());
        assertEquals(lastName, customer.getLastName());
        assertEquals(ID, customer.getId());
        assertEquals(mail, customer.getMail());
    }


}
