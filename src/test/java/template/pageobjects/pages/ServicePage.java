package template.pageobjects.pages;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import template.pageobjects.components.SubNavigation;

import static com.codeborne.selenide.CollectionCondition.size;
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
        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();

        // Validates Sub-Navigation Categories
        subNavigation.validateStructure();

        // Validates services
        $(".services").should(exist);

        // validate teaser
        $("#teaser").should(exist);

        // Asserts teaser text there.
        $("#teaser h1").shouldBe(matchText("[A-Z].{3,}"));
        $("#teaser h1").shouldHave(exactText(Neodymium.localizedText("servicePage.overview.teaser.headline")));

        // Verifies service section
        $$(".service-section div[class*='col-md']").shouldHave(sizeGreaterThan(0));

        // Validates Functional Testing
        // Validates Pictures are there
        $$("#functional-testing  .container div[class*='col-md'] i").shouldHaveSize(2);

        //Asserts Headlines text are there
        $$("#functional-testing  .container div[class*='col-md'] h2").findBy(exactText(Neodymium.localizedText("servicePage.overview.functionalTesting.1.title"))).should(exist);
        $$("#functional-testing  .container div[class*='col-md'] h2").findBy(exactText(Neodymium.localizedText("servicePage.overview.functionalTesting.2.title"))).should(exist);

        //Validates Headlines are there
        $$("#functional-testing  .container div[class*='col-md'] p.lead").shouldHaveSize(2);
//        $("#functional-testing  .container div[class*='col-md']:nth-child(2) p.lead").shouldHave(matchText("[A-Z].{13,}"));
//        $("#functional-testing  .container div[class*='col-md']:nth-child(4) p.lead").shouldHave(matchText("[A-Z].{15,}"));

        //Validates Texts are there
        $$("#functional-testing  .container div[class*='col-md'] p:nth-child(2)").shouldHaveSize(2);
//        $("#functional-testing  .container div[class*='col-md']:nth-child(2) p:nth-child(2)").shouldHave(matchText("[A-Z].{35,}"));
//        $("#functional-testing  .container div[class*='col-md']:nth-child(4) p:nth-child(2)").shouldHave(matchText("[A-Z].{42,}"));

        // Validates Load and Performance Testing
        // Validates Pictures are there
        $$("#functional-testing  .container div[class*='col-md'] i").shouldHaveSize(2);

        //Asserts Headline's texts are there
        $$("#performance-testing  .container div[class*='col-md'] h2").findBy(exactText(Neodymium.localizedText("servicePage.overview.performanceTesting.1.title"))).should(exist);
        $$("#performance-testing  .container div[class*='col-md'] h3").findBy(exactText(Neodymium.localizedText("servicePage.overview.performanceTesting.1.subHeading.1.title"))).should(exist);
        $$("#performance-testing  .container div[class*='col-md'] h3").findBy(exactText(Neodymium.localizedText("servicePage.overview.performanceTesting.1.subHeading.2.title"))).should(exist);

        //Validates Headlines' subtexts are there
        $$("#performance-testing .container div[class*='col-md'] p.lead, h3+p:not([class*='meta'])").shouldHaveSize(3);

        //Validates Texts are there
        $$("#performance-testing  .container div[class*='col-sm'] h3+p").shouldHaveSize(2);
//        $("#performance-testing  .container div[class*='col-sm'] h3+p").shouldHave(matchText("[A-Z].{42,}"));

        //Asserts Bullet points number
        $$("#performance-testing div[class*='col-left'] li").shouldHave(size(6));

        //Validates Texts are there
        $$("#performance-testing div[class*='col-left'] li").findBy(matchText("[A-Z].{3,}")).should(exist);

        // Validates Test Guidance
        // Validates Pictures are there
        $$("#test-guidance  .container div[class*='col-md'] i").shouldHaveSize(1);

        //Asserts Headlines text are there
        $$("#test-guidance  .container div[class*='col-md'] h2").findBy(exactText(Neodymium.localizedText("servicePage.overview.testGuidance.1.title"))).should(exist);

        //Validates Headlines are there
        $$("#test-guidance  .container div[class*='col-md']:nth-child(2) p.lead").shouldHaveSize(1);

        //Validates Texts are there
        $$("#test-guidance  .container div[class*='col-md']:nth-child(2) p:nth-child(2)").shouldHaveSize(1);

//        subNavigation.clickSubNavigation("header.topNavigation.subNavigation.services.salesforce.title");


    }

}
