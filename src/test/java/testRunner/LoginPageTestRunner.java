package testRunner;

import org.testng.annotations.Test;
import pages.LoginPage;
import setup.Setup;


public class LoginPageTestRunner extends Setup {
    @Test (priority = 1, description = "Login With invalid Credential")
    public void doLoginWithInvalidCreds () {
        LoginPage login = new LoginPage(driver);
        login.doLoginWithInvalidCreds("AdminInvailid", "InvalidPassword");

    }

    @Test (priority = 2, description = "Login With valid Credential", groups = "smoke")
    public void doLogin () {
        LoginPage login = new LoginPage(driver);
        login.doLogin("Admin", "admin123");
    }
}
