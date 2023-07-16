package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PimPage {

    //Dashboard menu List
    @FindBy(className = "oxd-main-menu-item-wrapper")
  public  List<WebElement> manueList;

    //buttons
    @FindBy(className = "oxd-button--secondary")
    List<WebElement> buttons;

    //add employe first name
    @FindBy(name = "firstName")
    WebElement firstnamef;
    //add employee  lastName
    @FindBy(name = "lastName")
    WebElement lastnamef;


    //add employee page toggle button
    @FindBy(className = "oxd-switch-input")
    WebElement btnToggle;

    // user login details all filed after toggle press
    @FindBy(className = "oxd-input")
    List<WebElement> loginDetailsFields;

   //save and submit button after user  fill whole info
    @FindBy(css = "[type=submit]")
    WebElement employeeInfoSaveBtn;

    //page Factory initialization

    public PimPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doClickOnPIM () throws InterruptedException {
        //clicking on PIM Section from dashboard
        manueList.get(1).click();
//wating for 2 sec to load properly
        Thread.sleep(2000);

        //clicking on Ada employee button from PIM Section
        buttons.get(1).click();

    }


    //add employee steps method

    public void addEmployee (String firstname, String lastname, String username, String password) throws InterruptedException {
//filling us first name last name filed
        firstnamef.sendKeys(firstname);
        lastnamef.sendKeys(lastname);


        Thread.sleep(1000);
        //clicking on Toggle button to expand and create Login details
        btnToggle.click();
        Thread.sleep(1000);
//username field
        loginDetailsFields.get(5).sendKeys(username);
//password filed
        loginDetailsFields.get(6).sendKeys(password);
//confirm password
        loginDetailsFields.get(7).sendKeys(password);

        Thread.sleep(1000);

        //clicking on Save employee button
        employeeInfoSaveBtn.click();
    }


}
