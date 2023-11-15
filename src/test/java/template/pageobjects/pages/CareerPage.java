package template.pageobjects.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class CareerPage extends AbstractPageObject {

    @Step("ensure this is a Career Page")
    @Override
    public CareerPage isExpectedPage() {
        var jobsElement = $(".jobs");
        super.isExpectedPage();
        jobsElement.should(exist);
        return this;
    }


    @Step("validate the career page")
    public void validateStructure()
    {
        var jobsOverviewContainer = $("#jobs-overview");
        var jobsBackground = $("#jobs-background");

        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();

        // validates teaser image is there
        $(".teaser-image").shouldBe(visible);

        // validates headlines are there
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").shouldHaveSize(13);

        // Asserts headlines
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.weAreHiring"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.startUp"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.workLife"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.commitment"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.careerDevelopment"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.international"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.roomForCreativity"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.greatLocations"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.valuableInternships"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.openPositions"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.cambridge"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.jena"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.erfurt"))).shouldBe(visible);

        // Validates Headlines' subtexts are there
        $$(jobsOverviewContainer.getSearchCriteria() +" h1+p.lead, p.explanation").shouldHaveSize(9);

        // Validates Headlines icons are there
        $$(jobsOverviewContainer.getSearchCriteria() +" h3 i").shouldHaveSize(8);

        // Validates Listings are there
        $$(jobsOverviewContainer.getSearchCriteria() +" p.locations i").shouldHaveSize(3);
        $$(jobsOverviewContainer.getSearchCriteria() +" ul li").shouldHaveSize(9);
        $$(jobsOverviewContainer.getSearchCriteria() +" ul li a").shouldHaveSize(9);

        // Asserts Job Links
//        System.out.println(jobsOverviewContainer.find("ul li a").getAttribute("href"));
        $$(jobsOverviewContainer.getSearchCriteria() +" ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.cambridge.qaEngineerLink"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.jena.lastUndPerformanceTesterLink"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.jena.javaEntwicklerLink"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.jena.technischerMarketingExperteLink"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.jena.technischerAutorLink"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.jena.technischerTesterLink"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.jena.spezialistFürTestAutomatisierungLink"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.erfurt.technischerTesterLink"))).shouldBe(visible);
        $$(jobsOverviewContainer.getSearchCriteria() +" ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.erfurt.lastUndPerformanceTesterLink"))).shouldBe(visible);

        // Validates Jobs Background is there?
        jobsBackground.shouldBe(visible);

        // Asserts the text on the Job Background
        $$(jobsBackground.getSearchCriteria() + " p").findBy(exactText(Neodymium.localizedText("careerPage.jobsBackground.title"))).shouldBe(visible);








    }

}
