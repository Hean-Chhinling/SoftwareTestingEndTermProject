package org.example;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;

public class CommonStepDefinitions extends AbstractStepDefinitions{

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }

    @AfterAll
    public static void cleanUp(){
        homePage.closePage();
    }
}
