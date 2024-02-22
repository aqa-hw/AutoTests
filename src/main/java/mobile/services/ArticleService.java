package mobile.services;

import mobile.po.ArticlePage;

public class ArticleService {

    private final ArticlePage articlePage = new ArticlePage();

    public String getArticleName() {
        return articlePage
                .clickFirstArticle()
                .getArticleName();
    }

    public void clickArticle() {
        articlePage
                .clickFirstArticle();
    }
    public void clickMoreTopRead(){
        articlePage
                .clickElementMoreTopRead();
    }
    public void clickValentineArticle(){
        articlePage
                .clickValentineArticle();
    }
}
