package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesPage {
    public WebDriver driver;

    public VehiclesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "estado")
    private WebElement statusDropdown;

    public WebElement getStatusDropdown() {
        return statusDropdown;
    }

    @FindBy(id = "permiso")
    private WebElement driverLicenseDropdown;

    public WebElement getDriverLicenseDropdown() {
        return driverLicenseDropdown;
    }

    @FindBy(id = "tipo")
    private WebElement typeDropdown;

    public WebElement getTypeDropdown() {
        return typeDropdown;
    }

    @FindBy(xpath = "//button[contains(@class,'btn btn-primary')]")
    private WebElement filterButton;

    public WebElement getFilterButton() {
        return filterButton;
    }


}
