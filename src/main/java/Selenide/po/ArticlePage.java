package Selenide.po;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ArticlePage {

    private SelenideElement firstHeading = $x("//h1[@id='firstHeading']/span");

    public String getHeadingOfArticle() {
        return firstHeading.getText();
    }
}
