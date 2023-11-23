package template.neodymium.tests.smoke.documentation;

import com.xceptance.neodymium.module.statement.testdata.DataSet;
import com.xceptance.neodymium.util.DataUtils;
import org.junit.Before;
import org.junit.Test;
import template.flows.OpenPageFlows;
import template.neodymium.tests.AbstractTest;
import template.neodymium.tests.smoke.testdata.pageobjects.components.SearchTestData;
//@DataFile("src/test/resources/template/tests/smoke/SearchTest.json")
public class SearchTest extends AbstractTest {

    private SearchTestData searchTestData;

    @Before
    public void setup()
    {
        searchTestData = DataUtils.get(SearchTestData.class);
    }

    @Test
    @DataSet(1)
    public void testSearching()
    {
        // go to homepage
        var homePage = OpenPageFlows.openHomePage();

        // go to xlt page
        var xltPageOverview = homePage.topNavigation.openXltPage();
        // go to Documentation Page Category
        var docsXltPage= xltPageOverview.goToDocumentationPage().goToDocsXltPage();
        docsXltPage.validateStructure();

        // go to category page
        var resultsPage = docsXltPage.topNavigationForDocs.searchForDocs.searchWithResults(searchTestData.getSearchTerm());
        resultsPage.validate(searchTestData.getSearchTerm());

        // go to docspage
        var docsPage = docsXltPage.openDocsPage();
        docsPage.validateStructure();


    }
    @Test
    @DataSet(2)
    public void testSearchingWithoutResult()
    {
        // go to homepage
        var homePage = OpenPageFlows.openHomePage();

        // go to xlt page
        var xltPageOverview = homePage.topNavigation.openXltPage();

        // go to Documentation Page Category
        var docsXltPage = xltPageOverview.goToDocumentationPage().goToDocsXltPage();
        docsXltPage.validateStructure();

        // go to no hits page
        var noHitsPage = docsXltPage.topNavigationForDocs.searchForDocs.noHitsPageResult(searchTestData.getSearchTerm());
        noHitsPage.validateStructure();

//        // go to docsPage
        var docsPage = docsXltPage.openDocsPage();
        docsPage.validateStructure();
    }

}
