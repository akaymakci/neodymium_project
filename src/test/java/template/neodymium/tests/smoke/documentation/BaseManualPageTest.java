package template.neodymium.tests.smoke.documentation;

import org.junit.Test;

import template.flows.OpenPageFlows;
import template.neodymium.tests.AbstractTest;

public class BaseManualPageTest extends AbstractTest
{

    @Test
    public void testBrowsing()
    {

        var homePage = OpenPageFlows.openHomePage();

        // go to xlt page
        var xltPageOverview = homePage.topNavigation.openXltPage();
        // go to Documentation Page Category
        var docPage = xltPageOverview.goToDocumentationPage().goToDocsXltPage();
        docPage.validateStructure();

        var baseManualPageOverview = docPage.topNavigationForDocs.openBaseManualPage();
        baseManualPageOverview.validateStructure();
    }

}
