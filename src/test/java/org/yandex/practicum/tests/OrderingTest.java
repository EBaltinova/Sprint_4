package org.yandex.practicum.tests;

import org.yandex.practicum.base.BaseTest;
import org.junit.Test;
import static org.yandex.practicum.base.Constants.Urls.MAIN_PAGE_URL;

public class OrderingTest extends BaseTest {
    @Test
    public void makeToOrderClickScooterAndCheckHeaderOrderDonPositiveOneTest()  {
        ordering.open(MAIN_PAGE_URL);
        ordering.orderButtonSelection("top").enterDataInTheField("Роман", "Иванов", "ул.Челюскинцев, 144, Саратов, Саратовская обл.", "890065465437")
                .makeToOrderClickScooter("28.12.2022", "comment", "grey")
                .getTextInCardOrderAndCheckActualText();
    }

    @Test
    public void makeToOrderClickScooterAndCheckHeaderOrderDonPositiveSecondTest()  {
        ordering.open(MAIN_PAGE_URL);
        ordering.orderButtonSelection("down").enterDataInTheField("Егор", "Петров", "улица Победы над ленью", "890065465444")
                .makeToOrderClickScooter("28.12.2023"," comment2", "black")
                .getTextInCardOrderAndCheckActualText();
    }

}