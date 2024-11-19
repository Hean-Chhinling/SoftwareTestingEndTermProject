package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class AboutUsStepDefinition extends AbstractStepDefinitions{

    @Given("the about us link is clicked")
    public void theAboutUsButtonIsClicked() {
        homePage.clickAboutUs();
    }

    @And("the play video button is clicked")
    public void thePlayButtonIsClicked() {
        homePage.clickPlayVideo();
    }

    @And("the close button is clicked")
    public void theCloseButtonIsClicked() {
        homePage.clickCloseVideo();
    }

    @And("the guidance video is existed")
    public void theGuidanceVideoIsExisted() throws InterruptedException {
        if (homePage.isGuidanceVideoExist()){
            System.out.println("The guidance video exists and is visible.");
        } else {
            throw new AssertionError("The guidance video does not exist.");
        }
    }
}
