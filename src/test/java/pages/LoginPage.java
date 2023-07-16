package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//username field
    @FindBy(name = "username")
    WebElement txtUsername;

    //password field
@FindBy(name = "password")
    WebElement txtPassword;


//login button submit type
    @FindBy(tagName = "button")
    WebElement btnLogin;
    //page factory initialization\
    public  LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public void doLoginWithInvalidCreds(String username,String password){
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    //do login steps

    public void doLogin(String username,String password){
       txtUsername.sendKeys(username);
       txtPassword.sendKeys(password);
       btnLogin.click();
    }


}
