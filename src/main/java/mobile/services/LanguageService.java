package mobile.services;

import mobile.po.SearchPage;

public class LanguageService {
    private final SearchPage searchPage = new SearchPage();
    public void languageClick(){
        searchPage.clickOnLanguageButton();
    }
}
