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

    @FindBy(css = "#tbodyid > h2")
    private WebElement productTitle;

    @FindBy(css = "#tbodyid > h3")
    private WebElement itemPriceLabel;

    @FindBy(css = "#more-information > p")
    private WebElement productDescription;

    @FindBy(css = "#page-wrapper > div > div.col-lg-1 > div")
    private WebElement checkoutTotalPriceLabel;

    @FindBy(className = "card-title")
    private WebElement homeProductName;

    @FindBy(css = "#login2")
    private WebElement loginLink;

    @FindBy(css = "#nameofuser")
    private WebElement greetingMessageLabel;

    @FindBy(css = "#next2")
    private WebElement nextPageButton;

    @FindBy(css = "#example-video > div.vjs-poster")
    private WebElement guidanceVideo;

    private static final Map<String, By> menuLinks = Map.of(
            "Contact Link", By.cssSelector("#navbarExample > ul > li:nth-child(2) > a"),
            "About Us", By.cssSelector("#navbarExample > ul > li:nth-child(3) > a")
    );

    private static final Map<String, By> itemsLinks = Map.of(
            "Samsung galaxy s6", By.cssSelector("a[href='prod.html?idp_=1']"),
            "Nokia lumia 1520", By.cssSelector("a[href='prod.html?idp_=2']"),
            "Nexus 6", By.cssSelector("a[href='prod.html?idp_=3']"),
            "Samsung galaxy s7", By.cssSelector("a[href='prod.html?idp_=4']"),
            "Iphone 6 32gb", By.cssSelector("a[href='prod.html?idp_=5']"),
            "Sony xperia z5", By.cssSelector("a[href='prod.html?idp_=6']"),
            "Sony vaio i5", By.cssSelector("a[href='prod.html?idp_=8']"),
            "Sony vaio i7", By.cssSelector("a[href='prod.html?idp_=9']"),
            "MacBook air", By.cssSelector("a[href='prod.html?idp_=11']"),
            "Dell i7 8gb", By.cssSelector("a[href='prod.html?idp_=12']")
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

    private static final Map<String, By> contactTextFields = Map.of(
            "Contact Email:", By.id("recipient-email"),
            "Contact Name:", By.id("recipient-name"),
            "Message:", By.id("message-text")
    );


    private static final Map<String, By> buttons = Map.ofEntries(
            Map.entry("Home", By.cssSelector("#navbarExample > ul > li.nav-item.active > a")),
            Map.entry("Add to cart", By.cssSelector("#tbodyid > div.row > div > a")),
            Map.entry("Log in", By.id("login2")),
            Map.entry("Log out", By.id("logout2")),
            Map.entry("Sign up", By.id("signin2")),
            Map.entry("Cart", By.id("cartur")),
            Map.entry("Place Order", By.cssSelector("#page-wrapper > div > div.col-lg-1 > button")),
            Map.entry("Purchase", By.cssSelector("#orderModal > div > div > div.modal-footer > button.btn.btn-primary")),
            Map.entry("Send Message", By.cssSelector("#exampleModal > div > div > div.modal-footer > button.btn.btn-primary")),
            Map.entry("Delete Nexus Item", By.xpath("//tr[td[text()='Nexus 6']]/td/a[contains(@onclick, 'deleteItem')]")),
            Map.entry("Close Video", By.cssSelector("#videoModal > div > div > div.modal-footer > button")),
            Map.entry("Pop up Login", By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary"))
    );

    public void openPage(){
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void closePage(){
        driver.quit();
    }

    public void clickButton(String buttonName){
        driver.findElement(buttons.get(buttonName)).click();
    }

    public void clickMenuLink(String menuName){
        driver.findElement(menuLinks.get(menuName)).click();
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
    
    public void fillOutContactTextFields(String field, String text){
        driver.findElement(contactTextFields.get(field)).sendKeys(text);
    }

    public String getTotalPrice() throws InterruptedException {
        Thread.sleep(2000); // Short sleep to allow the total price to be loaded, despite the webpage already loaded
        return checkoutTotalPriceLabel.getText();
    }


    public void acceptAlert() {
        try {
            Thread.sleep(500); // Short sleep to allow alert to be fully ready
            driver.switchTo().alert().accept();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getItemPrice(){
        return itemPriceLabel.getText();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductDescription() {
        return productDescription.getText();
    }

    public String getHomeProductName() throws InterruptedException {
        Thread.sleep(2000); // Add some delay for it to load the product name
        return homeProductName.getText();
    }

    public String getGreetingMessage() throws InterruptedException {
        Thread.sleep(2000); // Add short sleep to allow username to be appeared
        return greetingMessageLabel.getText();
    }


    public void clickNextPageButton() throws InterruptedException {
        Thread.sleep(2000); // Delay to make sure the next page button exist
        nextPageButton.click();

    }

    public boolean isGuidanceVideoExist() throws InterruptedException {
        Thread.sleep(2000);
        return guidanceVideo.isDisplayed();
    }

    public boolean isLogInLinkExisted() throws InterruptedException {
        Thread.sleep(2000);
        return loginLink.isDisplayed();
    }

}
