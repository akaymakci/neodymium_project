package template.pageobjects.pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.xceptance.neodymium.util.Neodymium;

import io.qameta.allure.Step;

public class CareerPage extends AbstractPageObject
{

    @Step("ensure this is a Career Page")
    @Override
    public CareerPage isExpectedPage()
    {
        var jobsElement = $(".jobs");
        super.isExpectedPage();
        jobsElement.should(exist);
        return this;
    }

    @Override
    @Step("validate the career page")
    public void validateStructure()
    {
        var jobsOverviewContainer = $("#jobs-overview");
        var jobsBackground = $("#jobs-background");

        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();

        // validates teaser image is there
        $(".teaser-image").shouldBe(visible);
        var jobsOverviewContainerCaptions = $$(jobsOverviewContainer.getSearchCriteria() + " h1, div.caption h2, div.caption h3, h2, p.locations");
        // validates headlines are there
        jobsOverviewContainerCaptions.shouldHaveSize(13);

        // Asserts headlines
        var jobsOverviewH1 = $$(jobsOverviewContainer.getSearchCriteria() + " h1");
        var jobsOverviewH2 = $$(jobsOverviewContainer.getSearchCriteria() + " h2");
        var jobsOverviewDivCaptionH3 = $$(jobsOverviewContainer.getSearchCriteria() + " div.caption h3");
        var jobsOverviewPLocations = $$(jobsOverviewContainer.getSearchCriteria() + " p.locations");

        jobsOverviewH1.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.weAreHiring"))).shouldBe(visible);
        jobsOverviewDivCaptionH3.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.startUp"))).shouldBe(visible);
        jobsOverviewDivCaptionH3.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.workLife"))).shouldBe(visible);
        jobsOverviewDivCaptionH3.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.commitment"))).shouldBe(visible);
        jobsOverviewDivCaptionH3.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.careerDevelopment"))).shouldBe(visible);
        jobsOverviewDivCaptionH3.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.international"))).shouldBe(visible);
        jobsOverviewDivCaptionH3.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.roomForCreativity"))).shouldBe(visible);
        jobsOverviewDivCaptionH3.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.greatLocations"))).shouldBe(visible);
        jobsOverviewDivCaptionH3.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.valuableInternships"))).shouldBe(visible);
        jobsOverviewH2.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.openPositions"))).shouldBe(visible);
        jobsOverviewPLocations.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.cambridge"))).shouldBe(visible);
        jobsOverviewPLocations.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.jena"))).shouldBe(visible);
        jobsOverviewPLocations.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.erfurt"))).shouldBe(visible);

        // Validates Headlines' subtexts are there
        var jobsOverviewH1PLead = $$(jobsOverviewContainer.getSearchCriteria() + " h1+p.lead");
        var jobsOverviewPExplanation = $$(jobsOverviewContainer.getSearchCriteria() + " p.explanation");
        jobsOverviewH1PLead.shouldHaveSize(1);
        jobsOverviewPExplanation.shouldHaveSize(8);

        // Validates Headlines icons are there
        var jobsOverviewH3I = $$(jobsOverviewContainer.getSearchCriteria() + " h3 i");
        jobsOverviewH3I.shouldHaveSize(8);

        // Validates Listings are there
        var jobsOverviewPLocationsI = $$(jobsOverviewContainer.getSearchCriteria() + " p.locations i");
        jobsOverviewPLocationsI.shouldHaveSize(3);
        var jobsOverviewUlLi = $$(jobsOverviewContainer.getSearchCriteria() + " ul li");
        jobsOverviewUlLi.shouldHaveSize(9);
        var jobsOverviewUlLiA = $$(jobsOverviewContainer.getSearchCriteria() + " ul li a");
        jobsOverviewUlLiA.shouldHaveSize(9);

        // Asserts Job Links
        // System.out.println(jobsOverviewContainer.find("ul li a").getAttribute("href"));
        jobsOverviewUlLiA.findBy(exactText(Neodymium.localizedText("careerPage.openPositions.locations.cambridge.qaEngineerLink"))).shouldBe(visible);
        jobsOverviewUlLiA.findBy(exactText(Neodymium.localizedText("careerPage.openPositions.locations.jena.lastUndPerformanceTesterLink"))).shouldBe(visible);
        jobsOverviewUlLiA.findBy(exactText(Neodymium.localizedText("careerPage.openPositions.locations.jena.javaEntwicklerLink"))).shouldBe(visible);
        jobsOverviewUlLiA.findBy(exactText(Neodymium.localizedText("careerPage.openPositions.locations.jena.technischerMarketingExperteLink")))
                         .shouldBe(visible);
        jobsOverviewUlLiA.findBy(exactText(Neodymium.localizedText("careerPage.openPositions.locations.jena.technischerAutorLink"))).shouldBe(visible);
        jobsOverviewUlLiA.findBy(exactText(Neodymium.localizedText("careerPage.openPositions.locations.jena.technischerTesterLink"))).shouldBe(visible);
        jobsOverviewUlLiA.findBy(exactText(Neodymium.localizedText("careerPage.openPositions.locations.jena.spezialistFürTestAutomatisierungLink")))
                         .shouldBe(visible);
        jobsOverviewUlLiA.findBy(exactText(Neodymium.localizedText("careerPage.openPositions.locations.erfurt.technischerTesterLink"))).shouldBe(visible);
        jobsOverviewUlLiA.findBy(exactText(Neodymium.localizedText("careerPage.openPositions.locations.erfurt.lastUndPerformanceTesterLink")))
                         .shouldBe(visible);

        System.out.println(jobsOverviewUlLiA);

        // Validates Jobs Background is there?
        jobsBackground.shouldBe(visible);

        // Asserts the text on the Job Background
        $$(jobsBackground.getSearchCriteria() + " p").findBy(exactText(Neodymium.localizedText("careerPage.jobsBackground.title"))).shouldBe(visible);

    }

}
