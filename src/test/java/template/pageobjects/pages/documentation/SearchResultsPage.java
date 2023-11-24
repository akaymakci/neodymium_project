package template.pageobjects.pages.documentation;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage extends AbstractDocsBrowsingPage{

    @Step("ensure this is a Results Page")
    @Override
    public SearchResultsPage isExpectedPage()
    {
        super.isExpectedPage();
        var navOlLiA = $("nav ol li a");
        navOlLiA.shouldBe(visible);
        return this;
    }
    @Step("validate category page of category '{categoryName}'")
    public void validate(String searchTermToValidate, String expectedResultToValidate)
    {
        validateStructure();
        validateDocsCategoryHeadline(searchTermToValidate,expectedResultToValidate);
    }
    public void validateDocsCategoryHeadline(String docCategoryName, String expectedDocCategoryName){

        var algoliaSearchResultContent =$$("main div.td-content");
        var activeClass = $$("#td-section-nav ul li[class*='collapse'] > a[class]");

        algoliaSearchResultContent.findBy(text(docCategoryName)).shouldBe(visible);
        activeClass.findBy(exactText(expectedDocCategoryName)).shouldBe(visible);

    }

    public void validateStructure()
    {
        super.validateStructure();
        $$("nav ol li a").first().shouldBe(visible);
        $("div h1").should(exist);
    }

    @Step("open homepage from Search Results page")
    public DocsPage openDocsPage()
    {
        $(".navbar-brand").scrollTo().click();
        return new DocsPage().isExpectedPage();
    }

}
