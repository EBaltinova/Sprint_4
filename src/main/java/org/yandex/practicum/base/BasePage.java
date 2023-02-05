package org.yandex.practicum.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void explicitWaitForElement(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(By element) {
        explicitWaitForElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
    }

    public void findAndWaitElementAndSendKeys(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public void clickOnElement(By element) {
        explicitWaitForElement(element);
        driver.findElement(element).click();
    }

    public String getText(By element) {
        WebElement getTextEl = driver.findElement(element);
        return getTextEl.getText();
    }

    public WebElement findElementInPage(By element) {
        explicitWaitForElement(element);
        return driver.findElement(element);
    }

    public void scrollInOrder(By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        driver.findElement(element).click();
    }
}
