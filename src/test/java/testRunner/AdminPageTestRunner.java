package testRunner;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import pages.PimPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class AdminPageTestRunner extends Setup {
    @BeforeTest (groups = "smoke")
    public void doLogin() {
        LoginPage login = new LoginPage(driver);
        login.doLogin("Admin", "admin123");
    }

    @Test(priority = 1, description = "Search User with invalid Info")
    public void searchUserInfoWithInvalidInfo() throws IOException, ParseException, InterruptedException {
        AdminPage admin = new AdminPage(driver);

        admin.searchUserInfoWithInvalidInfo();
        Thread.sleep(7000);
        String titleActual = driver.findElements(By.className("oxd-text")).get(14).getText();
        String titleexpected = "No Records Found";
        System.out.println(titleActual);
        System.out.println(titleexpected);

        Assert.assertTrue(titleActual.contains(titleexpected));

    }

    @Test(priority = 2, description = "Search User Valid Info")
    public void searchUserInfo() throws IOException, ParseException, InterruptedException {
        AdminPage admin = new AdminPage(driver);
        admin.searchUserInfo();
        Thread.sleep(7000);
        String titleActual = driver.findElements(By.xpath("//span")).get(18).getText();
        String titleexpected = "Record Found";

        Assert.assertTrue(titleActual.contains(titleexpected));

    }

    @Test(priority = 3, description = "search user from directory and assertion", groups = "smoke")
    public void searchUserInfofromDirectory() throws IOException, ParseException, InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.searchUserInfofromDirectory();
        Thread.sleep(7000);
        String titleActual = driver.findElements(By.xpath("//span")).get(13).getText();
        String titleexpected = "Record Found";

        Assert.assertTrue(titleActual.contains(titleexpected));
    }

    @Test(priority = 4, description = "Logout from admin dashboard", groups = "smoke")
    public void doLogout() throws InterruptedException {
        AdminPage admin = new AdminPage(driver);
        admin.doLogout();

    }
    @Test(priority = 5, description = "Do login with wrong user credentials")
    public void doLoginWithInvaliduserCreds () {
        LoginPage login = new LoginPage(driver);
        login.doLoginWithInvalidCreds("UserInvailid", "InvalidPassword");

    }
    @Test(priority = 6, description = "Do login with new user and assertion full name",groups = "smoke")
    public void doLoginWithNewUser() throws IOException, ParseException, InterruptedException {
        LoginPage login = new LoginPage(driver);
        Thread.sleep(500);
        String username = (String) Utils.readJSONFile("./src/test/resources/TestEmployeeDetails.json", 1).get("username");
        String password = (String) Utils.readJSONFile("./src/test/resources/TestEmployeeDetails.json", 1).get("password");
        Thread.sleep(500);
        login.doLogin(username, password);

        String firstname = (String) Utils.readJSONFile("./src/test/resources/TestEmployeeDetails.json", 1).get("firstname");
        String lastname = (String) Utils.readJSONFile("./src/test/resources/TestEmployeeDetails.json", 1).get("lastname");
        String fullname = firstname + " " + lastname;
        String titleActual = driver.findElement(By.className("oxd-userdropdown-name")).getText();
        String titleexpected = fullname;

        Assert.assertTrue(titleActual.contains(titleexpected));

    }

    //@Test(priority = 7, description = "Update the blood group to O+")
    public void userContactOtherInfoUpdate() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        Thread.sleep(3000);
        adminPage.userContactOtherInfoUpdate(driver);
        adminPage.doLogout();
    }

    @Test(priority = 7, description = "Update the blood group to AB- and logout", groups = "smoke")
    public void updatebloodgrouptoAB() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        Thread.sleep(3000);
        adminPage.updatebloodgrouptoAB(driver);
        adminPage.doLogout();

    }
}
