package org.yandex.practicum.pages;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.yandex.practicum.base.BasePage;

import static org.hamcrest.CoreMatchers.containsString;

public class Ordering extends BasePage {
    private final By buttonTopToOrder = By.xpath("//button[@class='Button_Button__ra12g']"); // Кнопка заказать вверху страницы на главной
    private final By buttonDownToOrder = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[contains(text(), 'Заказать')]"); // Кнопка заказать внизу страницы на главной
    private final By inputName = By.xpath("//div[@class='Order_Form__17u6u']/div/input"); // Инпут имя
    private final By inputSurName = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']"); // Инпут фамилия
    private final By inputAddress = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']"); // Инпут адрес
    private final By inputPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // Инпут телефон
    private final By inputMetro = By.xpath("//input[@placeholder='* Станция метро']"); // Инпут метро
    private final By btnNext = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Кнопка далее в форме заказа
    private final By inputDate = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // Инпут даты
    private final By btnArrowRentalTime = By.xpath("//span[@class='Dropdown-arrow']"); // Стрелка в инпуте срок аренды
    private final By secondElementDropDownRentalTime = By.xpath("//div[@class='Dropdown-menu']//*[contains(text(), 'двое суток')]"); // второй элемент из выпадающего списка
    private final By checkboxColorScooterGrey = By.xpath("//div[@class='Order_Checkboxes__3lWSI']//label[@for='grey']"); // чекбокс второй в блоке цвет самоката
    private final By checkboxColorScooterBlack = By.xpath("//div[@class='Order_Checkboxes__3lWSI']//label[@for='black']"); // чекбокс второй в блоке цвет самоката
    private final By inputComment = By.xpath("//input[@placeholder='Комментарий для курьера']"); // инпут комментарий
    private final By btnToOrderInOrderCard = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // кнопка заказать в карточке заказа
    private final By btnYesInCardToOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Да')]"); // кнопка подтверждения заказа
    private final By orderDoneHeader = By.className("Order_ModalHeader__3FDaJ"); // заголовок в карточке заказ выполнен
    private final String expectedTextStatusOrder = "Заказ оформлен"; // проверочные данные

    public Ordering(WebDriver driver) {
        super(driver);
    }

    public Ordering orderButtonSelection(String btnClick) {
        if (btnClick.equals("top")) {
            clickOnElement(buttonTopToOrder);
        } else {
            scrollInOrder(buttonDownToOrder);
        }
        return this;
    }

    public Ordering enterDataInTheField(String name, String surName, String address, String phone) {
        findAndWaitElementAndSendKeys(inputName, name);
        findAndWaitElementAndSendKeys(inputSurName, surName);
        findAndWaitElementAndSendKeys(inputAddress, address);
        findElementInPage(inputMetro).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        findAndWaitElementAndSendKeys(inputPhone, phone); // телефон деда мороза
        return this;
    }

    public void selectColorButton(String color) {
        if (color.equals("grey")) {
            clickOnElement(checkboxColorScooterGrey);
        } else {
            clickOnElement(checkboxColorScooterBlack);
        }
    }

    public void getTextInCardOrderAndCheckActualText() {
        explicitWaitForElement(orderDoneHeader);
        String actualText = getText(orderDoneHeader);
        MatcherAssert.assertThat(actualText, containsString(expectedTextStatusOrder));
    }

    public Ordering makeToOrderClickScooter(String date, String comment, String color) {
        clickOnElement(btnNext);
        findAndWaitElementAndSendKeys(inputDate, date);
        clickOnElement(btnArrowRentalTime);
        clickOnElement(secondElementDropDownRentalTime);
        selectColorButton(color);
        findAndWaitElementAndSendKeys(inputComment, comment);
        clickOnElement(btnToOrderInOrderCard);
        clickOnElement(btnYesInCardToOrder);
        return this;
    }
}
