package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SidebarPage {
    public WebDriver driver;

    public SidebarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'/user/viajesuser')]")
    private WebElement viajesUserTab;

    public WebElement getViajesUserTab() {
        return viajesUserTab;
    }

    @FindBy(xpath = "//a[contains(@href,'/user/vehicles')]")
    private WebElement vehiclesTab;

    public WebElement getVehiclesTab() {
        return vehiclesTab;
    }

    @FindBy(xpath = "//a[contains(@href,'/admin/vehicles')]")
    private WebElement vehiclesAdminTab;

    public WebElement getVehiclesAdminTab() {
        return vehiclesAdminTab;
    }

    @FindBy(xpath = "//a[contains(@href,'/admin/viajesadmin')]")
    private WebElement travelsAdminTab;

    public WebElement getTravelsAdminTab() {
        return travelsAdminTab;
    }

    @FindBy(xpath = "//a[contains(@href,'/admin/reservas')]")
    private WebElement bookingAdminTab;

    public WebElement getBookingAdminTab() {
        return bookingAdminTab;
    }

    @FindBy(xpath = "//a[contains(@href,'/user/reservas')]")
    private WebElement bookingUsersTab;

    public WebElement getBookingUsersTab() {
        return bookingUsersTab;
    }

    @FindBy(xpath = "//a[contains(@href,'/admin/bills')]")
    private WebElement billsAdminTab;

    public WebElement getBillsAdminTab() {
        return billsAdminTab;
    }

}
