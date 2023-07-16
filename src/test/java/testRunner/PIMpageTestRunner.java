package testRunner;

import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.PimPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class PIMpageTestRunner extends Setup {
    @BeforeTest (groups = "smoke")
    public void doLogin () {
        LoginPage login = new LoginPage(driver);
        login.doLogin("Admin", "admin123");
    }

    @Test (priority = 1,description = "Click PIM Option")
    public void doClickOnPIM () throws InterruptedException {
        PimPage pimpage = new PimPage(driver);
        pimpage.doClickOnPIM();
        //waiting for 3 sec
        Thread.sleep(3000);
        SoftAssert assret = new SoftAssert();
        String messageActual = driver.findElement(By.className("orangehrm-main-title")).getText();
        String messageExpected = "Add Employee";
        assret.assertTrue(messageActual.contains(messageExpected));

    }


    @Test(priority = 2, description = "Add One Employee ",invocationCount = 1)
    public void addEmployee () throws InterruptedException, IOException, ParseException {
        PimPage pimPage = new PimPage(driver);
        pimPage.doClickOnPIM();
//creating faker object
        Faker faker = new Faker();

        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String username = "foysal" + Utils.randomNumber();
        String password = "Fo@#" + Utils.randomNumber();
        Thread.sleep(2000);
        pimPage.addEmployee(firstname, lastname, username, password);
        Thread.sleep(7000);
        String tiitle_actual = driver.findElements(By.className("orangehrm-main-title")).get(0).getText();
        String title_expected = "Personal Details";
        Assert.assertEquals(tiitle_actual, title_expected);
        Utils.addJsonList(username,password,firstname,lastname);

        Thread.sleep(3000);
    }
}
