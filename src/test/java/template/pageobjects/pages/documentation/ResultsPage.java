package template.pageobjects.pages.documentation;

import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import template.neodymium.tests.smoke.testdata.pageobjects.components.SearchTestData;
import template.pageobjects.components.documentation.SearchForDocs;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultsPage extends AbstractDocsBrowsingPage{

    @Step("ensure this is a Results Page")
    @Override
    public ResultsPage isExpectedPage()
    {
        super.isExpectedPage();
        var navOlLiA = $("nav ol li a");
        navOlLiA.shouldBe(visible);
        return this;
    }
    @Step("validate category page of category '{categoryName}'")
    public void validate(String searchTermToValidate)
    {
        validateStructure();
        validateDocsCategoryHeadline(searchTermToValidate);
    }
    public void validateDocsCategoryHeadline(String docCategoryName){
        var activeClass = $$("#td-section-nav ul li[class*='collapse'] > a[class]");
        activeClass.findBy(exactText(docCategoryName)).shouldBe(visible);

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
