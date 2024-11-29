package org.example;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonStepDefinitions extends AbstractStepDefinitions{

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }

    @And("the {string} button is clicked")
    public void theButtonIsClicked(String button) {
        homePage.clickButton(button);
    }

    @Given("the {string} menu link is clicked")
    public void theMenuLinkIsClicked(String menuName) {
        homePage.clickMenuLink(menuName);
    }

    @AfterAll
    public static void cleanUp(){
        homePage.closePage();
    }

}
