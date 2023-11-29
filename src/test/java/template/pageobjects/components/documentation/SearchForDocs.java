package template.pageobjects.components.documentation;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import template.neodymium.tests.testdata.pageobjects.utils.XceptanceHelper;
import template.pageobjects.components.AbstractComponent;
import template.pageobjects.pages.documentation.SearchResultsPage;
import template.pageobjects.pages.documentation.SearchWithNoResultPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchForDocs extends AbstractComponent
{

    SelenideElement searchField = $("#docSearchInputField");

    @Override
    public void isComponentAvailable()
    {

        searchField.should(exist);
    }

    /// ----- search navigation ----- ///

    @Step("open search field")
    public void openSearch()
    {
        searchField.scrollTo().click();
        // searchField.click();
    }

    @Step("search for '{searchTerm}'")
    public void search(String searchTerm)
    {
        var agree = $("#agree");
        var algoliaSuggestion = $$(".algolia-docsearch-suggestion--content");
        openSearch();
        if (XceptanceHelper.optionalWaitUntilCondition(agree, visible, 1000))
        {
            agree.click();
        }
        searchField.val(searchTerm);
        if ($("div.algolia-docsearch-suggestion--text").getOwnText().contains(Neodymium.localizedText("docsPage.search.noResultsFound")))
        {
            searchField.pressEnter();
        }
        else
        {
            algoliaSuggestion.findBy(text(searchTerm)).shouldBe(visible).hover().click();
        }
    }

    @Step("search for '{searchTerm}' without result")
    public SearchWithNoResultPage searchWithNoResult(String searchTerm)
    {
        search(searchTerm);
        return new SearchWithNoResultPage().isExpectedPage();
    }

    @Step("search for '{searchTerm}' with result")
    public SearchResultsPage searchWithResults(String searchTerm)
    {
        search(searchTerm);
        return new SearchResultsPage().isExpectedPage();
    }

    /// ----- validate search ----- ///
    @Step("validate search bar")
    public void validateStructure()
    {

        searchField.shouldBe(visible);

    }

}
