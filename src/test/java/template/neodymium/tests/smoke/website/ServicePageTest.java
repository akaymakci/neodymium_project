package template.neodymium.tests.smoke.website;

import org.junit.Test;
import template.flows.OpenPageFlows;
import template.neodymium.tests.AbstractTest;

public class ServicePageTest extends AbstractTest
{

    @Test
    public void testBrowsing()
    {

        // go to homepage
        var homePage = OpenPageFlows.openHomePage();
        // homePage.validateStructure();

        // go to service page
        var servicePageOverview = homePage.topNavigation.openServicePage();
        servicePageOverview.validateStructure();

        // go to Sales Force Commerce Cloud Page Category
        servicePageOverview.goToSalesForceCommerceCloudPage().validateStructure();

    }

}
