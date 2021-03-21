import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void dragAndDropTo() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $(".column header").shouldHave(Condition.text("B"));
    }

    @Test // не работает
    void dragAndDropActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).perform();
        $(".column header").shouldHave(Condition.text("B"));
    }


}