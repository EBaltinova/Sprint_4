package org.yandex.practicum.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.yandex.practicum.base.BaseTest;

import static org.yandex.practicum.base.Constants.Urls.MAIN_PAGE_URL;

@RunWith(Parameterized.class)
public class QuestionsTest extends BaseTest {
    private final By elQuestionsImportant;  // Элементы аккордиона из блока на главной странице "Вопросы о важном" для клика и раскрытия списка
    private final By getPathTextQuestionsImportantItem; // Список путей для получения текста из абзацев в аккордеон "Вопросы о важном"
    private final String expectedText; // Проверочный текст для абзацев из аккордиона

    public QuestionsTest(By elQuestionsImportant, By getPathTextQuestionsImportantItem, String expectedText) {
        this.elQuestionsImportant = elQuestionsImportant;
        this.getPathTextQuestionsImportantItem = getPathTextQuestionsImportantItem;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] checkElementItemText() {
        return new Object[][]{
                {By.id("accordion__heading-0"), By.id("accordion__panel-0"), "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",},
                {By.id("accordion__heading-1"), By.id("accordion__panel-1"), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",},
                {By.id("accordion__heading-2"), By.id("accordion__panel-2"), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",},
                {By.id("accordion__heading-3"), By.id("accordion__panel-3"), "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",},
                {By.id("accordion__heading-4"), By.id("accordion__panel-4"), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",},
                {By.id("accordion__heading-5"), By.id("accordion__panel-5"), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",},
                {By.id("accordion__heading-6"), By.id("accordion__panel-6"), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",},
                {By.id("accordion__heading-7"), By.id("accordion__panel-7"), "Да, обязательно. Всем самокатов! И Москве, и Московской области.",},
        };
    }

    @Test
    public void clickAndCheckTextItemsListQuestionsImportantPositiveTest() {
        questions.open(MAIN_PAGE_URL);
        questions.scrollToBlockQuestionsImportant()
                .clickElementItemsQuestionsImportantAndCheckTextInList(elQuestionsImportant, getPathTextQuestionsImportantItem, expectedText);
    }
}
