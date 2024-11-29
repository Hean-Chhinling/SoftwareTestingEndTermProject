package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefinition extends AbstractStepDefinitions{


    @Then("the user is welcome with {string}")
    public void theUserIsWelcomeWithGreeting(String greeting) throws InterruptedException {
        assertEquals(greeting, homePage.getGreetingMessage());
    }

    @And("the log in {string} field is filled with {string}")
    public void theLogInFields(String field, String value) {
        homePage.fillOutLoginTextFields(field, value);
    }

    @Then("the log in button is present")
    public void theLogInButtonIsPresent() throws InterruptedException {
        if (homePage.isLogInLinkExisted()){
            System.out.println("The log in button is present");
        } else {
            throw new AssertionError("The log in button is not present");
        }
    }
}
