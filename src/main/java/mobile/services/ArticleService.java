package mobile.services;

import mobile.po.ArticlePage;

public class ArticleService {

    private final ArticlePage articlePage = new ArticlePage();

    public String getArticleName() {
        return articlePage
                .clickFirstArticle()
                .getArticleName();
    }
    public ArticlePage getArticle(){
        return articlePage
                .clickFirstArticle();
    }
    public String getArticleHeader(){
        return articlePage
                .getArticleHeader();
    }
}
