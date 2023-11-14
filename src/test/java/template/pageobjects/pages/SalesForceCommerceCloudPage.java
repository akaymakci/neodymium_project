package template.pageobjects.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SalesForceCommerceCloudPage extends AbstractPageObject{

    @Step("ensure this is a Service Page")
    @Override
    public SalesForceCommerceCloudPage isExpectedPage() {
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

        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();
        servicePage.validateSubCategories();

        // Validates Salesforce Commerce Cloud
        $(".demandware-testing").should(exist);

        // validate teaser
        demandWareContainer.find("#teaser").should(exist);

        // Asserts the first headline is there.
        $("#text h1").shouldBe(matchText("[A-Z].{10,}"));
        demandWareContainer.find("#teaser h1").shouldHave(exactText(Neodymium.localizedText("servicePage.salesforce.teaser.headline")));

        // Asserts salesforce link
        demandWareContainer.find("#teaser a").shouldHave(attribute("href",Neodymium.localizedText("servicePage.salesforce.teaser.link")));

        // Validates Salesforce Pictures are there
        $$("[src*='scc-logo']").shouldHaveSize(2);

        // Asserts salesforce link title
        demandWareContainer.find("#teaser a img").shouldHave(attribute("title",Neodymium.localizedText("servicePage.salesforce.teaser.linkTitle")));

        // Validates Intro headline is there
        morePaddingContainer.find(".text-center h1").shouldHave(matchText("[A-Z].{3,}"));

        // Asserts Intro headline
        morePaddingContainer.find(".text-center h1").shouldHave(exactText(Neodymium.localizedText("servicePage.salesforce.intro.headline")));

        // Validates Intro headline is there
        morePaddingContainer.find(".text-center p").shouldHave(matchText("[A-Z].{37,}"));

        // Verifies DemandWare Sections are there
        dwOverviewContainer.findAll("[class*='col-sm']").shouldHaveSize(2);

        // Validates E-commerce Testing's Picture is there
        dwOverviewContainer.findAll("[class*='col-sm'] i").shouldHaveSize(1);

        // Asserts Headlines Text
        dwOverviewContainer.findAll("h2").findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.eCommerce"))).should(exist);
        dwOverviewContainer.findAll("h2").findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.weKnow"))).should(exist);
        dwOverviewContainer.findAll("h2").findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.functionalTesting"))).should(exist);
        dwOverviewContainer.findAll("h2").findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.agileTesting"))).should(exist);
        dwOverviewContainer.findAll("h2").findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.loadAndPerformance"))).should(exist);
        dwOverviewContainer.findAll("h2").findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.testAutomation"))).should(exist);

        // Validates Fact Tables are there
        dwOverviewContainer.findAll("td.key").shouldHaveSize(2);
        dwOverviewContainer.findAll("td.value").shouldHaveSize(2);

        // Validates Texts are there
        dwOverviewContainer.findAll("p.lead").shouldHaveSize(5);
        dwOverviewContainer.findAll("p.lead, p.lead~p, p.lead~ul").shouldHaveSize(11);
    }

}
