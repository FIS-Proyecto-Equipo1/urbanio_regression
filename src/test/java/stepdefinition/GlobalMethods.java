package stepdefinition;

import configsdriver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GlobalMethods extends BaseDriver {

    public static boolean isElementPresent(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
