package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillsPage {
    public WebDriver driver;

    public BillsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='billNumber']")
    private WebElement inputBillNumber;

    public WebElement getInputBillNumber() {
        return inputBillNumber;
    }

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputName;

    public WebElement getInputName() {
        return inputName;
    }

    @FindBy(xpath = "//input[@name='surnames']")
    private WebElement inputSurnames;

    public WebElement getInputSurnames() {
        return inputSurnames;
    }

    @FindBy(xpath = "//select[@name='vehicle']")
    private WebElement vehicleDropdown;

    public WebElement getVehicleDropdown() {
        return vehicleDropdown;
    }

    @FindBy(xpath = "//input[@name='duration']")
    private WebElement inputDuration;

    public WebElement getInputDuration() {
        return inputDuration;
    }

    @FindBy(xpath = "//select[@name='billStatus']")
    private WebElement billStatusDropdown;

    public WebElement getBillStatusDropdown() {
        return billStatusDropdown;
    }

    @FindBy(xpath = "//button[contains(@class,'btn btn-primary')]")
    private WebElement saveButton;

    public WebElement getSaveButton() {
        return saveButton;
    }



}
