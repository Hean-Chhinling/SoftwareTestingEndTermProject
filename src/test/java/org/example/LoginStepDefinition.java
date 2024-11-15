package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefinition extends AbstractStepDefinitions{

    @And("the confirmation log in button is clicked")
    public void theConfirmationLogInButtonIsClicked() {
        homePage.clickLoginButton();
        // homePage.acceptAlert();
    }

    @Then("the user is welcome with {string}")
    public void theUserIsWelcomeWithGreeting(String greeting) throws InterruptedException {
        assertEquals(greeting, homePage.getGreetingMessage());
    }

    @And("the log in {string} field is filled with {string}")
    public void theLogInFields(String field, String value) {
        homePage.fillOutLoginTextFields(field, value);
    }
}
