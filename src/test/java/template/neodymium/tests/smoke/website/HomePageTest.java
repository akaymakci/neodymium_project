package template.neodymium.tests.smoke.website;

import com.xceptance.neodymium.util.AllureAddons;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import org.junit.Test;
import template.flows.OpenPageFlows;
import template.neodymium.tests.AbstractTest;

@Owner("A Kaymakci")
@Tag("smoke")
@Issue("1")
@DisplayName("HomepageTest")
public class HomePageTest extends AbstractTest
{
    @Test
    @Description(value = "A basic description for home page validation.")
    public void goToHomePage()
    {
        AllureAddons.addToReport("Find me in the report", "Some additional content. Could be the toString method of an complex object.");
        // Goto the home page and perform a short validation that we are on the correct page
        var homePage = OpenPageFlows.openHomePage();
        homePage.isExpectedPage();

        // basic validation
        homePage.validateStructure();
        homePage.title.validateTitle(Neodymium.localizedText("homepage.title"));
    }
}
