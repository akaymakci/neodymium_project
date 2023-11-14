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
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").shouldHaveSize(13);
        // Asserts headlines
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.weAreHiring"))).should(exist);
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.startUp"))).should(exist);
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.workLife"))).should(exist);
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.commitment"))).should(exist);
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.careerDevelopment"))).should(exist);
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.international"))).should(exist);
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.roomForCreativity"))).should(exist);
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.greatLocations"))).should(exist);
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.valuableInternships"))).should(exist);
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.openPositions"))).should(exist);
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.cambridge"))).should(exist);
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.jena"))).should(exist);
        jobsOverviewContainer.findAll("h1, div.caption h2, div.caption h3, h2, p.locations").findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.erfurt"))).should(exist);

        // Validates Headlines' subtexts are there
        jobsOverviewContainer.findAll("[class*='col-md'] p[class='lead'], p.explanation").shouldHaveSize(9);

        // Validates Headlines icons are there
        jobsOverviewContainer.findAll("h3 i").shouldHaveSize(8);

        // Validates Listings are there
        jobsOverviewContainer.findAll("p.locations i").shouldHaveSize(3);
        jobsOverviewContainer.findAll("ul li").shouldHaveSize(9);
        jobsOverviewContainer.findAll("ul li a").shouldHaveSize(9);

        // Asserts Job Links
//        System.out.println(jobsOverviewContainer.find("ul li a").getAttribute("href"));
        jobsOverviewContainer.findAll("ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.cambridge.qaEngineerLink"))).should(exist);
        jobsOverviewContainer.findAll("ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.jena.lastUndPerformanceTesterLink"))).should(exist);
        jobsOverviewContainer.findAll("ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.jena.javaEntwicklerLink"))).should(exist);
        jobsOverviewContainer.findAll("ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.jena.technischerMarketingExperteLink"))).should(exist);
        jobsOverviewContainer.findAll("ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.jena.technischerAutorLink"))).should(exist);
        jobsOverviewContainer.findAll("ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.jena.technischerTesterLink"))).should(exist);
        jobsOverviewContainer.findAll("ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.jena.spezialistFürTestAutomatisierungLink"))).should(exist);
        jobsOverviewContainer.findAll("ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.erfurt.technischerTesterLink"))).should(exist);
        jobsOverviewContainer.findAll("ul li a").findBy(attribute("href",Neodymium.localizedText("careerPage.openPositions.locations.erfurt.lastUndPerformanceTesterLink"))).should(exist);

        // Validates Jobs Background is there?
        jobsBackground.should(exist);

        // Asserts the text on the Job Background
        jobsBackground.findAll("p").findBy(exactText(Neodymium.localizedText("careerPage.jobsBackground.title"))).should(exist);








    }

}
