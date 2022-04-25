package pages;

import com.google.common.base.Preconditions;
import controls.Button;
import controls.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final TextField emailTextField;

    // ================
    // Selenium controls
    // ================
    private final TextField passwordTextField;
    private final Button loginButton;
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        emailTextField = new TextField(driver, By.id("login"));
        passwordTextField = new TextField(driver, By.id("password"));
        loginButton = new Button(driver, By.cssSelector(".btn.btn-primary.btn-block"));
    }

    /**
     * Method to login to application
     */
    public void login(String user, String pass) {
        HomePage homePage = new HomePage(driver);
        Preconditions.checkNotNull(user, "Username should not be null");
        Preconditions.checkNotNull(pass, "Password should not be null");
        emailTextField.enterText(user);
        passwordTextField.enterText(pass);
        loginButton.click();
        homePage.checkPresenceOfInventoryTab();
    }
}
