package pages;

import controls.Button;
import controls.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManufacturingOrdersPage {
    // ==========
    // Locators
    // ==========
    public static final String PRODUCT_NAME_TEXT_FIELD = "//div[@name='product_id']//input[@class='o_input ui-autocomplete-input']";
    // ================
    // Selenium controls
    // ================
    private final WebObject manufacturingOrdersHeader;
    private final Button createButton;
    private final Button saveButton;
    private final Button confirmButton;
    private final Button markAsDoneButton;
    private final Button okButton;
    private final Button applyButton;
    private final WebObject manufacturingOrderStateDone;
    WebDriver driver;

    public ManufacturingOrdersPage(WebDriver webDriver) {
        driver = webDriver;
        manufacturingOrdersHeader = new WebObject(driver, By.xpath("//li[@class='breadcrumb-item active']//span[text()='Manufacturing Orders']"));
        createButton = new Button(driver, By.xpath("//button[contains(text(),'Create')]"));
        saveButton = new Button(driver, By.cssSelector("button[title='Save record']"));
        confirmButton = new Button(driver, By.cssSelector("button[name='action_confirm']"));
        markAsDoneButton = new Button(driver, By.xpath("//div[@class='o_statusbar_buttons']//button[4]//span[text()='Mark as Done']"));
        okButton = new Button(driver, By.xpath("//button//span[text()='Ok']"));
        applyButton = new Button(driver, By.xpath("//button//span[text()='Apply']"));
        manufacturingOrderStateDone = new WebObject(driver, By.xpath("//div[text()='State:']/../div[text()='Confirmed']/../div[text()='Done']"));
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
        saveButton.wait("for action to complete", 2);
    }

    /**
     * Method to click Confirm Button
     */
    public void clickConfirmButton() {
        confirmButton.click();
        confirmButton.wait("for action to complete", 2);

    }

    /**
     * Method to click Mark As Done Button
     */
    public void clickMarkAsDoneButton() {
        markAsDoneButton.click();
        markAsDoneButton.wait("for action to complete", 2);
    }

    /**
     * Method to click Apply Button
     */
    public void clickApplyButton() {
        applyButton.click();
    }

    /**
     * Method to click OK Button
     */
    public void clickOKButton() {
        okButton.click();
    }

    // ==============
    // Check Actions
    // ==============

    /**
     * Method to check presence of manufacturing Orders Header
     */
    public void checkPresenceOfManufacturingOrdersHeader() {
        manufacturingOrdersHeader.isDisplayed();
    }

    /**
     * Method to check presence of Manufacturing Order State Done
     */
    public void checkPresenceOfManufacturingOrderStateDone() {
        manufacturingOrderStateDone.isDisplayed();
    }

    // ==============
    // Set Actions
    // ==============

    /**
     * Method to set product name
     *
     * @param name
     * @throws InterruptedException
     */
    public void setProductName(String name) throws InterruptedException {
        WebElement productNameTextField = driver.findElement(By.xpath(PRODUCT_NAME_TEXT_FIELD));
        productNameTextField.sendKeys(name);
        Thread.sleep(3000);
        productNameTextField.sendKeys(Keys.TAB);
    }
}