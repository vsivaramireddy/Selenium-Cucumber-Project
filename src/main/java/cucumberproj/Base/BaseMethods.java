package cucumberproj.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseMethods {
    public static int index = 1;
    public static String description;
    public static WebDriver driver;
    public String directory = System.getProperty("user.dir");
    public static Properties prop;


    /****************** Invoke Browser ***********************/
    public void invokeBrowser() {
        if (prop == null) {
            prop = new Properties();
            try {
                FileInputStream file = new FileInputStream(directory + "/src/test/resources/Properties/configuration.properties");
                prop.load(file);
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        try {
            if (prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        directory + "/src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (prop.getProperty("browserName").equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", directory + "/src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    /****************** Open URL ***********************/
    public void openURL() {
        try {
            driver.get(prop.getProperty("webURL"));

        } catch (Exception e) {

        }

    }

    public static void Wait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    /****************** Close Browser ***********************/
    public static void closeBrowser() {
        driver.close();
    }

    /****************** Quit Browser ***********************/
    public void quitBrowser() {
        driver.quit();
    }


}
