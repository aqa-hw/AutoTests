package mobile.services;

import mobile.po.LanguageSelectPage;
import mobile.po.SearchPage;

public class LanguageSelectService {
    private final LanguageSelectPage languageSelectPage = new LanguageSelectPage();
    public void spanishClick(){
        languageSelectPage.clickOnSpanish();
    }
}
