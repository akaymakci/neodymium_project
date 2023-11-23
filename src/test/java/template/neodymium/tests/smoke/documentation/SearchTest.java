package template.neodymium.tests.smoke.documentation;

import com.xceptance.neodymium.module.statement.testdata.DataFile;
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
        var docsPage= xltPageOverview.goToDocumentationPage().goToDocsPage();
        docsPage.validateStructure();

        // go to category page
        var resultsPage = docsPage.topNavigationForDocs.searchForDocs.resultsPageResult(searchTestData.getSearchTerm());
        resultsPage.validate(searchTestData.getSearchTerm());

        //go to product detail page
//        final String productName = categoryPage.getProductNameByPosition(searchTestData.getResultPosition());
//        var productDetailPage = resultsPage.clickProductByPosition(searchTestData.getResultPosition());
//        productDetailPage.validate(productName);

        //TODO:
        // go to homepage
        // homePage = productDetailPage.openHomePage(); // --- Burayi tamamla
    }



}
