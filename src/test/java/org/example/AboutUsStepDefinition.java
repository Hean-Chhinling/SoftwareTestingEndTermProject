package org.example;

import io.cucumber.java.en.And;

public class AboutUsStepDefinition extends AbstractStepDefinitions{

    @And("the guidance video is existed")
    public void theGuidanceVideoIsExisted() throws InterruptedException {
        if (homePage.isGuidanceVideoExist()){
            System.out.println("The guidance video exists and is visible.");
        } else {
            throw new AssertionError("The guidance video does not exist.");
        }
    }
}
