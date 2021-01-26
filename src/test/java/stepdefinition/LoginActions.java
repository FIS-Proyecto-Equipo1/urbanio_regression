package stepdefinition;

import configsdriver.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageobject.LoginPage;
import pageobject.SidebarPage;

import java.io.IOException;

public class LoginActions extends BaseDriver {

    @Given("I open Urbanio webpage in a new webBrowser")
    public void iOpenUrbanioWebpageInANewWebBrowser() throws IOException {
        driver = newbornWebDriver();
        //driver.get("https://frontend-urbanio.herokuapp.com/auth/login");
        driver.get(" http://localhost:3004/auth/login");


    }

    @And("I login with the credentials username (.+) and password (.+) in the login page$")
    public void iLoginWithTheCredentialsUsernameAndPasswordInTheLoginPage(String username,
                                                                          String pass) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        waiter.until(ExpectedConditions.elementToBeClickable(loginPage.getInputUsername()));

        loginPage.getInputUsername().sendKeys(username);
        loginPage.getInputPassword().sendKeys(pass);
        loginPage.getButtonSignIn().click();
        Thread.sleep(3000);
    }

    @Then("I see the main dashboard as a current user")
    public void iSeeTheMainDashboardAsACurrentUser() {
        SidebarPage sidebarPage = new SidebarPage(driver);
        GlobalMethods.isElementPresent(sidebarPage.getVehiclesTab());
        GlobalMethods.isElementPresent(sidebarPage.getViajesUserTab());
    }

    @Then("I see the main dashboard as an admin")
    public void iSeeTheMainDashboardAsAnAdmin() {
        SidebarPage sidebarPage = new SidebarPage(driver);
        GlobalMethods.isElementPresent(sidebarPage.getBillsAdminTab());
        GlobalMethods.isElementPresent(sidebarPage.getBookingAdminTab());
        GlobalMethods.isElementPresent(sidebarPage.getVehiclesAdminTab());
        GlobalMethods.isElementPresent(sidebarPage.getTravelsAdminTab());
    }
}
