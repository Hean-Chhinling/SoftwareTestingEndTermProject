package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class ContactStepDefinition extends AbstractStepDefinitions{

    @Given("the contact link is clicked")
    public void theContactLinkIsClicked() {
        homePage.clickContactLink();
    }

    @And("the contact {string} field is filled with {string}")
    public void theContactFieldsValue(String field, String value) {
        homePage.fillOutContactTextFields(field, value);
    }

    @And("the send message button is clicked")
    public void theSendMessageButtonIsClicked() {
        homePage.clickSendMessageButton();
    }
}
