import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import po.wiki.ArticlePage;
import po.wiki.HistoryPage;
import po.wiki.SearchPage;

import static org.assertj.core.api.Assertions.assertThat;

public class MainClassTest extends BaseTest {

    @Test(dataProvider = "search_provider", groups = {"Smoke"})
    void shouldBeUbisoftArticle(String search) {

        new SearchPage()
                .searchUbisoftArticle(search)
                .clickEnter()
                .clickOnUbisoftArticle();

        assertThat(new ArticlePage().getHeadingOfArticle()).as("The text must be Ubisoft").isEqualTo("Ubisoft");

    }

    @Test(groups = {"Regression"})
    void shouldBeVisibleHistoryPage() {
        new HistoryPage()
                .historyButtonClick()
                .getHistoryHeader();
        assertThat(new HistoryPage().getHistoryHeader()).as("The text must be:").isEqualTo("Заглавная страница: история изменений");

    }

    @DataProvider(name = "search_provider")
    public Object[][] search_methods() {
        return new Object[][]{
                {"Ubisoft"},
                {"Sony"}
        };
    }

}
