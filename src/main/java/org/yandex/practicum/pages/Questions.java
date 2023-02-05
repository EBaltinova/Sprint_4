package org.yandex.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.yandex.practicum.base.BasePage;

import static org.junit.Assert.assertEquals;

public class Questions extends BasePage {
    private final By questionsImportantBlock = By.className("Home_FourPart__1uthg"); // Родительский блок "Вопросы о важном"
    private WebDriver driver;

    public Questions(WebDriver driver) {
        super(driver);
    }

    public Questions scrollToBlockQuestionsImportant() {
        scrollToElement(questionsImportantBlock);
        return this;
    }

    public void clickElementItemsQuestionsImportantAndCheckTextInList(By el, By actualText, String expectedText) {
        clickOnElement(el);
        explicitWaitForElement(actualText);
        String text = getText(actualText);
        assertEquals(expectedText, text);
    }
}
