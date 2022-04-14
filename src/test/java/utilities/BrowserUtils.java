package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {
    /**
     * Method will select value in dropdown by value name
     * @param element
     * @param value
     */
    public static void selectDropdownByValue(WebElement element,String value){
        Select select=new Select(element);
        select.selectByValue(value);
    }

    /**
     * Method will scroll up or down by the number of pixels
     * that is provided as parameter
     * Positive number of pixels: Scrolling down
     * Negative number of pixels: Scrolling up
     * @param pixels
     */
    public static void scrollUpOrDown(int pixels){
        WebDriver drier=Driver.getDriver();
        JavascriptExecutor js=((JavascriptExecutor) drier);
        js.executeScript("window.scrollBy(0,"+pixels+")");
    }

    /**
     * Method moves to element in browser
     * @param element
     */
    public static void hoverOver(WebElement element){
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Takes screenshot of current page and stores it under screenshot  folder
     * @return
     * @throws IOException
     */
    public static String takeScreenshot() throws IOException {
        WebDriver driver=Driver.getDriver();
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotName=System.currentTimeMillis()+" .png";
        String path="/Users/adilet.baigazievbk.ru/IdeaProjects/MindtekTestNGFramework/src/test/resources/screenshot/"+screenshotName;
        File file=new File(path);
        FileUtils.copyFile(screenshot,file);
        return screenshotName;
    }

    /**
     * Method waits explicitly for element to be clickable
     * @param element
     * @return
     */
    public  static WebElement waitElementToBeClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        WebElement clickableElement=wait.until(ExpectedConditions.elementToBeClickable(element));
        return clickableElement;
    }

    /**
     * Method wait explicitly for element to be visible
     * @param element
     * @return
     */
    public  static WebElement waitElementToBeVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        WebElement visibleElement=wait.until(ExpectedConditions.visibilityOf(element));
        return visibleElement;
}}
