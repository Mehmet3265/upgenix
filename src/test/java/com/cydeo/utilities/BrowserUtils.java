package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    public static void sleep(int seconds){
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //accepts 3 arguments, switches the window accordingly, and asserts the title if it is true
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){
        for (String each : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));

    }

    //accepts String expectedTitle and asserts if it is true
    public static void verifyTitle(String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //calls explicitly wait with turning-off implicitly wait and returns WebDriverWait wait
    public static WebDriverWait explicitlyWait(){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        return wait;
    }

    //I have just created contains method to simplify writing the assertion method
    //for url contains the given string
    public static void verifyUrlContains(String string){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(string));
    }

    /**
     * This method will accept dropdown as aweb element
     * and return all of the option's text as a String list
     * @param dropDownElement
     * @return Lisr<String> actualOptionsAsString.
     */
    public static List<String> dropDownOptionsAsString (WebElement dropDownElement) {
        Select select =new Select(dropDownElement);

        //list of all actual months <options> as web element
        List<WebElement> actualOptionsAsWebElement =select.getOptions();

        //list of all actual months <options> as String
        List<String> actualOptionsString=new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsString.add(each.getText());
        }

        return actualOptionsString;
    }



    /**
     * This method will accept a group radio buttons as List of WebElement.
     * It will loop through the List, and click to the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement>radioButtons,String attributeValue){

        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }


    /**
     * Switches to new window by the exact title.Returns to original window if
     * target title not found
     * @param targetTitle
     */
    public static void switchToWindow(String targetTitle){
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().switchTo().equals(targetTitle)){
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }
}
