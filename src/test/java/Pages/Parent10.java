package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Parent10 {

    public WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(20));

    public void myClick(WebElement element){

        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.click();
    }

    public void mySendKeys(WebElement element,String yazi){
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();

        element.sendKeys(yazi);

    }

    public void scrollToElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",element);

    }

    public void verifyContainsText(WebElement element,String value){
        wait.until(ExpectedConditions.textToBePresentInElement(element,value));

        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        //action la ESC ye basarak açık kutucuk veya mesaj var ise kapat
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();


    }

    public void MyAssert(WebElement element,String number){
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        String text=element.getText();
        boolean countainsNumber=text.contains(number);

        Assert.assertTrue(countainsNumber,"Sayı yok");
    }
}


