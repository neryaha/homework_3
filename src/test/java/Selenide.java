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
        open("https://github.com/");

        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $("ul.repo-list li").$("a").click();
        $("#wiki-tab").click();
        $("#wiki-body").$(byText("Soft assertions")).click();
        $("#wiki-content").shouldHave(text("@ExtendWith"));
    }
}
