import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.MainPage;
import ru.praktikum.BasePage;
import ru.praktikum.OrderPage;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest{

    private final String name;
    private final String lastName;
    private final String city;
    private final String metro;
    private final String phone;


    public OrderTest(String name, String lastName, String city, String metro, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.metro = metro;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] getQue() {
        //Сгенерируй тестовые данные (нам нужно название городов и результат поиска)
        return new Object[][]{
                {"Василий", "Петров","Москва","Черкизовская","+79515553344"},
                {"Иван", "Петров","Москва","Сокольники","+79517775544"}
        };
    }

    @Test
    public void checkOrderTopButton() {

        //Открытие главной страницы и открытие формы заказа
        BasePage basePage = new BasePage(driver);
        OrderPage orderPage = new OrderPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        //Согласится с куки
        orderPage.clickCookie();
        //Заполнение имени
        basePage.pressTopButtonOrder();
        orderPage.inputName(name);
        orderPage.inputLastName(lastName);
        orderPage.inputAdress(city);
        orderPage.inputMetro(metro);
        orderPage.inputPhone(phone);
        orderPage.clickNext();
        orderPage.waitSecondPageOrder();
        orderPage.inputDate("01.11.2023");
        orderPage.inputRenatalPeriod("четверо суток");
        orderPage.clickChoiceColor();
        orderPage.inputComment("_Тест");
        orderPage.clickOrderButton();
        orderPage.waitConfirmOrderForm();
        //Кнопка с ошибкой хром
        //OrderPage.clickYesButton();
        orderPage.clickNoButton();

    }

    @Test
    public void checkOrderBottomButton() {

        //Открытие главной страницы и открытие формы заказа
        BasePage basePage = new BasePage(driver);
        OrderPage orderPage = new OrderPage(driver);
        MainPage mainPage = new MainPage(driver);
        //Согласится с куки
        mainPage.openMainPage();
        basePage.pressBottomButtonOrder();
        orderPage.clickCookie();
        basePage.pressBottomButtonOrder();
        //Заполнение имени
        orderPage.inputName(name);
        orderPage.inputLastName(lastName);
        orderPage.inputAdress(city);
        orderPage.inputMetro(metro);
        orderPage.inputPhone(phone);
        orderPage.clickNext();
        orderPage.waitSecondPageOrder();
        orderPage.inputDate("01.11.2023");
        orderPage.inputRenatalPeriod("четверо суток");
        orderPage.clickChoiceColor();
        orderPage.inputComment("_Тест");
        orderPage.clickOrderButton();
        orderPage.waitConfirmOrderForm();
        orderPage.clickYesButton();
        orderPage.waitOrderComleteForm();
        orderPage.clickSeeStatusButton();
        orderPage.waitStatusOrderPage();


    }

}
