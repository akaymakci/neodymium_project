package template.pageobjects.pages.website;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ServicePage extends AbstractBrowsingPage
{
    public SelenideElement servicesElement = $(".services");

    @Step("ensure this is a Service Page")
    @Override
    public ServicePage isExpectedPage()
    {
        super.isExpectedPage();
        servicesElement.should(exist);
        return this;
    }

    @Step("validate the service page")
    public void validateStructure()
    {
        var teaserContainer = $("#teaser");
        var testGuidanceContainer = $("#test-guidance");
        var functionalTestingContainer = $("#functional-testing");
        var performanceTestingContainer = $("#performance-testing");

        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();

        // Validates services
        $(".services").should(exist);

        // validate teaser
        $("#teaser").should(exist);

        // Asserts teaser text there.
        if (Neodymium.isDesktop())
        {
            $$(teaserContainer.getSearchCriteria() + " h1").findBy(matchText("[A-Z].{3,}")).should(exist);
            $$(teaserContainer.getSearchCriteria() + " h1").findBy(exactText(Neodymium.localizedText("servicePage.overview.teaser.headline")))
                                                           .shouldBe(visible);
        }

        // Verifies service section
        // $x("//*[@id=\"main\"]//div[@class=\"container\"]//div[@class]").shouldHave(sizeGreaterThan())

        // Validates Functional Testing
        // Validates Pictures are there
        $$(functionalTestingContainer.getSearchCriteria() + " i").shouldHaveSize(2);

        // Asserts Headlines text are there
        $$(functionalTestingContainer.getSearchCriteria()
               + " h2").findBy(exactText(Neodymium.localizedText("servicePage.overview.functionalTesting.manualTesting"))).should(exist);
        $$(functionalTestingContainer.getSearchCriteria()
               + " h2").findBy(exactText(Neodymium.localizedText("servicePage.overview.functionalTesting.automatedTesting"))).should(exist);

        // Validates Headlines are there
        $$(functionalTestingContainer.getSearchCriteria() + " p.lead").shouldHaveSize(2);

        // Validates Texts are there
        $$(functionalTestingContainer.getSearchCriteria() + " p.lead+p").shouldHaveSize(2);

        // Validates Load and Performance Testing
        // Validates Pictures are there
        $$(performanceTestingContainer.getSearchCriteria() + " i").shouldHaveSize(1);

        // Asserts Headline's texts are there
        $$(performanceTestingContainer.getSearchCriteria()
               + " h2").findBy(exactText(Neodymium.localizedText("servicePage.overview.performanceTesting.loadUndPerformanceTesting"))).should(exist);
        $$(performanceTestingContainer.getSearchCriteria()
               + " h3").findBy(exactText(Neodymium.localizedText("servicePage.overview.performanceTesting.subHeader.serverSidePerformanceTesting")))
                       .should(exist);
        $$(performanceTestingContainer.getSearchCriteria()
               + " h3").findBy(exactText(Neodymium.localizedText("servicePage.overview.performanceTesting.subHeader.clientSidePerformanceTesting")))
                       .should(exist);

        // Validates Headlines' subtexts are there
        $$(performanceTestingContainer.getSearchCriteria() + " p.lead, h3+p").shouldHaveSize(4);

        // Validates Texts are there
        $$(performanceTestingContainer.getSearchCriteria() + " h3+p").shouldHaveSize(2);

        // Asserts Bullet points number
        $$(performanceTestingContainer.getSearchCriteria() + " li").shouldHaveSize(6);

        // Validates Texts are there
        $$(performanceTestingContainer.getSearchCriteria() + " li").findBy(matchText("[A-Z].{3,}")).should(exist);

        // Validates Test Guidance
        // Validates Pictures are there
        $$(testGuidanceContainer.getSearchCriteria() + " i").findBy(exactText("")).shouldBe(visible);

        // Asserts Headlines text are there
        $$(testGuidanceContainer.getSearchCriteria() + " h2").findBy(exactText(Neodymium.localizedText("servicePage.overview.testGuidance"))).shouldBe(visible);

        // Validates Headlines are there
        $$(testGuidanceContainer.getSearchCriteria() + " p.lead").shouldHaveSize(1);

        // Validates Texts are there
        $$(testGuidanceContainer.getSearchCriteria() + " p.lead+p").findBy(matchText("[A-Z].{5,}")).should(visible);

        // Validates subnavigation
        validateSubCategories();

    }

    public void validateSubCategories()
    {
        topNavigation.validateSubCategoryByLocalizationPath("header.topNavigation.subNavigation.services.salesforce");
        topNavigation.validateSubCategoryByLocalizationPath("header.topNavigation.subNavigation.services.overview");
    }

    public SalesForceCommerceCloudPage goToSalesForceCommerceCloudPage()
    {
        topNavigation.clickSubCategory(Neodymium.localizedText("header.topNavigation.subNavigation.services.salesforce"));
        return new SalesForceCommerceCloudPage().isExpectedPage();
    }

}
