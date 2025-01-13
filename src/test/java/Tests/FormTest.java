package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class FormTest {

    public WebDriver driver;

    @Test
    public void automationMethod() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //browser in modul maximize
        driver.manage().window().maximize();

        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement formElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formElement.click();

        WebElement practiceFormElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormElement.click();

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Sorel";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Silva";
        lastNameField.sendKeys(lastNameValue);

        WebElement userEmailField = driver.findElement(By.id("userEmail"));
        String userEmailValue = "silva@gmail.com";
        userEmailField.sendKeys(userEmailValue);

        WebElement userNumberField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String userNumberValue = "0723154125";
        userNumberField.sendKeys(userNumberValue);

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/Minecraft.jpeg");
        pictureElement.sendKeys(file.getAbsolutePath());

        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        String gender = "Other";

        if (maleElement.getText().equals(gender)) {
            maleElement.click();
        }
        else if (femaleElement.getText().equals(gender)) {
            femaleElement.click();
        }
        else if (otherElement.getText().equals(gender)) {
            otherElement.click();
        }

        WebElement SubjectsElement = driver.findElement(By.id("subjectsInput"));
        String SubjectsValue = "Social Studies";
        SubjectsElement.sendKeys(SubjectsValue);
        SubjectsElement.sendKeys(Keys.ENTER);

        WebElement StateElement = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click();", StateElement);
        StateElement.sendKeys("NCR");
        StateElement.sendKeys(Keys.ENTER);

        WebElement CityElement = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();", CityElement);
        CityElement.sendKeys("Delhi");
        CityElement.sendKeys(Keys.ENTER);

        WebElement SubmitElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", SubmitElement);

    }
}
