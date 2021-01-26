package stepdefinition;

import configsdriver.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageobject.BillsPage;
import pageobject.SidebarPage;

import java.util.List;

public class BillsActions extends BaseDriver {

    @And("I click on Bills tab in sidebar on main page")
    public void iClickOnBillsTabInSidebarOnMainPage() throws InterruptedException {
        SidebarPage sidebarPage = new SidebarPage(driver);
        sidebarPage.getBillsAdminTab().click();
        Thread.sleep(4000);

    }

    @When("I fill fields billNumber (.+), name (.+), surnames (.+), vehicle (.+), duration (.+) and status (.+) in bills page$")
    public void iFillFieldsBillNumberNameSurnamesVehicleDurationAndStatusInBillsPage(String billNumber,
                                                                                     String name,
                                                                                     String surnames,
                                                                                     String vehicle,
                                                                                     String duration,
                                                                                     String status) {
        BillsPage billsPage = new BillsPage(driver);
        Select statusDropdown = new Select(billsPage.getBillStatusDropdown());
        Select vehicleDropdown = new Select(billsPage.getVehicleDropdown());

        billsPage.getInputBillNumber().sendKeys(billNumber);
        billsPage.getInputName().sendKeys(name);
        billsPage.getInputSurnames().sendKeys(surnames);
        billsPage.getInputDuration().sendKeys(duration);
        vehicleDropdown.selectByValue(vehicle);
        statusDropdown.selectByValue(status);
    }

    @Then("I should see a register with billNumber (.+) in bills page")
    public void iShouldSeeARegisterWithBillNumberInBillsPage(String billNumber) throws InterruptedException {
        boolean found = false;
        Thread.sleep(3000);
        List<WebElement> rows = getDriver().findElements(By.xpath("//table//tr//td[1]"));
        for (int i = 0; i < rows.size(); i++) {
            found = getDriver().findElement(By.xpath("//table//tr[" + (i + 2) + "]//td[1]")).getText().contains(billNumber);
        }
        Assert.assertTrue(found);
    }

    @And("I click on save button in bills page")
    public void iClickOnSaveButtonInBillsPage() throws InterruptedException {
        BillsPage billsPage = new BillsPage(driver);
        billsPage.getSaveButton().click();
        Thread.sleep(3000);
    }
}
