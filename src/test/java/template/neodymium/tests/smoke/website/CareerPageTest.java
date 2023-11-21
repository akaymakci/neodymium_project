package template.neodymium.tests.smoke.website;

import org.junit.Test;
import template.flows.OpenPageFlows;
import template.neodymium.tests.AbstractTest;


public class CareerPageTest extends AbstractTest {


    @Test
    public void testBrowsing()
    {

        // go to homepage
        var homePage = OpenPageFlows.openHomePage();
//        homePage.validateStructure();

        // go to career page
        var careerPage = homePage.topNavigation.openCareerPage()    ;
        careerPage.validateStructure();


    }


}
