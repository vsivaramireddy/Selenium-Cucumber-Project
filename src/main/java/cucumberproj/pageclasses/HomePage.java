package cucumberproj.pageclasses;

import cucumberproj.utils.ExcelData;
import org.bson.assertions.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


import javax.swing.*;

public class HomePage {
    String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\excelSheet\\Data.xlsx";


    /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;

    @FindBy(xpath = "//button[text()=\"Add to cart\"]")


    WebElement addToCart;

    @FindBy(xpath = "//div[@class=\"gE4Hlh\"]//a")

    WebElement itemName;

    @FindBy(className = "barone")

    WebElement titleText;

    @FindBy(name = "btnLogin")

    WebElement login;
private static By user=By.xpath("");
    public HomePage(WebDriver driver) {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }


    public void addToCart(String capacity) {

        driver.findElement(By.xpath("//a[text()='" + capacity + "']")).click();
        addToCart.click();
        String item = itemName.getText();

        if (item.contains(capacity)) {
            System.out.println("3L Pressure is added to the cart");
        }
    }

    //Set password in password textbox


}

