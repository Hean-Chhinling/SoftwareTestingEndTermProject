package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class HomePage {

    private static final String PAGE_URL = "https://www.demoblaze.com/index.html";

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "#tbodyid > h3")
    private WebElement itemPriceLabel;

    @FindBy(css = "#page-wrapper > div > div.col-lg-1 > div")
    private WebElement checkoutTotalPriceLabel;

    private static final Map<String, By> itemsLinks = Map.of(
            "Samsung galaxy s6", By.cssSelector("a[href='prod.html?idp_=1']"),
            "Nokia lumia 1520", By.cssSelector("a[href='prod.html?idp_=2']"),
            "Nexus 6", By.cssSelector("a[href='prod.html?idp_=3']"),
            "Samsung galaxy s7", By.cssSelector("a[href='prod.html?idp_=4']"),
            "Iphone 6 32gb", By.cssSelector("a[href='prod.html?idp_=5']"),
            "Sony xperia z5", By.cssSelector("a[href='prod.html?idp_=6']")
    );

    private static final Map<String, By> placeOrderTextFields = Map.of(
            "Name:", By.id("name"),
            "Country:", By.id("country"),
            "City:", By.id("city"),
            "Credit card:", By.id("card"),
            "Month:", By.id("month"),
            "Year:", By.id("year")
    );

    private static final Map<String, By> loginTextFields = Map.of(
            "Username:", By.id("loginusername"),
            "Password:", By.id("loginpassword")
    );

    private static final Map<String, By> signupTextFields = Map.of(
            "Username:", By.id("sign-username"),
            "Password:", By.id("sign-password")
    );

    private static final Map<String, By> navigationButtons = Map.of(
            "Home", By.cssSelector("#navbarExample > ul > li.nav-item.active > a"),
            "Add to cart", By.cssSelector("#tbodyid > div.row > div > a"),
            "Log in", By.id("login2"),
            "Sign up", By.id("signin2"),
            "Cart", By.id("cartur"),
            "Place Order", By.cssSelector("#page-wrapper > div > div.col-lg-1 > button"),
            "Purchase", By.cssSelector("#orderModal > div > div > div.modal-footer > button.btn.btn-primary")
    );

    public void openPage(){
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void closePage(){
        driver.quit();
    }

    public void clickNavigationButton(String button){
        driver.findElement(navigationButtons.get(button)).click();
    }

    public void clickItemLink(String item){
        driver.findElement(itemsLinks.get(item)).click();
    }

    public void fillOutPlaceOrderTextFields(String field, String text){
        driver.findElement(placeOrderTextFields.get(field)).sendKeys(text);
    }

    public void fillOutLoginTextFields(String field, String text){
        driver.findElement(loginTextFields.get(field)).sendKeys(text);
    }

    public void fillOutSignupTextFields(String field, String text){
        driver.findElement(signupTextFields.get(field)).sendKeys(text);
    }

    public String getTotalPrice() throws InterruptedException {
        Thread.sleep(2000); // Short sleep to allow the total price to be loaded, despite the webpage already loaded
        return checkoutTotalPriceLabel.getText();
    }

    public String getItemPrice(){
        return itemPriceLabel.getText();
    }

    public void acceptAlert() {
        try {
            Thread.sleep(500); // Short sleep to allow alert to be fully ready
            driver.switchTo().alert().accept();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }







}
