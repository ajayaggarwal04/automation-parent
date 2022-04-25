# Introduction 
<Type of Framework>: In this project, we are using Page Object Model design pattern with Page Factory.
POM: As per the Page Object Model, we have maintained a class for every web page. Each web page has a separate class and that class holds the functionality and members of that web page. Separate classes for every individual test. 

<Packages>: We have 'automation-parent/module1' package for Pages and Tests and 'automation-parent/framework' package for selenium controller.
For example, Home Page and Login Page have a separate classes to store element locators. For the Verify links test there would be a separate class which calls the methods from the HomePage.java class and LoginPage.java class. 

<Driver Class>:Driver class (Driver.java) deals with all the common functions used by all the pages. This class is responsible for loading the configurations from properties files, Initializing the WebDriver, Implicit Waits for automated tests execution.

<Utility Class> : Utility class (Utility.java) stores all the functions which are generic (like  random number generator). The reason behind creating utility is to achieve reusability. 

<TestNG>: Using TestNG for Assertions, Grouping and Parallel execution.

<Maven>: Using Maven for build, execution and dependency purpose. Integrating the TestNG dependency in POM.xml file and running this POM.xml file using Jenkins. 

# Getting Started
- Technologies Used:
- Selenium Webdriver – Automation tool[3.14 and above]
- TestNG  - Testing framework [7.1.0]
- Java  - Supporting the architecture of framework [Java 8]
- Maven - For build management [Maven 3 or higher]

# Build and Test
To build the framework follow the below steps:
1. Make sure to have maven as maven 3 or higher setup on the machine
2. Import project into InteliJ Idea as Maven project using 'File > New > Project from Existing sources..' option from navigation. Further, select option as 'Maven' to Finish.
3. To run a single test, go to the test and click run by right click on the test.(e.g:'automation-parent\module1\src\test\java\tests\CreateProduct_UpdateQuantity_PlaceManufacturingOrder_Test.java')
4. To run all the tests, right click and run the testng.xml file placed at "automation-parent\module1\testng.xml".
5. CreateProduct_UpdateQuantity_PlaceManufacturingOrder_Test.java has 03 different methods as below:
	- createNewProduct() - this is to create the product
	- updateProductQuantity() - this is to update the created product quantity
	- placeManufacturingOrder() - this is to palce manufacuring order and further mark it as done.
6. After the execution it generate the TestNG html report and I have placed the executed report for reference under "automation-parent"
