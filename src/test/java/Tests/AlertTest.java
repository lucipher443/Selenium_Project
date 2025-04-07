package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

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

        WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertsElement.click();

        WebElement alertOkElement = driver.findElement(By.id("alertButton"));
        alertOkElement.click();

        //ne mutam focusul pe alerta
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

        WebElement alertDelayOkElement = driver.findElement(By.id("timerAlertButton"));
        alertDelayOkElement.click();

        //definim un wait explicit care sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertDelayOk = driver.switchTo().alert();
        alertDelayOk.accept();

        WebElement alertConfirmElement = driver.findElement(By.id("confirmButton"));
        alertConfirmElement.click();
        Alert alertConfirm = driver.switchTo().alert();
        alertConfirm.dismiss();

        WebElement confirmResultElement = driver.findElement(By.id("confirmResult"));
        System.out.println("Textul din confirm result este: "+confirmResultElement.getText());

        WebElement alertPromtElement = driver.findElement(By.id("promtButton"));
        alertPromtElement.click();
        Alert alertPromt = driver.switchTo().alert();
        alertPromt.sendKeys("Lucian");
        alertPromt.accept();

        WebElement promptResultElement = driver.findElement(By.id("promptResult"));
        System.out.println("Textul din confirm result este: "+promptResultElement.getText());
    }
}
