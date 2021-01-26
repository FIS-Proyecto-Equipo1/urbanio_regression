package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookingsPage {
    public WebDriver driver;

    public BookingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=' css-g1d714-ValueContainer']")
    private WebElement vehicleDropdown;

    public WebElement getVehicleDropdown() {
        return vehicleDropdown;
    }
    @FindBy(id = "react-select-2-input")
    private WebElement vehicleInput;

    public WebElement getVehicleInput() {
        return vehicleInput;
    }

    @FindBy(xpath = "//input[@name='destination']")
    private WebElement destinyDropdown;

    public WebElement getDestinationDropdown() {
        return destinyDropdown;
    }

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement addBookingButton;

    public WebElement getAddBookingButton() {
        return addBookingButton;
    }

    @FindBy(xpath = "//tbody//tr[1]//td//div//button[1]")
    private WebElement unblockButton;

    public WebElement getUnblockButton() {
        return unblockButton;
    }
}
