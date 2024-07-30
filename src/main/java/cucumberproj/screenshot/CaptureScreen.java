package cucumberproj.screenshot;

import org.apache.commons.io.FileUtils;
import cucumberproj.Base.BaseMethods;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;


public class CaptureScreen extends BaseMethods {


    public static int i = 0;

    public static void screenShot() {
        try {
            //Converting WebDriver object to takeScreenshoot
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File Src = (File) scrShot.getScreenshotAs(OutputType.FILE);
            //Giving the location
            String filePath = System.getProperty("user.dir") + "\\Screenshots\\" + i + ".png";
            i++;
            //Moving image file to new destination
            File Dest = new File(filePath);
            //copying file at destination
            FileUtils.copyFile(Src, Dest);
        } catch (Exception e) {
            System.out.println("Screenshots are not capturing and not storing respective image into the location" + e);
        }
    }
}






