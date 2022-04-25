package controls;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class ObjectControl {

    protected WebDriver webDriver;
    protected WebElement webElement;
    protected By by;
    int maxWaitToFindElement = 15;

    public ObjectControl(WebDriver webDriver, By by) {
        this.webDriver = webDriver;
        this.by = by;
    }

    public void enterText(String text) {
        waitAndFindElement(by);
        webElement.sendKeys(text);
    }

    public void clear() {
        waitAndFindElement(by);
        webElement.clear();
    }

    public void clearAndEnterText(String text) {
        waitAndFindElement(by);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void click() {
        waitAndFindElement(by);
        webElement.click();
    }

    public String getText() {
        String text = null;
        if (waitAndFindElement(by)) {
            text = webElement.getText();
        }
        return text;
    }

    public boolean isSelected() {
        boolean selected = false;
        if (waitAndFindElement(by)) {
            selected = webElement.isSelected();
        }
        return selected;
    }

    public boolean isDisplayed() {
        boolean displayed = false;
        if (waitAndFindElement(by)) {
            displayed = webElement.isDisplayed();
        }
        return displayed;
    }

    public boolean isEnabled() {
        boolean enabled = false;
        if (waitAndFindElement(by)) {
            enabled = webElement.isEnabled();
        }
        return enabled;
    }

    private boolean waitAndFindElement(By by) {
        String print = "Waiting for the presence of " + by.toString()
                + " element for " + maxWaitToFindElement + " seconds";
        Reporter.log(print, true);
        boolean presence = true;

        try {
            webElement = new WebDriverWait(webDriver, maxWaitToFindElement)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
            Reporter.log(by.toString() + " is available", true);
        } catch (Exception e) {
            presence = false;
            Reporter.log(by.toString() + " is not present");
            takeScreenShot();
            e.printStackTrace();
        }
        return presence;
    }

    public void takeScreenShot() {
        String destLocation = "C:\\tmp\\Screenshots\\Screenshot_" + System.currentTimeMillis() + ".jpg";
        TakesScreenshot screenshot = ((TakesScreenshot) webDriver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(destLocation);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wait(String reason, long numberOfSeconds) {
        try {
            Reporter.log(Thread.currentThread().getId() + " - WARN: necessary waiting for " + numberOfSeconds + " seconds " + reason);
            Thread.sleep(numberOfSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}