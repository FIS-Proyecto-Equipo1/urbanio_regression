package stepdefinition;

import configsdriver.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageobject.SidebarPage;
import pageobject.VehiclesPage;

import java.io.IOException;
import java.util.List;

public class VehiclesActions extends BaseDriver {

    @And("I click on Vehicles tab in sidebar on main page")
    public void iClickOnVehiclesTabInSidebarOnMainPage() throws InterruptedException {
        SidebarPage sidebarPage = new SidebarPage(driver);
        Thread.sleep(3000);
        sidebarPage.getVehiclesTab().click();
    }

    @When("I filter by status (.+), driver license (.+) and type (.+) in vehicles page$")
    public void iFilterByStatusDriverLicenseAndTypeInVehiclesPage(String status,
                                                                  String driverLicense,
                                                                  String type) {
        VehiclesPage vehiclesPage = new VehiclesPage(driver);

        Select statusDropdown = new Select(vehiclesPage.getStatusDropdown());
        statusDropdown.selectByValue(status);

        Select driverLicenseDropdown = new Select(vehiclesPage.getDriverLicenseDropdown());
        driverLicenseDropdown.selectByValue(driverLicense);

        Select typeDropdown = new Select(vehiclesPage.getTypeDropdown());
        typeDropdown.selectByValue(type);

    }

    @And("I click on filter button in vehicles page")
    public void iClickOnFilterButtonInVehiclesPage() throws InterruptedException {

        VehiclesPage vehiclesPage = new VehiclesPage(driver);
        Thread.sleep(3000);
        vehiclesPage.getFilterButton().click();
    }

    @Then("I should see a register with status (.+), driver license (.+) and type (.+)  in vehicles page$")
    public void iShouldSeeARegisterWithStatusDriverLicenseAndTypeInVehiclesPage(String status,
                                                                                String driverLicense,
                                                                                String type) throws InterruptedException {


        Thread.sleep(4000);
        List<WebElement> rows = getDriver().findElements(By.xpath("//tbody//div"));
        for(int i= 0; i<rows.size(); i++){
            Assert.assertEquals(getDriver().findElement(By.xpath("//tbody//div[1]//td[2]")).getText(), status);
            Assert.assertEquals(getDriver().findElement(By.xpath("//tbody//div[1]//td[3]")).getText(), driverLicense);
            Assert.assertEquals(getDriver().findElement(By.xpath("//tbody//div[1]//td[5]")).getText(), type);
        }
    }
}
