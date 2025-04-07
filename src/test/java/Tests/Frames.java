package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames {

    @Test
    public void automationMethod() {

        WebDriver driver;

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //definim wait implicit pt un interval max de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //browser in modul maximize
        driver.manage().window().maximize();

        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement alertFraneWindowsElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFraneWindowsElement.click();

        WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        alertsElement.click();

        WebElement frameElement = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameElement);

        WebElement sampleHeadingFrameElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new frame este: "+sampleHeadingFrameElement.getText());

        //ne mutam focusul pe pagina principala
        driver.switchTo().defaultContent();

        WebElement frame2Element = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2Element);

        js.executeScript("window.scrollBy(200,200)");
    }
}
