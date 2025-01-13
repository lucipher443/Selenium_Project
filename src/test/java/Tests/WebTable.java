package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {

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

        //declaram un element
        WebElement ElementsField = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ElementsField.click();

        WebElement TableField = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        TableField.click();

        List<WebElement> tableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize = tableElements.size();

        WebElement AddField = driver.findElement(By.id("addNewRecordButton"));
        AddField.click();

        WebElement FirstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Lucian";
        FirstNameField.sendKeys(firstNameValue);

        WebElement LastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Grosu";
        LastNameField.sendKeys(lastNameValue);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailValue = "lucian.grosu@gmail.com";
        emailField.sendKeys(emailValue);

        WebElement ageField = driver.findElement(By.id("age"));
        String ageValue = "43";
        ageField.sendKeys(ageValue);

        WebElement salaryField = driver.findElement(By.id("salary"));
        String salaryValue = "12000";
        salaryField.sendKeys(salaryValue);

        WebElement departmentField = driver.findElement(By.id("department"));
        String departmentValue = "IT";
        departmentField.sendKeys(departmentValue);

        WebElement SubmitField = driver.findElement(By.id("submit"));
        SubmitField.click();

        List<WebElement> expectedTableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));

        Integer expectedTableSize = actualTableSize + 1;

        Assert.assertEquals(expectedTableElements.size(), expectedTableSize);

        String actualTableValue = expectedTableElements.get(3).getText();

        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(emailValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(salaryValue));
        Assert.assertTrue(actualTableValue.contains(departmentValue));
    }

}