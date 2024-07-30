package stepDefinitions;

import cucumberproj.Base.BaseMethods;
import cucumberproj.pageclasses.HomePage;
import cucumberproj.screenshot.CaptureScreen;
import cucumberproj.utils.CustomHtmlReport;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Steps extends BaseMethods {
    WebDriver driver;

    public FileWriter file;
    public static int index = 1;
    HomePage homePage;


    @Given("The user has opened the web application")
    public void setupbrowser() throws Exception {
        file = CustomHtmlReport.htmlreportWriter();
        CustomHtmlReport.intiateHtmlFile(file, "Google Page");
        CustomHtmlReport.reportTestPass(file, index++, "Browser Initialized");
        CustomHtmlReport.reportTestPass(file, index++, "Open the Google Page");
        invokeBrowser();
        openURL();
        CaptureScreen.screenShot();
    }

    @When("^User adds the (.*) capacity cooker to the cart$")
    public void searchItem(String capacity) throws Exception {
        CustomHtmlReport.reportTestPass(file, index++, "User added the coooker with the capcity of  " + capacity);
        homePage = new HomePage(BaseMethods.driver);
        homePage.addToCart(capacity);
        CaptureScreen.screenShot();


    }

    @Then("Closes the browser")
    public void closebrowser() throws Exception {
        CustomHtmlReport.reportTestPass(file, index++, "Browser closed");
        CustomHtmlReport.endHtmlReport(file, index - 1);
        BaseMethods.driver.close();

    }

}

