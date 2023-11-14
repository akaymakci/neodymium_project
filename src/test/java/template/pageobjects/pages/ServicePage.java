package template.pageobjects.pages;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ServicePage extends AbstractPageObject{
    public SelenideElement servicesElement = $(".services");

    @Step("ensure this is a Service Page")
    @Override
    public ServicePage isExpectedPage() {
        super.isExpectedPage();
        servicesElement.should(exist);
        return this;
    }
    @Step("validate the service page")
    public void validateStructure()
    {
        var teaserContainer = $("#teaser");
        var testGuidanceContainer =$("#test-guidance");
        var functionalTestingContainer =$("#functional-testing");
        var performanceTestingContainer = $("#performance-testing");

        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();

        // Validates services
        $(".services").should(exist);

        // validate teaser
        $("#teaser").should(exist);

        // Asserts teaser text there.
        teaserContainer.findAll("h1").findBy(matchText("[A-Z].{3,}")).should(exist);
        teaserContainer.findAll("h1").findBy(exactText(Neodymium.localizedText("servicePage.overview.teaser.headline"))).should(exist);


        // Verifies service section
        $$(".service-section div[class*='col-md']").shouldHave(sizeGreaterThan(0));

        // Validates Functional Testing
        // Validates Pictures are there
        functionalTestingContainer.findAll("i").shouldHaveSize(2);

        //Asserts Headlines text are there
        functionalTestingContainer.findAll("h2").findBy(exactText(Neodymium.localizedText("servicePage.overview.functionalTesting.manualTesting"))).should(exist);
        functionalTestingContainer.findAll("h2").findBy(exactText(Neodymium.localizedText("servicePage.overview.functionalTesting.automatedTesting"))).should(exist);

        //Validates Headlines are there
        functionalTestingContainer.findAll("p.lead").shouldHaveSize(2);

        //Validates Texts are there
        functionalTestingContainer.findAll("p.lead+p").shouldHaveSize(2);

        // Validates Load and Performance Testing
        // Validates Pictures are there
        performanceTestingContainer.findAll("i").shouldHaveSize(1);

        //Asserts Headline's texts are there
        performanceTestingContainer.findAll("h2").findBy(exactText(Neodymium.localizedText("servicePage.overview.performanceTesting.loadUndPerformanceTesting"))).should(exist);
        performanceTestingContainer.findAll("h3").findBy(exactText(Neodymium.localizedText("servicePage.overview.performanceTesting.subHeader.serverSidePerformanceTesting"))).should(exist);
        performanceTestingContainer.findAll("h3").findBy(exactText(Neodymium.localizedText("servicePage.overview.performanceTesting.subHeader.clientSidePerformanceTesting"))).should(exist);

        //Validates Headlines' subtexts are there
        performanceTestingContainer.findAll("p.lead, h3+p").shouldHaveSize(3);

        //Validates Texts are there
        performanceTestingContainer.findAll("h3+p").shouldHaveSize(2);

        //Asserts Bullet points number
        performanceTestingContainer.findAll("li").shouldHaveSize(6);

        //Validates Texts are there
        performanceTestingContainer.findAll("li").findBy(matchText("[A-Z].{3,}")).should(exist);

        // Validates Test Guidance
        // Validates Pictures are there
        testGuidanceContainer.find("i").should(exist);

        //Asserts Headlines text are there
        testGuidanceContainer.find("h2").shouldHave(exactText(Neodymium.localizedText("servicePage.overview.testGuidance"))).should(exist);

        //Validates Headlines are there
        testGuidanceContainer.find("p.lead").should(exist);

        //Validates Texts are there
        testGuidanceContainer.find("p.lead+p").should(exist);

        //Validates subnavigation
        validateSubCategories();

    }
    public void validateSubCategories(){
        topNavigation.validateSubCategoryByLocalizationPath("header.topNavigation.subNavigation.services.salesforce");
        topNavigation.validateSubCategoryByLocalizationPath("header.topNavigation.subNavigation.services.overview");
    }
    public SalesForceCommerceCloudPage goToSalesForceCommerceCloudPage(){
        topNavigation.clickSubCategory(Neodymium.localizedText("header.topNavigation.subNavigation.services.salesforce"));
        return new SalesForceCommerceCloudPage().isExpectedPage();
    }

}
