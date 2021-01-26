package stepdefinition;

import configsdriver.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pageobject.BookingsPage;
import pageobject.SidebarPage;

public class BookingActions extends BaseDriver {

    @And("I click on Booking tab in sidebar on main page as a current user")
    public void iClickOnBookingTabInSidebarOnMainPageAsACurrentUser() {
        SidebarPage sidebarPage = new SidebarPage(driver);
        sidebarPage.getBookingUsersTab().click();
    }

    @Then("I fill filter with vehicle (.+) and destination (.+) on booking page$")
    public void iFillFilterWithVehicleAndDestinationOnBookingPage(String vehicle,
                                                                  String destination) throws InterruptedException {
        BookingsPage bookingsPage = new BookingsPage(driver);

        Thread.sleep(3000);
        bookingsPage.getVehicleDropdown().click();
        driver.findElement(By.xpath("//input[@id='react-select-2-input']")).sendKeys(vehicle);
        driver.findElement(By.xpath("//input[@id='react-select-2-input']")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        bookingsPage.getDestinationDropdown().sendKeys(destination);


    }

    @When("I click on add booking button on booking page")
    public void iClickOnAddBookingButtonOnBookingPage() throws InterruptedException {
        BookingsPage bookingsPage = new BookingsPage(driver);
        bookingsPage.getAddBookingButton().click();
        Thread.sleep(2000);
    }

    @Then("I should see the vehicle (.+) with status (.+) on booking page$")
    public void iShouldSeeTheVehicleWithStatusOnBookingPage(String vehicle,
                                                            String status) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//tbody//tr[1]//td[2]")).getText(), vehicle);
        Assert.assertEquals(driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).getText(), status);

    }

    @And("I click on unblock botton to free the vehicle")
    public void iClickOnUnblockBottonToFreeTheVehicle() {
        BookingsPage bookingsPage = new BookingsPage(driver);
        bookingsPage.getUnblockButton().click();
    }
}
