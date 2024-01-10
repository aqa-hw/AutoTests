package Selenide;

import Selenide.po.HistoryPage;
import Selenide.po.ArticlePage;
import Selenide.po.SearchPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WikiTest extends BaseTest {
    @Test
    void shouldBeOpenedArticle(){

        new SearchPage()
                .searchUbisoftArticle("Ubisoft")
                .clickEnter()
                .clickOnUbisoftArticle();

        assertThat(new ArticlePage().getHeadingOfArticle()).as("The text must be Ubisoft").isEqualTo("Ubisoft");

    }
    @Test
    void shouldBeVisibleHistoryPage() {
        new HistoryPage()
                .historyButtonClick()
                .getHistoryHeader();

        assertThat(new HistoryPage().getHistoryHeader()).as("The text must be:").isEqualTo("Заглавная страница: история изменений");

    }
}
