package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingStepDefinition extends AbstractStepDefinitions {

    @Given("the {string} link is clicked")
    public void theItemLinkIsClicked(String item) {
        homePage.clickItemLink(item);
    }

    @Then("the {string} is displayed")
    public void thePriceIsDisplayed(String price) {
        assertEquals(price, homePage.getItemPrice());
    }

    @Given("the {string} item is clicked")
    public void theSamsungGalaxySItemIsClicked(String item) {
        homePage.clickItemLink(item);
    }

    @And("the {string} add to cart button is clicked")
    public void theAddToCartButtonIsClicked(String button) {
        homePage.clickNavigationButton(button);
        homePage.acceptAlert();
    }

    @And("the {string} button is clicked")
    public void theButtonIsClicked(String button) {
        homePage.clickNavigationButton(button);
    }

    @And("the price should read {string}")
    public void thePriceShouldRead(String price) throws InterruptedException {
        assertEquals(price, homePage.getTotalPrice());
    }

    @And("the {string} field is filled with {string}")
    public void theFieldIsFilled(String field, String value) {
        homePage.fillOutPlaceOrderTextFields(field, value);
    }
}
