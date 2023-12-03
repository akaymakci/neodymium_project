package template.neodymium.tests.smoke.website;

import org.junit.Test;
import template.flows.OpenPageFlows;
import template.neodymium.tests.AbstractTest;

public class XltPageTest extends AbstractTest
{

    @Test
    
    public void testBrowsing()
    {

        // go to homepage
        var homePage = OpenPageFlows.openHomePage();

        // go to service page
        var xltPageOverview = homePage.topNavigation.openXltPage();
        xltPageOverview.validateStructure();

        // go to Documentation Page Category
        // xltPageOverview.goToDocumentationPage().validateStructure();

    }

}
