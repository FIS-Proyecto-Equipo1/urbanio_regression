package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TravelsPage {
    public WebDriver driver;

    public TravelsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td//button[@class='btn btn-primary']")
    private List<WebElement> listButtons;

    public List<WebElement> getListButtons() {
        return listButtons;
    }

}
