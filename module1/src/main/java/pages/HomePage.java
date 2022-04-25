package pages;

import controls.Icon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    // ================
    // Selenium controls
    // ================
    private final Icon inventoryTabIcon;
    private final Icon homeMenuIcon;
    private final Icon manufacturingIcon;
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        inventoryTabIcon = new Icon(driver, By.xpath("//a[@id='result_app_1']//div[@class='o_app_icon']"));
        homeMenuIcon = new Icon(driver, By.cssSelector("a[title='Home menu']"));
        manufacturingIcon = new Icon(driver, By.cssSelector("a[id='result_app_2'] div[class='o_app_icon']"));
    }

    // ==============
    // Click Actions
    // ==============

    /**
     * Method to click Inventory Tab Icon
     */
    public void clickInventoryTabIcon() {
        inventoryTabIcon.click();
    }

    /**
     * Method to click Home Menu Icon
     */
    public void clickHomeMenuIcon() {
        homeMenuIcon.click();
    }

    /**
     * Method to click Manufacturing Icon
     */
    public void clickManufacturingIcon() {
        manufacturingIcon.click();
    }

    // ==============
    // Check Actions
    // ==============

    /**
     * Method to check presence of Inventory tab
     */
    public void checkPresenceOfInventoryTab() {
        inventoryTabIcon.isDisplayed();
    }

}
