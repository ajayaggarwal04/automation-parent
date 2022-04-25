package pages;

import controls.Link;
import controls.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryOverviewPage {
    // ================
    // Selenium controls
    // ================
    private final WebObject inventoryOverviewHeader;
    private final Link productsLink;
    private final Link productsSubLink;
    WebDriver driver;

    public InventoryOverviewPage(WebDriver webDriver) {
        driver = webDriver;
        inventoryOverviewHeader = new WebObject(driver, By.xpath("//span[text()='Inventory Overview']"));
        productsLink = new Link(driver, By.xpath("//span[text()='Products']"));
        productsSubLink = new Link(driver, By.xpath("//div[@class='o-dropdown dropdown o-dropdown--no-caret show']//a[text()='Products']"));
    }

    // ==============
    // Click Actions
    // ==============

    /**
     * Method to click Products link
     */
    public void clickProductsLink() {
        productsLink.click();
    }

    /**
     * Method to click Products sub link
     */
    public void clickProductsSubLink() {
        productsSubLink.click();
    }

    // ==============
    // Check Actions
    // ==============

    /**
     * Method to check presence of Inventory Overview tab
     */
    public void checkPresenceOfInventoryOverviewHeader() {
        inventoryOverviewHeader.isDisplayed();
    }
}