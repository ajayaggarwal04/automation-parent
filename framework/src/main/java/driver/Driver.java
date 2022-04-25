package driver;

import com.google.common.base.Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Driver {
    protected WebDriver webDriver;
    protected String appUrl;

    /**
     * Method to initialize browser driver
     *
     * @param browser
     * @param url
     * @param maxWaitTimeToPollElement
     */
    @BeforeClass
    @Parameters({"browser", "url", "maxWaitTimeToPollElement"})
    public void initialize(@Optional("Chrome") String browser,
                           @Optional("https://aspireapp.odoo.com") String url,
                           @Optional("10") int maxWaitTimeToPollElement) {
        this.appUrl = url;
        String projectDirectory = System.getProperty("user.dir");
        String driverDirectory;

        Preconditions.checkNotNull(browser, "Browser value should not be null");
        Preconditions.checkNotNull(url, "Application URL should not be null");

        if (browser.equalsIgnoreCase("chrome")) {
            driverDirectory = projectDirectory + "\\src\\main\\resources\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverDirectory);
            System.out.println("Initializing Chrome Driver");
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("iexplore")) {
            driverDirectory = projectDirectory + "\\src\\main\\resources\\iedriver.exe";
            System.setProperty("webdriver.ie.driver", driverDirectory);
            System.out.println("Initializing IE driver");
            webDriver = new InternetExplorerDriver();
        } else {
            driverDirectory = projectDirectory + "\\src\\main\\resources\\gecodriver.exe";
            System.setProperty("webdriver.geco.driver", driverDirectory);
            System.out.println("Initializing Firefox driver");
            webDriver = new FirefoxDriver();
        }
        webDriver.manage().timeouts().implicitlyWait(maxWaitTimeToPollElement, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        pageSetup();
    }

    /**
     * This is page setup method and will get the implementation in the test
     */
    public void pageSetup() {
    }

    /**
     * Method to close the browser and quit the execution
     */
    @AfterClass
    public void finishExecution(){
        webDriver.close();
        webDriver.quit();
    }
}
