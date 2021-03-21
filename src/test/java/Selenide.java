import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Selenide {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void selenideWiki() {
        open("https://github.com/selenide/selenide");

        actions().sendKeys("g", "w").perform();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-content").shouldHave(text("@ExtendWith"));
    }
}
