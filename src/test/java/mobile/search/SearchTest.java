package mobile.search;

import mobile.BaseTest;
import mobile.po.ArticlePage;
import mobile.po.LanguageSelectPage;
import mobile.po.SkipPage;
import mobile.services.ArticleService;
import mobile.services.LanguageSelectService;
import mobile.services.LanguageService;
import mobile.services.SearchService;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {

    @Test
    void shouldBeArticleNameVisible() {
        new SkipPage().clickSkip();

        new SearchService().searchTest("Appium");

        var article = new ArticleService().getArticleName();

        assertThat(article).as("The article has wrong name").isEqualTo("Appium");
    }
    @Test
    void shouldBeSpanish(){
        new SkipPage().clickSkip();

        new SearchService().searchTest("Appium");

        new ArticleService().getArticle();

        new LanguageService().languageClick();

        new LanguageSelectService().spanishClick();

        var article = new ArticleService().getArticleHeader();

        assertThat(article).as("Header").isEqualTo("Historia");

    }
}
