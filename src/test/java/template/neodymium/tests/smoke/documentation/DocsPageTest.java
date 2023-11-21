package template.neodymium.tests.smoke.documentation;

import com.xceptance.neodymium.util.Neodymium;
import org.junit.Test;
import template.flows.OpenPageFlows;
import template.neodymium.tests.AbstractTest;
import template.pageobjects.components.documentation.TopNavigationForDocumentation;

public class DocsPageTest extends AbstractTest {

    @Test
    public void testBrowsing() {

//        TopNavigationForDocumentation topNavigationForDocumentation = new TopNavigationForDocumentation();
        var homePage = OpenPageFlows.openHomePage();

        // go to xlt page
        var xltPageOverview = homePage.topNavigation.openXltPage();
        // go to Documentation Page Category
        xltPageOverview.goToDocumentationPage().goToDocsPage().validateStructure();



//        var baseManualPageOverview = topNavigationForDocumentation.openBaseManualPage();
//        baseManualPageOverview.validateStructure();
    }
}
