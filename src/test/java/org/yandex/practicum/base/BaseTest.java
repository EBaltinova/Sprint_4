package org.yandex.practicum.base;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.yandex.practicum.pages.Ordering;
import org.yandex.practicum.pages.Questions;

public class BaseTest {
    private final WebDriver chrome = new ChromeDriver();
    //private WebDriver firefox = new FirefoxDriver();
    BasePage basePage = new BasePage(chrome);
    protected Ordering ordering = new Ordering(chrome);
    protected Questions questions = new Questions(chrome);

    @After
    public void teardown() {
        chrome.quit();
        //firefox.quit();
    }

}
