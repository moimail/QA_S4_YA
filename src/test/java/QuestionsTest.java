import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.BasePage;
import ru.praktikum.MainPage;
import ru.praktikum.Questions;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)

public class QuestionsTest extends BaseTest {
    private final String text;
    private final String link;
    public QuestionsTest(String text, String link) {
        this.text = text;
        this.link = link;
    }
    @Parameterized.Parameters
    public static Object[][] getQue() {
        //Сгенерируй тестовые данные (нам нужно название городов и результат поиска)
        return new Object[][]{
                {"Сутки — 400 рублей", "0"},
                {"Пока что у нас так: один заказ", "1"},
                {"Допустим, вы оформляете заказ", "2"},
                {"Только начиная с завтрашнего дня", "3"},
                {"Пока что нет!", "4"},
                {"Самокат приезжает к вам с полной зарядкой", "5"},
                {"Да, пока самокат не привезли", "6"},
                {"Да, обязательно.", "7"}
        };
    }


    @Test
    public void checkQuestions() {

            Questions questions = new Questions(driver);
            BasePage basePage = new BasePage(driver);
            MainPage mainPage = new MainPage(driver);
            mainPage.openMainPage();
            //Проверка вопросов о важном
            questions.pressQue(link);
            //Проверка текста ответа на вопрос
        assertTrue(ru.praktikum.Questions.getTextQue(text).contains(text));

        }
    }

