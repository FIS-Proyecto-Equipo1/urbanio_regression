package stepdefinition;

import configsdriver.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobject.LoginPage;
import pageobject.SidebarPage;
import pageobject.TravelsPage;

import java.io.IOException;

public class TravelsActions extends BaseDriver {

    @And("I click on Travels tab in sidebar on main page")
    public void iClickOnTravelsTabInSidebarOnMainPage() throws InterruptedException {
        SidebarPage sidebarPage = new SidebarPage(driver);
        sidebarPage.getViajesUserTab().click();
        Thread.sleep(2000);
    }

    @When("I click on start travel button in travels page")
    public void iClickOnStartTravelButtonInTravelsPage() throws InterruptedException {
        TravelsPage travelsPage = new TravelsPage(driver);
        for(WebElement wb: travelsPage.getListButtons()){
            if(wb.getText().contains("Iniciar Viaje")){
                wb.click();
            }
        }
        Thread.sleep(3000);
    }

    @Then("I should see the status (.+) of the travel changed$")
    public void iShouldSeeTheStatusStatusOfTheTravelChanged(String status) throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//tr//td[3]")).getText(),status);
    }

    @When("I click on finish travel button in travels page")
    public void iClickOnFinishTravelButtonInTravelsPage() {
        TravelsPage travelsPage = new TravelsPage(driver);
        for(WebElement wb: travelsPage.getListButtons()){
            if(wb.getText().contains("Finalizar Viaje")){
                wb.click();
            }
        }
    }
}
