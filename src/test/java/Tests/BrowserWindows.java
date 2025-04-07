package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrowserWindows {

    @Test
    public void automationMethod() {

        WebDriver driver;

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //browser in modul maximize
        driver.manage().window().maximize();

        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement alertFraneWindowsElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFraneWindowsElement.click();

        WebElement browserWindowsElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindowsElement.click();

        WebElement tabElement = driver.findElement(By.id("tabButton"));
        tabElement.click();

        //getWindowHandles returneaza toate ferestrele deschise
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        WebElement sampleHeadingElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new tab este: "+sampleHeadingElement.getText());
        driver.close();

        driver.switchTo().window(tabList.get(0));

        WebElement windowsElement = driver.findElement(By.id("windowButton"));
        windowsElement.click();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        WebElement sampleHeadingWindowElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new window este: "+sampleHeadingWindowElement.getText());

        driver.close();
        driver.switchTo().window(tabList.get(0));
    }
}
