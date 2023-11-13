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
//    public SelenideElement dwOverviewContainer = $("#dw-overview");
    public ElementsCollection introElementsCollection = $$("#dw-overview .container [class*='col-sm'] h2");
    public SelenideElement demandWareContainer = $("#demandware");
    public SelenideElement morePaddingContainer = $(".more-padding");
    var dwOverviewContainer = $("#dw-overview");

    @Step("ensure this is a Service Page")
    @Override
    public SalesForceCommerceCloudPage isExpectedPage() {
        super.isExpectedPage();
//        dwOverviewContainer.should(exist);
        return this;
    }
    @Step("validate the Sales Force Commerce Cloud page")
    public void validateStructure()
    {
        var dwOverviewContainer = $("#dw-overview");
        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();
        subNavigation.validateStructure();

        // Validates Salesforce Commerce Cloud
        $(".demandware-testing").should(exist);

        // validate teaser
//        $("#demandware #teaser").should(exist);
        demandWareContainer.find("#teaser").should(exist);

        // Asserts the first headline is there.
        $("#text h1").shouldBe(matchText("[A-Z].{10,}"));
//        $("#demandware #teaser h1").shouldHave(exactText(Neodymium.localizedText("servicePage.salesforce.teaser.headline")));
        demandWareContainer.find("#teaser h1").shouldHave(exactText(Neodymium.localizedText("servicePage.salesforce.teaser.headline")));

        // Asserts salesforce link
//        $("#demandware #teaser a").shouldHave(attributeMatching("href","(?<=\")(\\S+)(?<!\")"),exactText(Neodymium.localizedText("servicePage.salesforce.teaser.link")));
//        $("#demandware #teaser a").shouldHave(attribute("href",Neodymium.localizedText("servicePage.salesforce.teaser.link")));
        demandWareContainer.find("#teaser a").shouldHave(attribute("href",Neodymium.localizedText("servicePage.salesforce.teaser.link")));
        // Validates Salesforce Pictures are there
        $$("[src*='scc-logo']").shouldHaveSize(2);

        // Asserts salesforce link title
//        $("#demandware #teaser a img").shouldHave(attribute("title",Neodymium.localizedText("servicePage.salesforce.teaser.linkTitle")));
        demandWareContainer.find("#teaser a img").shouldHave(attribute("title",Neodymium.localizedText("servicePage.salesforce.teaser.linkTitle")));

        // Validates Intro headline is there
//        $(".more-padding .container .text-center h1").shouldBe(matchText("[A-Z].{3,}"));
        morePaddingContainer.find(".text-center h1").shouldHave(matchText("[A-Z].{3,}"));
        // Asserts Intro headline
//        $(".more-padding .container .text-center h1").shouldHave(exactText(Neodymium.localizedText("servicePage.salesforce.intro.headline")));
        morePaddingContainer.find(".text-center h1").shouldHave(exactText(Neodymium.localizedText("servicePage.salesforce.intro.headline")));
        // Validates Intro headline is there
        $(".more-padding .container .text-center p").shouldBe(matchText("[A-Z].{37,}"));
        morePaddingContainer.find(".text-center p").shouldHave(matchText("[A-Z].{37,}"));

        // Verifies DemandWare Sections are there
//        $$("#dw-overview .container [class*='col-sm']").shouldHave(size(2));
        dwOverviewContainer.findAll("> div[class] > div[class]").shouldHaveSize(2);

        // Validates E-commerce Testing's Picture is there
//        $$("#dw-overview .container [class*='col-sm'] i").shouldHaveSize(1);
        dwOverviewContainer.findAll("> div[class] > div[class] i").shouldHaveSize(1);
        // Asserts Headlines Text
        introElementsCollection.findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.eCommerce"))).should(exist);
        introElementsCollection.findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.weKnow"))).should(exist);
        introElementsCollection.findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.functionalTesting"))).should(exist);
        introElementsCollection.findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.agileTesting"))).should(exist);
        introElementsCollection.findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.loadAndPerformance"))).should(exist);
        introElementsCollection.findBy(exactText(Neodymium.localizedText("servicePage.salesforce.intro.testAutomation"))).should(exist);

        // Validates Fact Tables are there
//        $$("#dw-overview .container [class*='col-sm'] td.key").shouldHaveSize(2);
        dwOverviewContainer.findAll("td.key").shouldHaveSize(2);
//        $$("#dw-overview .container [class*='col-sm'] td.value").shouldHaveSize(2);
        dwOverviewContainer.findAll("td.value").shouldHaveSize(2);
        // Validates Texts are there
//        $$("#dw-overview .container [class*='col-sm'] p.lead").shouldHaveSize(5);
        dwOverviewContainer.findAll("p.lead").shouldHaveSize(5);
//        $$("#dw-overview .container [class*='col-sm'] p.lead, p.lead~p, p.lead~ul").shouldHaveSize(11);
        dwOverviewContainer.findAll("p.lead, p.lead~p, p.lead~ul").shouldHaveSize(11);
    }

}
