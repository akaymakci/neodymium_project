package template.neodymium.tests.smoke.documentation;

import org.junit.Before;
import org.junit.Test;

import com.xceptance.neodymium.module.statement.testdata.DataSet;
import com.xceptance.neodymium.util.DataUtils;

import template.flows.OpenPageFlows;
import template.neodymium.tests.AbstractTest;
import template.neodymium.tests.smoke.testdata.pageobjects.components.SearchTestData;
import template.pageobjects.pages.documentation.DocsXltPage;

//@DataFile("src/test/resources/template/tests/smoke/SearchTest.json")
public class SearchTest extends AbstractTest
{

    private SearchTestData searchTestData;

    private DocsXltPage docsXltPage;

    // public void setup()
    // {
    // searchTestData = DataUtils.get(SearchTestData.class);
    // }

    @Before
    public void openDocsXltPage()
    {
        searchTestData = DataUtils.get(SearchTestData.class);

        // go to homepage
        var homePage = OpenPageFlows.openHomePage();

        // go to xlt page
        var xltPageOverview = homePage.topNavigation.openXltPage();

        // go to Documentation Page Category
        docsXltPage = xltPageOverview.goToDocumentationPage().goToDocsXltPage();
        docsXltPage.validateStructure();
    }

    @Test
    @DataSet(id = "search with results")
    public void testSearching()
    {
        // go to Search with results page

        var searchForDocsPage = docsXltPage.topNavigationForDocs.searchForDocs;
        var searchWithResultsPage = searchForDocsPage.searchWithResults(searchTestData.getSearchTerm());
        searchWithResultsPage.validateDocsCategoryHeadline(searchTestData.getSearchTerm(), searchTestData.getExpectedResult());

        // go to Docs page
        var docsPage = searchWithResultsPage.openDocsPage();
        docsPage.validateStructure();

    }

    @Test
    @DataSet(id = "search with no result")
    public void testSearchingWithoutResult()
    {
        // go to Search with no results page
        var searchForDocsPage = docsXltPage.topNavigationForDocs.searchForDocs;
        var searchWithNoResultPage = searchForDocsPage.searchWithNoResult(searchTestData.getSearchTerm());
        searchWithNoResultPage.validateStructure();

        // go to Docs Page
        var docsPage = searchWithNoResultPage.openDocsPage();
        docsPage.validateStructure();
    }

}
