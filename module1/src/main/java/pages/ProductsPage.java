package pages;

import controls.Button;
import controls.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    // ================
    // Selenium controls
    // ================
    private final Button createButton;
    private final TextField productNameTextField;
    private final TextField countedQuantityTextField;
    private final Button saveButton;
    private final Button createQuantityButton;
    private final Button updateQuantityButton;
    WebDriver driver;

    public ProductsPage(WebDriver webDriver) {
        driver = webDriver;
        createButton = new Button(driver, By.cssSelector("button[title='Create record']"));
        saveButton = new Button(driver, By.cssSelector("button[title='Save record']"));
        updateQuantityButton = new Button(driver, By.name("action_update_quantity_on_hand"));
        createQuantityButton = new Button(driver, By.xpath("//button[contains(text(),'Create')]"));
        productNameTextField = new TextField(driver, By.cssSelector("input[name='name']"));
        countedQuantityTextField = new TextField(driver, By.cssSelector("input[name='inventory_quantity']"));
    }

    // ==============
    // Click Actions
    // ==============

    /**
     * Method to click Create Button
     */
    public void clickCreateButton() {
        createButton.click();
    }

    /**
     * Method to click Save Button
     */
    public void clickSaveButton() {
        saveButton.click();
        updateQuantityButton.wait("for action to complete", 5);
    }

    /**
     * Method to click Update Quantity Button
     */
    public void clickUpdateQuantityButton() {
        updateQuantityButton.click();
        updateQuantityButton.wait("for action to complete", 5);
    }

    /**
     * Method to click Create Quantity Button
     */
    public void clickCreateQuantityButton() {
        createQuantityButton.click();
    }

    // ==============
    // Set Actions
    // ==============

    /**
     * Method to set product name
     *
     * @param name
     */
    public void setProductNameTextField(String name) {
        productNameTextField.enterText(name);
    }

    /**
     * Method to set product quantity
     *
     * @param quantity
     */
    public void setCountedQuantityTextField(int quantity) {
        countedQuantityTextField.clear();
        countedQuantityTextField.enterText(String.valueOf(quantity));
    }
}