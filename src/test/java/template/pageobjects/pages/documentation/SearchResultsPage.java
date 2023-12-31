package template.pageobjects.pages.documentation;

import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage extends AbstractDocsBrowsingPage
{

    @Step("ensure this is a Results Page")
    @Override
    public SearchResultsPage isExpectedPage()
    {
        super.isExpectedPage();
        var navOlLiA = $("nav ol li a");
        var contentMobil = $("#content-mobile");
        if (Neodymium.isDesktop())
        {
            navOlLiA.shouldBe(visible);
        }
        else
        {
            contentMobil.shouldBe(visible);
        }
        return this;

    }

    @Step("validate category page of category '{categoryName}'")
    public void validate(String searchTermToValidate, String expectedResultToValidate)
    {
        validateStructure();
        validateDocsCategoryHeadline(searchTermToValidate, expectedResultToValidate);
    }

    public void validateDocsCategoryHeadline(String docCategoryName, String expectedDocCategoryName)
    {

        var algoliaSearchResultContent = $$("main div.td-content");
        var activeClass = $$("#td-section-nav ul li[class*='collapse'] > a[class]");
        var tdContentH1 = $$(".td-content h1");

        algoliaSearchResultContent.findBy(text(docCategoryName)).shouldBe(visible);
        if (Neodymium.isDesktop())
        {
            activeClass.findBy(exactText(expectedDocCategoryName)).shouldBe(visible);
        }
        else
        {
            tdContentH1.findBy(exactText(expectedDocCategoryName)).shouldBe(visible);
        }

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
        var navbarBrand = $(".navbar-brand");
        if (Neodymium.isDesktop())
        {
            navbarBrand.scrollTo().click();
        }
        else
        {
            navbarBrand.scrollIntoView(true).click();
        }
        return new DocsPage().isExpectedPage();
    }

}
