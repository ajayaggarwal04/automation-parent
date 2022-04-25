package tests;

import driver.Driver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utility.Utility;

public class CreateProduct_UpdateQuantity_PlaceManufacturingOrder_Test extends Driver {

    //Page Declaration
    LoginPage loginPage;
    HomePage homePage;
    InventoryOverviewPage inventoryOverviewPage;
    ProductsPage productsPage;
    ManufacturingOrdersPage manufacturingOrdersPage;

    //Test Data
    String str_Product_Name = "Product_For_Assignment_" + Utility.generateUniqueCharacterString(3);
    int int_Product_Quantity = 10;

    /**
     * Initialization
     */
    @Override
    public void pageSetup() {
        webDriver.get(appUrl);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        inventoryOverviewPage = new InventoryOverviewPage(webDriver);
        productsPage = new ProductsPage(webDriver);
        manufacturingOrdersPage = new ManufacturingOrdersPage(webDriver);
    }

    /**
     * This method is to login and then create the new product
     *
     * @param userName
     * @param password
     * @throws InterruptedException
     */
    @Parameters({"userName", "password"})
    @Test(priority = 0)
    public void createNewProduct(@Optional("user@aspireapp.com") String userName,
                                 @Optional("@sp1r3app") String password) throws InterruptedException {

        //Login to web application
        loginPage.login(userName, password);

        //Navigate to `Inventory` feature
        homePage.clickInventoryTabIcon();

        //Check presence of Inventory Overview Header
        inventoryOverviewPage.checkPresenceOfInventoryOverviewHeader();

        //From the top-menu bar, select `Products -> Products` item
        inventoryOverviewPage.clickProductsLink();
        inventoryOverviewPage.clickProductsSubLink();

        //Click create button
        productsPage.clickCreateButton();

        //Set product name
        productsPage.setProductNameTextField(str_Product_Name);

        //then create a new product
        productsPage.clickSaveButton();
    }

    /**
     * This method is to update the created product quantity
     */
    @Test(priority = 1)
    public void updateProductQuantity() {

        //click on 'Update Quantity' button
        productsPage.clickUpdateQuantityButton();

        //Further click on Create Quantity button
        productsPage.clickCreateQuantityButton();

        //Update the quantity of new product is more than 10
        productsPage.setCountedQuantityTextField(int_Product_Quantity);

        //Click on Save button
        productsPage.clickSaveButton();

    }

    /**
     * This method is to create a manufacturing order for the created product and further mark the status as done
     */
    @Test(priority = 2)
    public void placeManufacturingOrder() throws InterruptedException {

        //From top-left page, click on `Application` icon
        homePage.clickHomeMenuIcon();

        //Navigate to `Manufacturing` feature
        homePage.clickManufacturingIcon();

        //Check presence of Manufacturing Order Header
        manufacturingOrdersPage.checkPresenceOfManufacturingOrdersHeader();

        //Click on Create button
        manufacturingOrdersPage.clickCreateButton();

        //Enter the product name
        manufacturingOrdersPage.setProductName(str_Product_Name);

        //Click Save button
        manufacturingOrdersPage.clickSaveButton();

        //Click Confirm button
        manufacturingOrdersPage.clickConfirmButton();

        //Update the status of new Orders to “Done” successfully
        manufacturingOrdersPage.clickMarkAsDoneButton();

        //Click Ok for the popup
        manufacturingOrdersPage.clickOKButton();

        //Click Apply button for the popup
        manufacturingOrdersPage.clickApplyButton();

        //Validate the new Manufacturing Order is created with corrected information.
        manufacturingOrdersPage.checkPresenceOfManufacturingOrderStateDone();
    }

}
