package template.pageobjects.components.documentation;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import template.neodymium.tests.smoke.testdata.pageobjects.utils.XceptanceHelper;
import template.pageobjects.components.AbstractComponent;
import template.pageobjects.pages.documentation.NoHitsPage;
import template.pageobjects.pages.documentation.ResultsPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchForDocs extends AbstractComponent {

    SelenideElement searchField = $("#docSearchInputField");
    @Override
    public void isComponentAvailable() {

        searchField.should(exist);
    }

    /// ----- search navigation ----- ///

    @Step("open search field")
    public void openSearch()
    {
        searchField.scrollTo().click();
//        searchField.click();
    }

    @Step("search for '{searchTerm}'")
    public void search(String searchTerm)
    {
        var agree = $("#agree");
        var algoliaSuggestion = $$(".algolia-docsearch-suggestion--subcategory-column-text");
        openSearch();
        if(XceptanceHelper.optionalWaitUntilCondition(agree,visible,1000)) {
            agree.click();
        }
        searchField.val(searchTerm);
        if ($("div.algolia-docsearch-suggestion--text").getOwnText().contains("No results"))
            searchField.pressEnter();
        else
            algoliaSuggestion.findBy(exactText(searchTerm)).shouldBe(visible).hover().click();

    }
    @Step("validate that '{searchTerm}' is still visible after search")
    public void validateSearchTerm(String searchTerm)
    {
        openSearch();
        searchField.shouldHave(exactValue(searchTerm));

    }

    @Step("validate that no results are on search")
    public void validateNoResultsFound()
    {
        $(".algolia-docsearch-suggestion--text").shouldHave(text(Neodymium.localizedText("docsPage.search.noResultsFound")));
    }

    @Step("search for '{searchTerm}' without result")
    public NoHitsPage noHitsPageResult(String searchTerm)
    {
        search(searchTerm);
        return new NoHitsPage().isExpectedPage();
    }
    @Step("search for '{searchTerm}' with result")
    public ResultsPage searchWithResults(String searchTerm)
    {
        search(searchTerm);
        return new ResultsPage().isExpectedPage();
    }
    /// ----- validate search ----- ///
    @Step("validate search bar")
    public void validateStructure()
    {

        searchField.shouldBe(visible);


    }

}
