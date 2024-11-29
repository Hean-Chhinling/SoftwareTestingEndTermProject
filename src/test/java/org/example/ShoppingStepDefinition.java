package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        homePage.clickButton(button);
        homePage.acceptAlert();
    }


    @And("the price should read {string}")
    public void thePriceShouldRead(String price) throws InterruptedException {
        assertEquals(price, homePage.getTotalPrice());
    }

    @And("the {string} field is filled with {string}")
    public void theFieldIsFilled(String field, String value) {
        homePage.fillOutPlaceOrderTextFields(field, value);
    }

    @Then("the product {string} is displayed")
    public void theTitleIsDisplayed(String description) {
        assertEquals(description, homePage.getProductTitle());
    }


    @Given("the next page button is clicked")
    public void theNextPageButtonIsClicked() throws InterruptedException {
        homePage.clickNextPageButton();
    }

    @Then("the home product {string} is displayed")
    public void theHomeProductTitleIsDisplayed(String homeProductName) throws InterruptedException {
        assertEquals(homeProductName, homePage.getHomeProductName());

    }


    @Then("the product description contains {string}")
    public void theProductDescriptionContainsDescription(String expectedDescription) {
        assertTrue(homePage.getProductDescription().contains(expectedDescription));
    }
}
