package org.example;

import io.cucumber.java.en.And;

public class ContactStepDefinition extends AbstractStepDefinitions{

    @And("the contact {string} field is filled with {string}")
    public void theContactFieldsValue(String field, String value) {
        homePage.fillOutContactTextFields(field, value);
    }

}
