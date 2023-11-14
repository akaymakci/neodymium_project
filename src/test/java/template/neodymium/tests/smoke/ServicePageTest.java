package template.neodymium.tests.smoke;

import com.xceptance.neodymium.util.DataUtils;
import com.xceptance.neodymium.util.Neodymium;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import template.flows.OpenPageFlows;
import template.neodymium.tests.AbstractTest;
import template.flows.OpenPageFlows.*;
import template.pageobjects.components.TopNavigation;
import template.pageobjects.pages.ServicePage;


public class ServicePageTest extends AbstractTest {


    @Test
    public void testBrowsing()
    {

        // go to homepage
        var homePage = OpenPageFlows.openHomePage();
//        homePage.validateStructure();

        // go to service page
        var servicePageOverview = homePage.topNavigation.openServicePage();
        servicePageOverview.validateStructure();

        // go to Sales Force Commerce Cloud Page Category
        servicePageOverview.goToSalesForceCommerceCloudPage().validateStructure();



    }


}
