package template.pageobjects.pages.website;

import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SalesForceCommerceCloudPage extends AbstractBrowsingPage
{

    @Step("ensure this is a Service Page")
    @Override
    public SalesForceCommerceCloudPage isExpectedPage()
    {
        var dwOverviewContainer = $("#dw-overview");
        super.isExpectedPage();
        dwOverviewContainer.should(exist);
        return this;
    }

    @Step("validate the Sales Force Commerce Cloud page")
    public void validateStructure()
    {
        ServicePage servicePage = new ServicePage();
        var demandWareContainer = $("#demandware");
        var morePaddingContainer = $(".more-padding");
        var dwOverviewContainer = $("#dw-overview");
        var teaserContainer = $("#teaser");

        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();
        servicePage.validateSubCategories();

        // Validates Salesforce Commerce Cloud
        $(".demandware-testing").should(exist);

        // validate teaser
        demandWareContainer.find(teaserContainer.getSearchCriteria()).should(exist);

        // Asserts the first headline is there.
        $("#text h1").shouldBe(matchText("[A-Z].{10,}"));
        demandWareContainer.find(teaserContainer.getSearchCriteria() + " h1")
                           .shouldHave(exactText(Neodymium.localizedText("servicePage.salesforce.teaser.headline")));

        // Validates Salesforce Pictures are there
        $$(teaserContainer.getSearchCriteria() + " a img").shouldHaveSize(1);

        // Asserts salesforce link title
        demandWareContainer.find(teaserContainer.getSearchCriteria() + " a img")
                           .shouldHave(attribute("title", Neodymium.localizedText("servicePage.salesforce.teaser.linkTitle")));

        // Validates Intro headline is there
        morePaddingContainer.find(".text-center h1").shouldHave(matchText("[A-Z].{3,}"));

        // Asserts Intro headline
        morePaddingContainer.find(".text-center h1").shouldHave(exactText(Neodymium.localizedText("servicePage.salesforce.intro.headline")));

        // Validates Intro headline is there
        morePaddingContainer.find(".text-center p").shouldHave(matchText("[A-Z].{10,}"));

        // Verifies DemandWare Sections are there
        $$(dwOverviewContainer.getSearchCriteria() + " > div > div").shouldHaveSize(2);

        // Validates E-commerce Testing's Picture is there
        $$(dwOverviewContainer.getSearchCriteria() + "  > div > div i").shouldHaveSize(1);

        // Asserts Headlines Text
        if (Neodymium.isDesktop())
        {
            $$(dwOverviewContainer.getSearchCriteria() + " h2").findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.eCommerce")))
                                                               .should(exist);
        }
        $$(dwOverviewContainer.getSearchCriteria() + " h2").findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.weKnow"))).should(exist);
        $$(dwOverviewContainer.getSearchCriteria() + " h2").findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.functionalTesting")))
                                                           .should(exist);
        $$(dwOverviewContainer.getSearchCriteria() + " h2").findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.agileTesting")))
                                                           .should(exist);
        $$(dwOverviewContainer.getSearchCriteria() + " h2").findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.loadAndPerformance")))
                                                           .should(exist);
        $$(dwOverviewContainer.getSearchCriteria() + " h2").findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.testAutomation")))
                                                           .should(exist);
        if (Neodymium.isDesktop())
        {
            // Validates Fact Tables are there
            $$(dwOverviewContainer.getSearchCriteria() + " td.key").shouldHaveSize(2);
            $$(dwOverviewContainer.getSearchCriteria() + " td.value").shouldHaveSize(2);

            // Validates Texts are there
            $$(dwOverviewContainer.getSearchCriteria() + " p.lead").shouldHaveSize(5);
            $$(dwOverviewContainer.getSearchCriteria() + " p.lead, p.lead~p, p.lead~ul").shouldHaveSize(11);
        }
    }

}
